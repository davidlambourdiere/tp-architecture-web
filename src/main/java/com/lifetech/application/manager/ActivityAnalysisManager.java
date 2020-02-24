package com.lifetech.application.manager;

import com.lifetech.application.dto.ActivityAnalaysisDTO;

import java.util.Map;

public interface ActivityAnalysisManager {

    ActivityAnalaysisDTO countIOTByPerson(String personId);

    ActivityAnalaysisDTO countIOTByResidence(long residenceId);

    ActivityAnalaysisDTO countIOT();

    ActivityAnalaysisDTO getBreakdownRate();
}
