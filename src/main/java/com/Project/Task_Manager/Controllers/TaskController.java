package com.Project.Task_Manager.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Project.Task_Manager.Entity.TaskEntity;
import com.Project.Task_Manager.Service.TaskService;

import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/add")
    public ResponseEntity<TaskEntity> addTask(@RequestBody TaskEntity taskEntity) {
        return taskService.addTask(taskEntity);
    }
    @GetMapping("/{task_id}")
    public ResponseEntity<TaskEntity> getById(@PathVariable int task_id){
        return taskService.getTaskById(task_id);
    }
    @DeleteMapping("/{task_id}")
    public ResponseEntity<TaskEntity> deleteById(@PathVariable int task_id){
        return taskService.deleteById(task_id);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskEntity> getAllTasks(){
        return taskService.getAllTasks();
    }
}
