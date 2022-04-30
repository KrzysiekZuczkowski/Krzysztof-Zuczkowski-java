package com.kodilla.stream.portfolio;

import java.util.ArrayList;
import java.util.List;

public final class Board {

    private final List<TaskList> taskLists = new ArrayList<>();
    private final String name;

    public Board(final String name) {
        this.name = name;
    }

    public void addTaskList(TaskList tasks) {
        taskLists.add(tasks);
    }

    public boolean removeTaskList(TaskList tasks) {
        return taskLists.remove(tasks);
    }

    @Override
    public String toString() {
        return "Board{" + "\n" +
                "name = '" + name + '\'' + ",\n" +
                "taskLists = " + taskLists + "\n" +
                '}';
    }

    public List<TaskList> getTaskLists() {
        return new ArrayList<>(taskLists);
    }

    public String getName() {
        return name;
    }
}
