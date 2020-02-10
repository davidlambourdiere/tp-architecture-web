package com.lifetech.api.rest;

import com.lifetech.application.dto.HeaterMessageDTO;
import com.lifetech.application.manager.HeaterMessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeaterMessageController extends RestBaseController {

    private final HeaterMessageManager heaterMessageManager;
    
    public HeaterMessageController(HeaterMessageManager heaterMessageManager) {
        this.heaterMessageManager = heaterMessageManager;
    }

    @GetMapping("heatermessage/findHeaterMessageByHeater/{id}")
    private List<HeaterMessageDTO> findHeaterMessageByHeater(@PathVariable("id") String id){ return heaterMessageManager.findHeaterMessageByHeater(id); }

    @GetMapping("findFirstByOrderByInsertDateDesc")
    private HeaterMessageDTO findFirstByOrderByInsertDateDesc(){ return heaterMessageManager.findFirstByOrderByInsertDateDesc(); }

}
