package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String DRIVING_TASK = "DRIVING TASK";
    public static final String PAINTING_TASK = "PAINTING TASK";
    public static final String SHOPPING_TASK = "SHOPPING TASK";

    public Task makeTask(final String taskClass) {
        switch (taskClass) {
            case DRIVING_TASK:
                return new DrivingTask("Drive to the",
                        "West",
                        "by car");
            case PAINTING_TASK:
                return new PaintingTask("Paint the",
                        "black",
                        " background");
            case SHOPPING_TASK:
                return new ShoppingTask("Go to buy",
                        "pizza",
                        2);
            default:
                return null;
        }
    }
}
