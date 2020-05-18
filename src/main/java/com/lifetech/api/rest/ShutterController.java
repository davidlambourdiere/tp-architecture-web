package com.lifetech.api.rest;

import com.lifetech.application.dto.ShutterDTO;
import com.lifetech.application.dto.ShutterDetailDTO;
import com.lifetech.application.manager.ShutterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class ShutterController extends RestBaseController{

    private final ShutterManager shutterManager;

    public ShutterController(ShutterManager shutterManager) {
        this.shutterManager = shutterManager;
    }

    @GetMapping("shutter")
    private List<ShutterDTO> findAllShutter() {
        return shutterManager.findAllShutter();
    }

    @GetMapping("shutter/findByPerson/{idperson}")
    private List<ShutterDTO> findIOTByPerson(@PathVariable("idperson") String idperson) {
        return shutterManager.findShutterByPerson(idperson);
    }

    @GetMapping("shutter/{id}")
    private ShutterDTO findById(@PathVariable("id") String id){
        return shutterManager.findById(id);
    }

    @GetMapping("shutter/findHistoric/{id}")
    private ShutterDetailDTO findByHistoric(@PathVariable("id") String id) {
        return shutterManager.findByHistoric(id);
    }

    @PutMapping("shutter/updateShutter/{id}")
    public ShutterDTO updateShutter (@PathVariable(value = "id") String id,
                                     @Valid @RequestBody ShutterDTO shutterDtoReceived) {
        return shutterManager.updateShutter(id, shutterDtoReceived);

    }

    @GetMapping("shutter/findByRoom/{id}")
    private List<ShutterDTO> findByRoom(@PathVariable("id") String id){ return shutterManager.findByRoom(id); }

}
