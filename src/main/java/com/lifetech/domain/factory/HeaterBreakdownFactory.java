package com.lifetech.domain.factory;

import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.HeaterBreakdown;

import java.sql.Timestamp;
import java.time.Duration;

public interface HeaterBreakdownFactory {
    /**
     * Creates a heater breakdown with a random start date and a given max duration
     * @param heater a Heater object
     * @param lowerBound a Timestamp to which the start of the breakdown can't be less
     * @param maxDuration a given Duration that the breakdown can't exceed
     * @return the corresponding HeatherBreakdown
     * */
    HeaterBreakdown createRandomHeatherBreakdown(Heater heater, Timestamp lowerBound, Duration maxDuration);

    /**
     * Creates a heater breakdown with a random start date and a max duration of 1 day
     * @param heater a Heater object
     * @param lowerBound a Timestamp to which the start of the breakdown can't be less
     * @return the corresponding HeatherBreakdown
     * */
    HeaterBreakdown createRandomHeaterBreakdown(Heater heater, Timestamp lowerBound);

    HeaterBreakdown createHeaterBreakdown();

    HeaterBreakdown createHeaterBreakdown(String numheaterbreakdown, String startdateheaterbreakdown, String enddatebreakdown, String suspectheaterbreakdown, String stopheaterbreakdown, String messageheaterbreakdown, Heater iotheaterbreakdown);

}
