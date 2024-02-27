package com.Project.Task_Manager.Service;

import com.Project.Task_Manager.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Project.Task_Manager.Entity.TaskEntity;
import com.Project.Task_Manager.Repository.TaskRepository;

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
        taskRepository.save(taskEntity);
        return ResponseEntity.ok(taskEntity);
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
        return ResponseEntity.ok(task);
    }

    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }
}
