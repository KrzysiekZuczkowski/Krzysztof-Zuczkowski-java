package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskList2;
import com.kodilla.hibernate.task.TasksFinancialDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskDaoTestSuite {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private TaskListDao2 taskListDao;

    private static  final String DESCRIPTION = "Test: Learn hibernate";

    @Test
    void testTaskDaoSave() {
        //Given
        Task task = new Task(DESCRIPTION, 7);

        //When
        taskDao.save(task);

        //Then
        int id = task.getId();
        Optional<Task> readTask = taskDao.findById(id);
        assertTrue(readTask.isPresent());

        //CleanUp
        taskDao.deleteById(id);
    }

    @Test
    void testTaskDaoFindByDuration() {
        //Given
        Task task = new Task(DESCRIPTION, 7);
        taskDao.save(task);
        int duration = task.getDuration();

        //When
        List<Task> readTasks = taskDao.findByDuration(duration);

        //Then
        assertEquals(1, readTasks.size());

        //CleanUp
        int id = readTasks.get(0).getId();
        taskDao.deleteById(id);
    }

    @Test
    void testTaskDaoSaveWithFinancialDetails() {
        //Given
        Task task = new Task(DESCRIPTION, 30);
        task.setTaskFinancialDetails(new TasksFinancialDetails(new BigDecimal(120), false));

        //When
        taskDao.save(task);
        int id = task.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
        taskDao.deleteById(id);
    }

    @Test
    void testNamedQueries() {
        //Given
        Task task1 = new Task("Test: Study Hibernate", 3);
        Task task2 = new Task("Test: Practice Named Queries", 6);
        Task task3 = new Task("Test: Study native queries", 7);
        Task task4 = new Task("Test: Make some tests", 13);

        TasksFinancialDetails tfd1 = new TasksFinancialDetails(new BigDecimal(5), false);
        TasksFinancialDetails tfd2 = new TasksFinancialDetails(new BigDecimal(10), false);
        TasksFinancialDetails tfd3 = new TasksFinancialDetails(new BigDecimal(20), false);
        TasksFinancialDetails tfd4 = new TasksFinancialDetails(new BigDecimal(15), false);

        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tfd2);
        task3.setTaskFinancialDetails(tfd3);
        task4.setTaskFinancialDetails(tfd4);

        TaskList2 taskList = new TaskList2("TODO", "ToDo tasks");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        taskList.getTasks().add(task3);
        taskList.getTasks().add(task4);

        task1.setTaskList(taskList);
        task2.setTaskList(taskList);
        task3.setTaskList(taskList);
        task4.setTaskList(taskList);

        taskListDao.save(taskList);
        int id = taskList.getId();

        //When
        List<Task> longTasks = taskDao.retrieveLongTasks();
        List<Task> shortTasks = taskDao.retrieveShortTasks();
        List<Task> enoughTimeTasks = taskDao.retrieveTasksWithEnoughTime();
        List<Task> durationLongerThanTasks = taskDao.retrieveTasksWithDurationLongerThan(6);

        //Then
        try {
            assertEquals(1, longTasks.size());
            assertEquals(3, shortTasks.size());
            assertEquals(3, enoughTimeTasks.size());
            assertEquals(2, durationLongerThanTasks.size());
        } finally {
            //CleanUp
            taskListDao.deleteById(id);
        }
    }
}
