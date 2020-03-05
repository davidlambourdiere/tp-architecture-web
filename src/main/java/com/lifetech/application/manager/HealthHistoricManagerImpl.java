package com.lifetech.application.manager;

import com.lifetech.application.dto.AlertHealthDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.AlertHealthDAO;
import com.lifetech.domain.dao.HealthHistoricDAO;
import com.lifetech.domain.model.AlertHealth;
import com.lifetech.domain.model.HealthHistoric;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class HealthHistoricManagerImpl implements HealthHistoricManager {

    private final HealthHistoricDAO healthHistoricDAO;
    private final OrikaBeanMapper orikaBeanMapper;


    public HealthHistoricManagerImpl(OrikaBeanMapper orikaBeanMapper, HealthHistoricDAO healthHistoricDAO) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.healthHistoricDAO = healthHistoricDAO;
    }


    @Override
    public HealthHistoric save(HealthHistoric healthHistoric) {
        return healthHistoricDAO.save(healthHistoric);
    }

    @Override
    public HealthHistoric split(String message) {
        String [] titles = message.split(",");
        HealthHistoric h = new HealthHistoric();
        for (String title: titles) {
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
                    h.setStrapId(Long.parseLong(values[1]));
                    break;
                case "startdate":
                    h.setStartdate(Timestamp.valueOf(values[1]));
                    break;
            }

        }
        return h;
    }
}
