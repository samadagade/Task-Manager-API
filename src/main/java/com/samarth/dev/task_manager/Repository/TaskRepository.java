package com.samarth.dev.task_manager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samarth.dev.task_manager.Model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}