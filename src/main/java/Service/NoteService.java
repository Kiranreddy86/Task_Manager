package Service;

import DTO.NoteRequest;
import Entity.NoteEntity;
import Entity.TaskEntity;
import Repository.NoteRepository;
import Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final TaskRepository taskRepository;
    @Autowired
    public NoteService(NoteRepository noteRepository, TaskRepository taskRepository) {
        this.noteRepository = noteRepository;
        this.taskRepository = taskRepository;
    }

    public void writeNoteById(int taskId, NoteRequest noteRequest) throws Exception {
        TaskEntity taskEntity=taskRepository.findById(taskId).get();
        if(taskEntity==null){
            throw new Exception("No task found");
        }
        NoteEntity noteEntity=new NoteEntity();
        noteEntity.setDescription(noteRequest.getNote());
        taskEntity.setNoteEntity(noteEntity);
        taskRepository.save(taskEntity);
        noteRepository.save(noteEntity);
    }

    public List<NoteEntity> getAllNotes() {
        return noteRepository.findAll();
    }
}
