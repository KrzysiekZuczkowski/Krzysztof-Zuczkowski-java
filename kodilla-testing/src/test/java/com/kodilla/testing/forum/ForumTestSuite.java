package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

public class ForumTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suit: begin \n");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("\n Test Suit: end");
    }

    @DisplayName("When created SimpleUser with real name " +
                "then getRealName should return real user name"
    )
    @Test
    void testCaseRealUserName() {
        //Given
        SimpleUser simpleUser = new SimpleUser(
                        "theForumUser",
                        "John Smith"
        );

        //When
        String result = simpleUser.getRealName();
        String expectedResult = "John Smith";

        //Then
        Assertions.assertEquals(expectedResult, result );
    }

    @DisplayName("When created SimpleUser with name " +
                "then getUserName should return correct name"
    )
    @Test
    void testCaseUserName() {
        //Given
        SimpleUser simpleUser = new SimpleUser(
                "theForumUser",
                "John Smith"
        );

        //When
        String result = simpleUser.getUserName();
        String expectedResult = "theForumUser";

        //Then
        Assertions.assertEquals(expectedResult, result);
    }
}
