package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    private ForumStatistics forumStatistics;

    private static List<String> numberOfUsers;
    private static  int postsNumber = 1000;
    private static  int commentsNumber = 1234;

    @BeforeAll
    public static void beforeAllTests() {
        numberOfUsers = generateListOfNUsers(100);
    }

    @BeforeEach
    public void before() {
        forumStatistics = new ForumStatistics();
    }

    @AfterEach
    public void after() {
        forumStatistics.showStatistics();
    }

    private static List<String> generateListOfNUsers(int usersNumber) {
        List<String> resultList = new ArrayList<>();
        for (int n = 1; n <= usersNumber; n++) {
            resultList.add("User " + n);
        }
        return resultList;
    }


    @Test
    void testCalculateAdvStatisticsPosts0() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(numberOfUsers);
        when(statisticsMock.commentsCount()).thenReturn(commentsNumber);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, forumStatistics.getNumberOfUsers());
        assertEquals(0, forumStatistics.getNumberOfPosts());
        assertEquals(1234, forumStatistics.getNumberOfComments());
        assertEquals(0. / 100, forumStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(1234. / 100, forumStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(0., forumStatistics.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsPosts1000() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(numberOfUsers);
        when(statisticsMock.postsCount()).thenReturn(postsNumber);
        when(statisticsMock.commentsCount()).thenReturn(commentsNumber);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, forumStatistics.getNumberOfUsers());
        assertEquals(1000, forumStatistics.getNumberOfPosts());
        assertEquals(1234, forumStatistics.getNumberOfComments());
        assertEquals(1000 / 100, forumStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(1234. / 100, forumStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(1234. / 1000, forumStatistics.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsComments0() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(numberOfUsers);
        when(statisticsMock.postsCount()).thenReturn(postsNumber);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, forumStatistics.getNumberOfUsers());
        assertEquals(1000, forumStatistics.getNumberOfPosts());
        assertEquals(0, forumStatistics.getNumberOfComments());
        assertEquals(1000 / 100, forumStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(0. / 100, forumStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(0. / 1000, forumStatistics.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsCommentsLessThanPosts() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(numberOfUsers);
        when(statisticsMock.postsCount()).thenReturn(postsNumber);
        when(statisticsMock.commentsCount()).thenReturn(999);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, forumStatistics.getNumberOfUsers());
        assertEquals(1000, forumStatistics.getNumberOfPosts());
        assertEquals(999, forumStatistics.getNumberOfComments());
        assertEquals(1000 / 100, forumStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(999. / 100, forumStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(999. / 1000, forumStatistics.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsCommentsMoreThanPosts() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(numberOfUsers);
        when(statisticsMock.postsCount()).thenReturn(postsNumber);
        when(statisticsMock.commentsCount()).thenReturn(commentsNumber);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, forumStatistics.getNumberOfUsers());
        assertEquals(1000, forumStatistics.getNumberOfPosts());
        assertEquals(1234, forumStatistics.getNumberOfComments());
        assertEquals(1000 / 100, forumStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(1234. / 100, forumStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(1234. / 1000, forumStatistics.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsUsers0() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(postsNumber);
        when(statisticsMock.commentsCount()).thenReturn(commentsNumber);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, forumStatistics.getNumberOfUsers());
        assertEquals(1000, forumStatistics.getNumberOfPosts());
        assertEquals(1234, forumStatistics.getNumberOfComments());
        assertEquals(0., forumStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(0., forumStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(1234. / 1000, forumStatistics.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsUsers100() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(numberOfUsers);
        when(statisticsMock.postsCount()).thenReturn(postsNumber);
        when(statisticsMock.commentsCount()).thenReturn(commentsNumber);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, forumStatistics.getNumberOfUsers());
        assertEquals(1000, forumStatistics.getNumberOfPosts());
        assertEquals(1234, forumStatistics.getNumberOfComments());
        assertEquals(1000 / 100, forumStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(1234. / 100, forumStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(1234. / 1000, forumStatistics.getAverageNumberOfCommentsPerPost());
    }
}
