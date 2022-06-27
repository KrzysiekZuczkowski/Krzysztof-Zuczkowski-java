package com.kodilla.patterns.factory.tasks;

public interface Task {

    Task executeTask();
    String getTaskName();
    boolean isTaskExecuted();
}
