package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    private TaskFactory factory = new TaskFactory();

    @Test
    void testFactoryDrivingTask() {
        //Given

        //When
        Task drivingTask = factory.makeTask(TaskFactory.DRIVING_TASK);

        //Then
        assertEquals("Drive to the", drivingTask.getTaskName());
        assertTrue(drivingTask.executeTask().isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTask() {
        //Given

        //When
        Task paintingTask = factory.makeTask(TaskFactory.PAINTING_TASK);

        //Then
        assertEquals("Paint the", paintingTask.getTaskName());
        assertTrue(paintingTask.executeTask().isTaskExecuted());
    }

    @Test
    void testFactoryShoppingTask() {
        //Given

        //When
        Task shoppingTask = factory.makeTask(TaskFactory.SHOPPING_TASK);

        //Then
        assertEquals("Go to buy", shoppingTask.getTaskName());
        assertTrue(shoppingTask.executeTask().isTaskExecuted());
    }
}
