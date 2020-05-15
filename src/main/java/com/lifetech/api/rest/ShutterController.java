package com.lifetech.api.rest;

import com.lifetech.application.dto.ShutterDTO;
import com.lifetech.application.dto.ShutterDetailDTO;
import com.lifetech.application.manager.ShutterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;


@RestController
public class ShutterController extends RestBaseController{

    private final ShutterManager shutterManager;

    public ShutterController(ShutterManager shutterManager) {
        this.shutterManager = shutterManager;
    }

    @PutMapping("shutter/updateShutter/{id}")
    public ShutterDTO updateShutter (@PathVariable(value = "id") String id,
                                 @Valid @RequestBody ShutterDTO shutterDtoReceived) {
        return shutterManager.updateShutter(id, shutterDtoReceived);

    }

    @GetMapping("shutter/findByRoom/{id}")
    private List<ShutterDTO> findByRoom(@PathVariable("id") String id){ return shutterManager.findByRoom(id); }

}
