package com.lifetech.application.manager;

import java.util.Map;

public interface ActivityAnalysisManager {

    Map<String, Long> countIOTByPerson(long personId);

    Map<String, Long> countIOTByResidence(long residenceId);

    Map<String, Long> countIOT();
}
