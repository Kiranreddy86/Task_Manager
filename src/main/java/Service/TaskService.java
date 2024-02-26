package Service;

import DTO.TaskRequest;
import Entity.TaskEntity;
import Repository.TaskRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(@NonNull TaskRequest taskRequest) {
        TaskEntity task = new TaskEntity();
        task.setTitle(taskRequest.getTitle());
        task.setDeadline(taskRequest.getDeadline());
        task.setDescription(taskRequest.getDescription());
        taskRepository.save(task);
    }
}
