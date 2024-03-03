package com.Project.Task_Manager.Controllers;


import DTO.TaskRequest;
import com.Project.Task_Manager.Entity.NoteEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.Project.Task_Manager.Entity.TaskEntity;
import com.Project.Task_Manager.Service.TaskService;

import java.time.LocalDate;
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
    @PreAuthorize("hasRole('ROLE_NORMAL')")
    public ResponseEntity<TaskEntity> addTask(@RequestBody TaskEntity taskEntity,@RequestParam("user") int userId) {
        return taskService.addTask(taskEntity,userId);
    }
    @GetMapping("/{task_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TaskEntity> getById(@RequestParam("user") int userId,@PathVariable int task_id){
        return taskService.getTaskById(userId,task_id);
    }
    @DeleteMapping("/{task_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TaskEntity> deleteById(@RequestParam("user") int userId,@PathVariable int task_id){
        return taskService.deleteById(userId,task_id);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('NORMAL')")
    public List<TaskEntity> getAllTasks(@RequestParam("user") int userId){
        return taskService.getAllTasks(userId);
    }
    @GetMapping("/userId/today/all")
    @PreAuthorize("hasRole('NORMAL')")
    public ResponseEntity<List<TaskEntity>> getAllTodayTasks(@RequestParam("user") int userId){
        return taskService.getAllTodayTasks(userId);
    }
    @PutMapping("/finished/{task_id}")
    public ResponseEntity<TaskEntity> taskFinished(@RequestParam("user") int userId,@PathVariable int taskId){
        return taskService.taskFinished(userId,taskId);
    }
}
