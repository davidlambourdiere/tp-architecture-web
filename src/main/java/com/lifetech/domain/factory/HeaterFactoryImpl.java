package com.lifetech.domain.factory;

import com.lifetech.domain.model.*;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class HeaterFactoryImpl implements HeaterFactory {

    @Override
    public Heater createHeater() {
        return new Heater();
    }

    @Override
    public Heater createRandomHeater(Person person, Room room, double p) {
        Heater heater = new Heater();
        heater.setBreakdownstatus(randomBreakdownStatus(p));
        heater.setState(StateEnum.values()[ThreadLocalRandom.current().nextInt(StateEnum.values().length)]);
        heater.setPerson(person);
        heater.setRoom(room);
        return heater;
    }

    public Heater createRandomHeater(Person person, Room room) {
        return createRandomHeater(person, room, 0.5);
    }

    @Override
    public StatusEnum randomBreakdownStatus(double p){
        return (ThreadLocalRandom.current().nextDouble() < p) ? StatusEnum.BREAKDOWN : StatusEnum.NOT_BREAKDOWN;
    }



}
