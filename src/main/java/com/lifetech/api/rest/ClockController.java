package com.lifetech.api.rest;

import com.lifetech.application.dto.ClockDTO;
import com.lifetech.application.dto.ClockDetailDTO;
import com.lifetech.application.manager.ClockManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClockController extends RestBaseController {

    private final ClockManager clockManager;

    public ClockController(ClockManager clockManager) {
        this.clockManager = clockManager;
    }

    @GetMapping("clock/find/{id}")
    private ClockDTO findClock(@PathVariable("id") String id){
        return clockManager.findById(id);
    }

    @GetMapping("clock/{id}")
    private ClockDTO findById(@PathVariable("id") String id){
        return clockManager.findById(id);
    }

    @GetMapping("clock/findByRoom/{id}")
    private List<ClockDTO> findByRoom(@PathVariable("id") String id){ return clockManager.findByRoom(id); }

    @PutMapping("clock/updateClock/{id}")
    public ClockDTO updateClock (@PathVariable(value = "id") String id,
                                     @Valid @RequestBody ClockDTO clockDtoReceived) {
        return clockManager.updateClock(id, clockDtoReceived);

    }


    @GetMapping("clock/findHistoric/{id}")
    private ClockDetailDTO findByHistoric(@PathVariable("id") String id) {
        return clockManager.findByHistoric(id);
    }
}
