package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.forum.ForumTopic;
import com.kodilla.patterns2.observer.forum.Observer;

public class Mentor implements Observer {

    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(ForumTopic tasksQueue) {
        TasksQueue t = (TasksQueue) tasksQueue;
        System.out.println(mentorName + ": New task in " + t.getName() + "\n" +
                " (total: " + t.getTasks().size() + " tasks)");
        updateCount++;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
