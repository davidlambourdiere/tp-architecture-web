package com.lifetech.api.rest;

import com.lifetech.application.manager.MockForActivityAnalysisManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockForActivityAnalysisController extends RestBaseController{
    private final MockForActivityAnalysisManager mockForActivityAnalysisManager;

    public MockForActivityAnalysisController(MockForActivityAnalysisManager mockForActivityAnalysisManager) {
        this.mockForActivityAnalysisManager = mockForActivityAnalysisManager;
    }

    @GetMapping("analysis/mock/{nBreakdowns}")
    String startMock(@PathVariable("nBreakdowns") long nBreakdowns){
        return mockForActivityAnalysisManager.mock(nBreakdowns);
    }
}
