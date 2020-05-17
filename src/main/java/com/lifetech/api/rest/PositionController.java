package com.lifetech.api.rest;

import com.lifetech.application.dto.PositionDTO;
import com.lifetech.application.manager.PositionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PositionController extends RestBaseController {
    private final PositionManager positionManager;

    public PositionController(PositionManager positionManager) {
        this.positionManager = positionManager;
    }

    /**
     * Route pour récupérer un bracelet via l'id
     *
     * @param strapId identifiant du bracelet
     *                methode GET
     * @return PositionDTO
     */
    @GetMapping("position/findByStrap/{id}")
    private PositionDTO findPositionByStrap(@PathVariable("id") long strapId) {
        return positionManager.findPositionByStrap(strapId);
    }

    /**
     * Route pour insérer les position pour tout les bracelets
     * methode GET
     *
     * @throws Exception
     */
    @GetMapping("position/insertPositionByStrap")
    private void insertPositionByStrapId() throws Exception {
        positionManager.insertPositionRunnerStrap();
    }

    /**
     * Route pour récupérer l'historique d'un bracelet
     *
     * @param strapId identifiant
     * methode GET
     * @return List<PositionDTO>
     */
    @GetMapping("position/positionHistory/{id}")
    private List<PositionDTO> positionHistory(@PathVariable("id") long strapId) {
        return positionManager.positionHistory(strapId);
    }


}

