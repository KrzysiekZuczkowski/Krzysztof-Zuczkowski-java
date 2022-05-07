package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    public void testProbablyIWillThrowException() {
        // given
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        // when & then
        assertAll(
                () ->   assertThrows(ExceptionProbably.class,
                        () -> exceptionHandling.probablyIWillThrowException(2, 3)),
                () -> assertThrows(ExceptionProbably.class,
                        () -> exceptionHandling.probablyIWillThrowException(0.9, 3)),
                () -> assertThrows(ExceptionProbably.class,
                        () -> exceptionHandling.probablyIWillThrowException(1, 1.5)),
                () -> assertDoesNotThrow(() -> exceptionHandling.probablyIWillThrowException(1, 1.4))
        );
    }

    @Test
    public void testProbablyIWillThrowExceptionReturnedValue() {
        //Given
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        String result = "";
        String result1;

        //When
        try {
            result = exceptionHandling.probablyIWillThrowException(1, 1.4);
            result1 = exceptionHandling.probablyIWillThrowException(1, 1.5);
        }catch(ExceptionProbably e) {
            result1 = "NotDone!";
        }

        //Then
        assertEquals("Done!", result);
        assertEquals("NotDone!", result1);
    }
}
