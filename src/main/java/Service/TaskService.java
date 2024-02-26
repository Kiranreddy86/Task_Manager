package Service;

import DTO.NoteRequest;
import DTO.TaskRequest;
import Entity.NoteEntity;
import Entity.TaskEntity;
import Repository.NoteRepository;
import Repository.TaskRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final NoteRepository noteRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository, NoteRepository noteRepository) {
        this.taskRepository = taskRepository;
        this.noteRepository = noteRepository;
    }

    public void addTask(@NonNull TaskRequest taskRequest) {
        TaskEntity task = new TaskEntity();
        task.setTitle(taskRequest.getTitle());
        task.setDeadline(taskRequest.getDeadline());
        task.setDescription(taskRequest.getDescription());
        taskRepository.save(task);
    }
    public void writeNoteById(int taskId, NoteRequest noteRequest) throws Exception {
        TaskEntity taskEntity=taskRepository.findById(taskId).get();
        if(taskEntity==null){
            throw new Exception("No task found");
        }
        NoteEntity noteEntity=new NoteEntity();
        noteEntity.setId(taskEntity.getId());
        noteEntity.setDescription(noteRequest.getNote());
        taskEntity.setNoteEntity(noteEntity);
        taskRepository.save(taskEntity);
        noteRepository.save(noteEntity);
    }
}
