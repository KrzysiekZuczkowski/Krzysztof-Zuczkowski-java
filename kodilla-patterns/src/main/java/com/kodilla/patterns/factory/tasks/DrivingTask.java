package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task{

    private final String taskName;
    private final String where;
    private final String using;
    private boolean isExecuted = true;

    public DrivingTask(final String taskName,
                       final String where,
                       final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public DrivingTask executeTask() {
        if (!isExecuted) {
            isExecuted = true;
            System.out.println("Driving task is running.");
        }
        else
            System.out.println("Driving task executed.");

        return this;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }
}
