package com.lifetech.application.manager;

import com.lifetech.application.dto.StrapDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.HealthHistoricDAO;
import com.lifetech.domain.model.AlertCache;
import com.lifetech.domain.model.AlertHealth;
import com.lifetech.domain.model.HealthHistoric;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Clock;
import java.util.*;

@Service
public class HealthHistoricManagerImpl implements HealthHistoricManager {

    private final HealthHistoricDAO healthHistoricDAO;
    private final StrapManager strapManager;
    private final OrikaBeanMapper orikaBeanMapper;
    private final AlertHealthManagerImpl alertHealthManagerImpl;

    public HealthHistoricManagerImpl(OrikaBeanMapper orikaBeanMapper, HealthHistoricDAO healthHistoricDAO, StrapManager strapManager, AlertHealthManagerImpl alertHealthManagerImpl) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.healthHistoricDAO = healthHistoricDAO;
        this.strapManager = strapManager;
        this.alertHealthManagerImpl = alertHealthManagerImpl;
    }


    @Override
    public HealthHistoric save(HealthHistoric healthHistoric) {
        return healthHistoricDAO.save(healthHistoric);
    }

    @Override
    public HealthHistoric split(String message) {
        String[] titles = message.split(",");
        HealthHistoric h = new HealthHistoric();
        for (String title : titles) {
            String[] values = title.split("=");
            switch (values[0]) {
                case "hearthrate":
                    h.setHearthrate(values[1]);
                    break;
                case "systolic":
                    h.setSystolic(values[1]);
                    break;
                case "diastolic":
                    h.setDiastolic(values[1]);
                    break;
                case "sugarlevel":
                    h.setSugarlevel(values[1]);
                    break;
                case "stepcounter":
                    h.setStepcounter(values[1]);
                    break;
                case "strapid":
                    h.setStrap(Long.parseLong(values[1]));
                    break;
                case "startdate":
                    h.setStartdate(Timestamp.valueOf(values[1]));
                    break;
            }

        }
        return h;
    }

    @Override
    public boolean alertDetection(HealthHistoric histSaved, Map<Long, Map<String, AlertCache>> cache) {
        int cpt = 0;
        boolean isAlerte =  false;
        //find strap
        StrapDTO sdto = strapManager.findById(String.valueOf(histSaved.getStrap()));
        //update cache
        Map<String, AlertCache> values = new HashMap<>();
        values.put("HR", new AlertCache(0,new ArrayList<>()));
        if (cache.containsKey(sdto.getId())) {
            values = cache.get(sdto.getId());
        } else {
            cache.put(sdto.getId(), values);
        }
        AlertCache nbHRAlert = values.get("HR");
        //find if the last hearthRate is in alert
        if (Integer.parseInt(histSaved.getHearthrate()) <= Integer.parseInt(sdto.getMaxvalueref())){
            //set hearthrate alert on zero
            values.replace("HR", nbHRAlert, new AlertCache(0,new ArrayList<>()));
            //set status alert on done if it exists
            if(nbHRAlert.getAlertId().size()>0) {
                AlertHealth alertHealth = alertHealthManagerImpl.findById(nbHRAlert.getAlertId().get(nbHRAlert.getAlertId().size()-1));
                alertHealth.setStatus("DONE");
                alertHealth.setEnddate(new Timestamp(new Date().getTime()));
                alertHealthManagerImpl.save(alertHealth);
            }
            //update healthstate of strap
            sdto.setHealthstate("OK");
            strapManager.save(sdto);
        }
        else {
            //find 3 last hearthRate historic
            List<HealthHistoric> hlist = healthHistoricDAO.findByStrap(histSaved.getStrap());
            List<HealthHistoric> hsub = hlist.subList(Math.max(hlist.size() - 3, 0), hlist.size());
            //find if hearthistoric is in alert
            for (HealthHistoric h : hsub) {
                if (Integer.parseInt(h.getHearthrate()) > Integer.parseInt(sdto.getMaxvalueref()) || Integer.parseInt(h.getHearthrate()) < Integer.parseInt(sdto.getMinvalueref()))
                    cpt++;
            }
            //if there is an alert (hearthistoric is higher or lower 3 times in a row)
            if (cpt == 3) {

                if (nbHRAlert.getNbAlert() == 0) {
                    AlertHealth alertFC = new AlertHealth();
                    alertFC.setStrap(sdto.getId());
                    alertFC.setStartdate(new Timestamp(new Date().getTime()));
                    alertFC.setStatus("NEW");
                    alertFC.setCriticity("3");
                    alertFC.setMessage("HIGH HEARTHRATE");
                    AlertHealth al = alertHealthManagerImpl.save(alertFC);
                    System.err.println(al);
                    nbHRAlert.getAlertId().add(String.valueOf(al.getId()));

                    //update healthstate of strap
                    sdto.setHealthstate("KO");
                    strapManager.save(sdto);
                }
                isAlerte = true;
                //increment nbAlert
                AlertCache newNbAlert = new AlertCache(nbHRAlert.getNbAlert(), nbHRAlert.getAlertId());
                newNbAlert.setNbAlert(nbHRAlert.getNbAlert()+1);
                values.replace("HR", nbHRAlert,newNbAlert);
            }
        }
        return isAlerte;
    }
}
