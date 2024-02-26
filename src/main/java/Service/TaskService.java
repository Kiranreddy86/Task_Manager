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

    public void addTask(@NonNull TaskRequest taskRequest) {
        TaskEntity task = new TaskEntity();
        task.setTitle(taskRequest.getTitle());
        task.setDeadline(taskRequest.getDeadline());
        task.setDescription(taskRequest.getDescription());
        taskRepository.save(task);
    }
    public TaskEntity getTaskById(int taskId) {
        return taskRepository.findById(taskId).get();
    }
    public void deleteById(int taskId) {
        taskRepository.deleteById(taskId);
    }
    public NoteEntity getNotesTaskId(int taskId) {
        return noteRepository.findById(taskId).get();
    }

    public void addNoteTaskId(int taskId, NoteRequest noteRequest) throws NoSuchFieldException {
        TaskEntity task=taskRepository.findById(taskId).get();
        if(task==null) {
            throw new NoSuchFieldException("not found");
        }
        NoteEntity note=new NoteEntity();
        note.setBody(noteRequest.getBody());
        note.setTitle(noteRequest.getTitle());
        noteRepository.save(note);
    }

    public void deleteNoteById(int taskId, int noteId) throws NoSuchFieldException {
        TaskEntity task=taskRepository.findById(taskId).get();
        if(task==null) {
            throw new NoSuchFieldException("not found");
        }

    }
}
