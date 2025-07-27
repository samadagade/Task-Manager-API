package com.samarth.dev.task_manager.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samarth.dev.task_manager.Model.Task;
import com.samarth.dev.task_manager.Repository.TaskRepository;

@Service
public class TaskService {

    private TaskRepository repo;

    TaskService(TaskRepository repo){
        this.repo = repo;
    }

    public List<Task> getTasks() {
        return repo.findAll();
    }
    
    public Task getTasksById(int id) {
        return repo.findById(id).orElse(new Task());
    }
    
    public void addTask(Task task){
       repo.save(task);
    }

    public void updateTaskById(Task task){
         repo.save(task);
    }

    public void deleteTaskById(int id){
        repo.deleteById(id);
    }

    public void deleteAllTasks(){
        repo.deleteAll();
    }
    
}