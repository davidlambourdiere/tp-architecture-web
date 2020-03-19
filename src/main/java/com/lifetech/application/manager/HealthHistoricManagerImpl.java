package com.lifetech.application.manager;

import com.lifetech.application.dto.StrapDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.HealthHistoricDAO;
import com.lifetech.domain.model.AlertHealth;
import com.lifetech.domain.model.HealthHistoric;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public boolean alertDetection(HealthHistoric histSaved, Map<Long, Map<String, Integer>> cache) {
        int cpt = 0;
        boolean isAlerte =  false;
        //find strap
        StrapDTO sdto = strapManager.findById(String.valueOf(histSaved.getStrap()));
        //find 3 last hearthRate historic
        List<HealthHistoric> hlist = healthHistoricDAO.findByStrap(histSaved.getStrap());
        List<HealthHistoric> hsub = hlist.subList(Math.max(hlist.size() - 3, 0), hlist.size());

        for (HealthHistoric h : hsub) {
            if (Integer.parseInt(h.getHearthrate()) > Integer.parseInt(sdto.getMaxvalueref()))
                cpt++;
        }

        if (cpt == 3) {
            //update cache
            Map<String, Integer> values = new HashMap<>();
            values.put("HR", 0);
            if (cache.containsKey(sdto.getId())) {
                values = cache.get(sdto.getId());
            } else {
                cache.put(sdto.getId(), values);
            }
            Integer nbHRAlert =values.get("HR");
            if (nbHRAlert == 0) {
                AlertHealth alertFC = new AlertHealth();
                alertFC.setStrap(sdto.getId());
                alertFC.setStartdate(new Timestamp(new Date().getTime()));
                alertFC.setStatus("NEW");
                alertFC.setCriticity("3");
                alertFC.setMessage("HIGH HEARTHRATE");
                System.err.println(alertHealthManagerImpl.save(alertFC));
            }
            isAlerte = true;
            values.replace("HR", nbHRAlert, ++nbHRAlert);
        }
        return isAlerte;
    }
}
