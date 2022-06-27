package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {

    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean isExecuted = false;

    public ShoppingTask(final String taskName,
                        final String whatToBuy,
                        final double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public ShoppingTask executeTask() {
        if (!isExecuted) {
            isExecuted = true;
            System.out.println("Shopping task is running.");
        }
        else
            System.out.println("Shopping task executed.");

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
