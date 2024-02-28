package com.Project.Task_Manager.Service;

import DTO.TaskRequest;
import com.Project.Task_Manager.Entity.NoteEntity;
import com.Project.Task_Manager.Repository.NoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Project.Task_Manager.Entity.TaskEntity;
import com.Project.Task_Manager.Repository.TaskRepository;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final NoteRepository noteRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository, NoteRepository noteRepository) {
        this.taskRepository = taskRepository;
        this.noteRepository = noteRepository;
    }
    public ResponseEntity<TaskEntity> addTask(TaskEntity taskEntity) {
        LocalDate date=taskEntity.getDeadline();
        LocalDate createdDate =taskEntity.getCreated_At();
        boolean isValid = date.isAfter(createdDate);
        if(isValid){
            return ResponseEntity.ok(taskRepository.save(taskEntity));
        }else{
            throw new DateTimeException("Please provide valid deadline Date");
        }
    }
    public ResponseEntity<TaskEntity> getTaskById(int taskId) {
        TaskEntity task=taskRepository.findById(taskId).orElse(null);
        if(task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(taskRepository.findById(taskId).get());
    }
    public ResponseEntity<TaskEntity> deleteById(int taskId) {
        TaskEntity task=taskRepository.findById(taskId).orElse(null);
        if(task == null) {
            return ResponseEntity.notFound().build();
        }
        taskRepository.delete(task);
        return ResponseEntity.ok(task);
    }

    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

}
