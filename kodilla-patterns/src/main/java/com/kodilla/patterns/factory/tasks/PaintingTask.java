package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {

    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private boolean isExecuted = false;

    public PaintingTask(final String taskName,
                        final String color,
                        final String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public PaintingTask executeTask() {
        if (!isExecuted) {
            isExecuted = true;
            System.out.println("Painting task is running.");
        }
        else
            System.out.println("Painting task executed.");

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
