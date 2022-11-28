package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.forum.ForumTopic;

import java.util.ArrayDeque;
import java.util.Deque;

public class TasksQueue extends ForumTopic {

    private final Deque<String> tasks;

    public TasksQueue(String name) {
        super(name);
        tasks = new ArrayDeque<>();
    }

    public void addTask(String task) {
        tasks.offer(task);
        notifyObservers();
    }

    public Deque<String> getTasks() {
        return tasks;
    }
}
