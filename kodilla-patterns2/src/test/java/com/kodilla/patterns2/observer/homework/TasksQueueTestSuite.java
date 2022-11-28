package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TasksQueueTestSuite {

    @Test
    public void testUpdate() {
        // Given
        TasksQueue krzysiek = new KrzysiekTasksQueue();
        TasksQueue mick = new MickTasksQueue();
        TasksQueue susan = new SusanTasksQueue();
        Mentor pawel = new Mentor("Pawel");
        Mentor andy = new Mentor("Andy");
        krzysiek.registerObserver(pawel);
        mick.registerObserver(andy);
        susan.registerObserver(andy);
        //When
        krzysiek.addTask("Task 1.1");
        krzysiek.addTask("Task 2.2");
        krzysiek.addTask("Task 3.3");
        susan.addTask("Task 7.7");
        mick.addTask("Task 1.2");
        mick.addTask("Task 3.4");
        susan.addTask("Task 7.8");
        //Then
        assertEquals(3, pawel.getUpdateCount());
        assertEquals(4, andy.getUpdateCount());
    }
}