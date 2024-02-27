package com.Project.Task_Manager.Service;

import DTO.TaskRequest;

import com.Project.Task_Manager.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Task_Manager.Entity.NoteEntity;
import com.Project.Task_Manager.Entity.TaskEntity;
import com.Project.Task_Manager.Repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final NoteRepository noteRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository, NoteRepository noteRepository) {
        this.taskRepository = taskRepository;
        this.noteRepository = noteRepository;
    }

    public void addTask(TaskEntity taskEntity) {
        taskRepository.save(taskEntity);
    }
    public TaskEntity getTaskById(int taskId) {
        return taskRepository.findById(taskId).get();
    }
    public void deleteById(int taskId) {
        taskRepository.deleteById(taskId);
    }
}
