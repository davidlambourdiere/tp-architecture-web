package com.lifetech.api.rest;


import com.lifetech.application.dto.ExtraCostDTO;
import com.lifetech.application.manager.MockIOTAndServiceManagerImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MockIOTAndServiceController extends RestBaseController {
    private final MockIOTAndServiceManagerImpl mockIOTAndServiceManager;

    public MockIOTAndServiceController(MockIOTAndServiceManagerImpl mockIOTAndServiceManager) {
        this.mockIOTAndServiceManager = mockIOTAndServiceManager;
    }


    @GetMapping("billing/mock/start")
    List<ExtraCostDTO> startMock(){ return mockIOTAndServiceManager.simulationExtra();
    }

}
