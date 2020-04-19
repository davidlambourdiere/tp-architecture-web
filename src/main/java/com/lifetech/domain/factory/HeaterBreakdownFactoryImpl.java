package com.lifetech.domain.factory;

import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.HeaterBreakdown;
import com.lifetech.infrastructure.generator.RandomTimestampGenerator;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

public class HeaterBreakdownFactoryImpl implements HeaterBreakdownFactory {
    @Override
    public HeaterBreakdown createRandomHeatherBreakdown(Heater heater, Timestamp lowerBound, Duration maxDuration) {
        Timestamp startDatebBreakdown = RandomTimestampGenerator.between(lowerBound.toLocalDateTime(), LocalDateTime.now());
        Timestamp endDateBreakdown = RandomTimestampGenerator.between(startDatebBreakdown.toLocalDateTime(), startDatebBreakdown.toLocalDateTime().plus(maxDuration));
        HeaterBreakdown heaterBreakdown = new HeaterBreakdown();
        heaterBreakdown.setStartdateheaterbreakdown(startDatebBreakdown.toString());
        heaterBreakdown.setEnddatebreakdown(endDateBreakdown.toString());
        heaterBreakdown.setMessageheaterbreakdown("PANNE MOCKEE POUR TESTS DAVID");
        heaterBreakdown.setIotheaterbreakdown(heater);
        return heaterBreakdown;
    }

    @Override
    public HeaterBreakdown createRandomHeaterBreakdown(Heater heater, Timestamp lowerBound) {
        return createRandomHeatherBreakdown(heater, lowerBound, Duration.ofDays(1));
    }
    @Override
    public HeaterBreakdown createHeaterBreakdown () {
        return new HeaterBreakdown();
    }

    @Override
    public HeaterBreakdown createHeaterBreakdown (String numheaterbreakdown, String startdateheaterbreakdown, String enddatebreakdown, String suspectheaterbreakdown, String stopheaterbreakdown, String messageheaterbreakdown, Heater iotheaterbreakdown){
        return new HeaterBreakdown(numheaterbreakdown, startdateheaterbreakdown, enddatebreakdown, suspectheaterbreakdown, stopheaterbreakdown, messageheaterbreakdown, iotheaterbreakdown);
    }
}
