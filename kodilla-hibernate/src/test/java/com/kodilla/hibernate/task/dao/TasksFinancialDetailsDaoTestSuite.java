package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.TasksFinancialDetails;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TasksFinancialDetailsDaoTestSuite {

    @Autowired
    private TasksFinancialDetailsDao taskFinancialDetailsDao;

    @Test
    void testFindByPaid() {
        //Given
        TasksFinancialDetails taskFinancialDetails =
                new TasksFinancialDetails(new BigDecimal(115), false);
        taskFinancialDetailsDao.save(taskFinancialDetails);
        int id = taskFinancialDetails.getId();

        //When
        List<TasksFinancialDetails> resultList = taskFinancialDetailsDao.findByPaid(false);

        //Then
        assertEquals(1, resultList.size());

        //CleanUp
        taskFinancialDetailsDao.deleteById(id);
    }
}
