package Controllers;

import DTO.TaskRequest;
import Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTask(@RequestBody TaskRequest taskRequest){
        taskService.addTask(taskRequest);
    }
}
