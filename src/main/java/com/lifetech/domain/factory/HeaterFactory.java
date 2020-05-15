package com.lifetech.domain.factory;

import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.Person;
import com.lifetech.domain.model.Room;

public interface HeaterFactory {
    Heater createHeater();

    Heater createRandomHeater(Person person, Room room);
}
