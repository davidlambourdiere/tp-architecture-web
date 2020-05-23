package com.lifetech.infrastructure.generator;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is used to generate random timestamp
 * @author David Lambourdiere
 * */
public class RandomTimestampGenerator {

    /**
     * Generates a random timestamp between startDateTime and endDateTime
     * @param startDateTime
     * @param endDateTime
     * @return the Timestamp object
     */
    public static Timestamp between(LocalDateTime startDateTime, LocalDateTime endDateTime){
        final long startTimestamp = Timestamp.valueOf(startDateTime).getTime();
        final long endTimestamp = Timestamp.valueOf(endDateTime).getTime();
        return new Timestamp(ThreadLocalRandom.current().nextLong(startTimestamp, endTimestamp));
    }
}
