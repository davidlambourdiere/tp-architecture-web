package com.lifetech.domain.factory;

import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.Person;
import com.lifetech.domain.model.Room;
import com.lifetech.domain.model.StatusEnum;

public interface HeaterFactory {
    Heater createHeater();

    /**
     * Creates a random heater belonging to person and located in room
     * @param person a Person object
     * @param room a Room object
     * @param p a given probability (between 0 and 1)
     * @return a random heater belonging to person and located in room
     * */
    Heater createRandomHeater(Person person, Room room, double p);

    /**
     * Generates a random StatusEnum
     * @param   p a given probability
     * @return  StatusEnum.BREAKDOWN with the probability of p or
     *          StatusEnum.NOT_BREAKDOWN with the probability of 1-p
     * */
    StatusEnum randomBreakdownStatus(double p);
}
