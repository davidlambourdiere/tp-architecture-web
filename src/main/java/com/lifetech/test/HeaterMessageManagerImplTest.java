package com.lifetech.test;

import com.lifetech.application.dto.HeaterMessageDTO;
import com.lifetech.application.manager.HeaterMessageManagerImpl;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.HeaterDAO;
import com.lifetech.domain.dao.HeaterMessageDAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeaterMessageManagerImplTest {

    @Test
    public void shouldReturnLastMessageFromDataBase(){
        
        //HeaterMessageManagerImpl heaterMessageManager = new HeaterMessageManagerImpl(heaterdao,heatermessagedao,orikaBeanMapper);

        //HeaterMessageDTO output = heaterMessageManager.findFirstByOrderByInsertDateDesc();

        //assertEquals(expectedOutput, output);
    }
}