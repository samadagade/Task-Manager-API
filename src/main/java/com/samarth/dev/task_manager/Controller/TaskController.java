package com.samarth.dev.task_manager.Controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.samarth.dev.task_manager.Model.Task;
import com.samarth.dev.task_manager.Service.TaskService;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin("*")
@RestController
public class TaskController {

   private TaskService service;

   TaskController(TaskService service) {
      this.service = service;
   };
     
   //just returning map of services of route
   //LikedHashMap : used because it maintain insertion order
   //HasMap : return in random order
   //TreeMap : return in sored order
   @GetMapping("/")
   public Map<String, String> apiInfo() {
      Map<String, String> info = new LinkedHashMap<>();    //LikedHashMap : used because it maintain insertion order
      info.put("GET /tasks", "Get all tasks");
      info.put("GET /tasks/{id}", "Get task by ID");
      info.put("POST /tasks", "Create new task");
      info.put("PUT /tasks", "Update a task");
      info.put("DELETE /tasks/{id}", "Delete task by ID");
      info.put("DELETE /tasks", "Delete all tasks");
      return info;
   }

   @GetMapping("/tasks")
   public List<Task> getTasks() {
      return service.getTasks();
   }

   @GetMapping("/tasks/{id}")
   public Task getTasksById(@PathVariable int id) {
      return service.getTasksById(id);
   }

   @PutMapping("/tasks")
   public void updateTaskById(@RequestBody Task task) {
      service.updateTaskById(task);
   }

   @PostMapping("/tasks")
   public void addTask(@RequestBody Task task) {
      service.addTask(task);
   }

   @DeleteMapping("/tasks/{id}")
   public void deleteById(@PathVariable int id) {
      service.deleteTaskById(id);
   }

   @DeleteMapping("/tasks")
   public void deleteAllTasks() {
      service.deleteAllTasks();
   }
}
