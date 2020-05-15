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

    @GetMapping("heaterMessages/findAllByHeater/{id}")
    private List<HeaterMessageDTO> findAllByHeater(@PathVariable("id") String id){ return heaterMessageManager.findAllByHeater(id); }

    //@GetMapping("findFirstByOrderByInsertDateDesc")
    //private HeaterMessageDTO findFirstByOrderByInsertDateDesc(){ return heaterMessageManager.findFirstByOrderByInsertDateDesc(); }

    @GetMapping("heaterMessages/breakdownDetection/{id}")
    private boolean breakdownDetection(@PathVariable("id") String id){ return heaterMessageManager.breakdownDetection(id); }

    @GetMapping("heaterMessages/suspectDetection/{id}")
    private boolean suspectDetection(@PathVariable("id") String id){ return heaterMessageManager.suspectDetection(id); }

}
