package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void saveLogs() {
        logger = Logger.INSTANCE;
        logger.log("2022-06-21 19:48:58.008  INFO 1820 --- [main] " +
                "c.k.s.web.KodillaSpringWebApplication    " +
                ": No active profile set, falling back to default profiles: default");
    }

    @Test
    void testGetLastLog() {
        //Given
        //When
        String lastLog = logger.getLastLog();
        //Then
        assertEquals("2022-06-21 19:48:58.008  INFO 1820 --- [main] " +
                "c.k.s.web.KodillaSpringWebApplication    " +
                ": No active profile set, falling back to default profiles: default",
                lastLog);
    }
}