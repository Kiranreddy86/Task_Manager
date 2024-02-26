package Controllers;

import DTO.NoteRequest;
import DTO.TaskRequest;
import Entity.NoteEntity;
import Entity.TaskEntity;
import Service.NoteService;
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
    @GetMapping("{task_id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskEntity getById(@PathVariable int task_id){
        return taskService.getTaskById(task_id);
    }
    @DeleteMapping("{task_id}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteById(@PathVariable int task_id){
        taskService.deleteById(task_id);
    }
    @GetMapping("{task_id}/notes")
    public NoteEntity getNotesTaskId(@PathVariable int task_id){
        return taskService.getNotesTaskId(task_id);
    }
    @PostMapping("{task_id}/notes")
    public void addNoteTaskId(@PathVariable int task_id,@RequestBody NoteRequest noteRequest) throws NoSuchFieldException {
        taskService.addNoteTaskId(task_id,noteRequest);
    }

    @DeleteMapping("{task_id}/notes/{notes_id}")
    public void deleteNoteById(@PathVariable int task_id,@PathVariable int note_id) throws NoSuchFieldException {
        taskService.deleteNoteById(task_id,note_id);
    }

}
