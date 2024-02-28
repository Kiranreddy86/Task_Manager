package com.Project.Task_Manager.Service;

import com.Project.Task_Manager.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Project.Task_Manager.Entity.TaskEntity;
import com.Project.Task_Manager.Repository.TaskRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository, NoteRepository noteRepository) {
        this.taskRepository = taskRepository;
    }
    public ResponseEntity<TaskEntity> addTask(TaskEntity taskEntity) {
        LocalDate deadlineDate=taskEntity.getDeadline();
        LocalDate createdDate =taskEntity.getCreated_At();
        boolean before = deadlineDate.isBefore(createdDate);
        if(!before){
            return ResponseEntity.ok(taskRepository.save(taskEntity));
        }else{
            return ResponseEntity.unprocessableEntity().build();
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
        List<TaskEntity> list = taskRepository.findAll();
        for (TaskEntity entity: list){
            boolean deadlineFinished = entity.getDeadline().isBefore(LocalDate.now());
            if(deadlineFinished && entity.isCompleted()) {
                taskRepository.delete(entity);
            }
        }
        return taskRepository.findAll();
    }
    public List<TaskEntity> getAllTodayTasks(){
        LocalDate currentDate = LocalDate.now();
        List<TaskEntity> tasks = taskRepository.findTasksByCurrentDate(currentDate);
        return tasks;
    }

}
