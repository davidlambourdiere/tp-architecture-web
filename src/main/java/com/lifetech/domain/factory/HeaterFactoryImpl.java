package com.lifetech.domain.factory;

import com.lifetech.domain.model.*;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class HeaterFactoryImpl implements HeaterFactory {
    Random rd = new Random();
    @Override
    public Heater createHeater() {
        return new Heater();
    }

    @Override
    public Heater createRandomHeater(Person person, Room room) {
        Heater heater = new Heater();
        heater.setBreakdownstatus((rd.nextBoolean()) ? StatusEnum.BREAKDOWN : StatusEnum.NOT_BREAKDOWN);
        heater.setState(StateEnum.values()[rd.nextInt(StateEnum.values().length)]);
        heater.setPerson(person);
        heater.setRoom(room);
        return heater;
    }
}
