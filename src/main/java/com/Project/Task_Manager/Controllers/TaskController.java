package com.Project.Task_Manager.Controllers;


import com.Project.Task_Manager.Entity.NoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.Project.Task_Manager.Entity.TaskEntity;
import com.Project.Task_Manager.Service.TaskService;

@RestController
@RequestMapping("task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void addTask(@RequestBody TaskEntity taskEntity) {
        taskService.addTask(taskEntity);
    }
    @GetMapping("/{task_id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskEntity getById(@PathVariable int task_id){
        return taskService.getTaskById(task_id);
    }
    @DeleteMapping("/{task_id}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteById(@PathVariable int task_id){
        taskService.deleteById(task_id);
    }
}
