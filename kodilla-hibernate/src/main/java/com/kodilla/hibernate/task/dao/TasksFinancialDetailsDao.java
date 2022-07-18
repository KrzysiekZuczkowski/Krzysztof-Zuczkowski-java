package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.TasksFinancialDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface TasksFinancialDetailsDao extends CrudRepository<TasksFinancialDetails, Integer> {

    List<TasksFinancialDetails> findByPaid(boolean paid);
}
