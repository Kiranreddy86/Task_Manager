package com.Project.Task_Manager.Service;

import com.Project.Task_Manager.Entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Project.Task_Manager.Entity.TaskEntity;
import com.Project.Task_Manager.Repository.TaskRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class TaskService {
    @Autowired
    UserService userService;
    private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public ResponseEntity<TaskEntity> addTask(TaskEntity taskEntity,int userId) {
        LocalDate deadlineDate=taskEntity.getDeadline();
        LocalDate createdDate =taskEntity.getCreated_At();
        UserEntity user = userService.getUserById(userId);
        taskEntity.setUser(user);
        boolean before = deadlineDate.isBefore(createdDate);
        if(!before){
            return ResponseEntity.ok(taskRepository.save(taskEntity));
        }else{
            return ResponseEntity.unprocessableEntity().build();
        }
    }
    public ResponseEntity<TaskEntity> getTaskById(int userId, int task_id) {
        TaskEntity list = taskRepository.getTaskById(userId,task_id);
        if(list == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }
    public ResponseEntity<TaskEntity> deleteById(int userId,int taskId) {
        TaskEntity task=taskRepository.getTaskById(userId,taskId);
        if(task == null) {
            return ResponseEntity.notFound().build();
        }
        taskRepository.delete(task);
        return ResponseEntity.ok(task);
    }
    public List<TaskEntity> getAllTasks(int userId) {
        List<TaskEntity> list = taskRepository.findAllById(userId);
        for (TaskEntity entity: list){
            boolean deadlineFinished = entity.getDeadline().isBefore(LocalDate.now());
            if(deadlineFinished && entity.isCompleted()) {
                taskRepository.delete(entity);
            }
        }
        return taskRepository.findAllById(userId);
    }
    public ResponseEntity<List<TaskEntity>> getAllTodayTasks(int userId){
        LocalDate currentDate = LocalDate.now();
        List<TaskEntity> tasks = taskRepository.findTasksByCurrentDate(userId,currentDate);
        return ResponseEntity.ok(tasks);
    }
    @Transactional
    public ResponseEntity<TaskEntity> taskFinished(int userId, int taskId) {
        TaskEntity task=taskRepository.getTaskById(userId,taskId);
        if (task!=null) {
            task.setCompleted(!task.isCompleted());
            return ResponseEntity.ok(taskRepository.save(task));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
