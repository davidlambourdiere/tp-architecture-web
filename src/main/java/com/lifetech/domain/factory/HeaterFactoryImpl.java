package com.lifetech.domain.factory;

import com.lifetech.domain.model.*;
import com.lifetech.infrastructure.generator.RandomTimestampGenerator;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class HeaterFactoryImpl implements HeaterFactory {

    @Override
    public Heater createHeater() {
        return new Heater();
    }

    @Override
    public Heater createRandomHeater(Person person, Room room, double p, Timestamp lowerBound) {
        Heater heater = new Heater();
        heater.setBreakdownstatus(randomBreakdownStatus(p));
        heater.setState(StateEnum.values()[ThreadLocalRandom.current().nextInt(StateEnum.values().length)]);
        heater.setPerson(person);
        heater.setRoom(room);
        Timestamp activationDate = RandomTimestampGenerator.between(lowerBound.toLocalDateTime(), LocalDateTime.now());
        heater.setActivationDate(activationDate.toString());
        return heater;
    }

    public Heater createRandomHeater(Person person, Room room, Timestamp lowerBound) {
        return createRandomHeater(person, room, 0.5, lowerBound);
    }

    @Override
    public StatusEnum randomBreakdownStatus(double p){
        return (ThreadLocalRandom.current().nextDouble() < p) ? StatusEnum.BREAKDOWN : StatusEnum.NOT_BREAKDOWN;
    }



}
