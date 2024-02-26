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

    public List<NoteEntity> getAllNotes() {
        return noteRepository.findAll();
    }

    public NoteEntity getById(int taskId) {
        return noteRepository.findById(taskId).get();
    }
}
