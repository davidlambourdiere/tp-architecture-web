package com.lifetech.api.rest;

import com.lifetech.application.manager.MockForActivityAnalysisManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockForActivityAnalysisController extends RestBaseController{
    private final MockForActivityAnalysisManager mockForActivityAnalysisManager;

    public MockForActivityAnalysisController(MockForActivityAnalysisManager mockForActivityAnalysisManager) {
        this.mockForActivityAnalysisManager = mockForActivityAnalysisManager;
    }

    @GetMapping("analysis/mock/start")
    String startMock(){
        return mockForActivityAnalysisManager.mock();
    }
}
