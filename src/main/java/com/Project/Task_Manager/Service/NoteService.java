package com.Project.Task_Manager.Service;

import DTO.NoteRequest;
import com.Project.Task_Manager.Entity.NoteEntity;
import com.Project.Task_Manager.Entity.TaskEntity;
import com.Project.Task_Manager.Repository.NoteRepository;
import com.Project.Task_Manager.Repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;
    @Autowired
    TaskRepository taskRepository;
    public List<NoteEntity> getNotesTaskId(int taskId) {
        return noteRepository.findNoteBytaskId(taskId);
    }
    public void addNoteTaskId(int taskId, NoteRequest noteRequest) throws NoSuchFieldException {
        TaskEntity task = taskRepository.findById(taskId).orElse(null);
        if (task == null) {
            throw new NoSuchFieldException("Task with ID " + taskId + " not found");
        }
        NoteEntity note = new NoteEntity();
        note.setBody(noteRequest.getBody());
        note.setTitle(noteRequest.getTitle());
        task.getNoteEntity().add(note);
        noteRepository.save(note);
    }
    @Transactional
    public void deleteNoteById(int taskId, int noteId) throws NoSuchFieldException {
        TaskEntity task=taskRepository.findById(taskId).orElse(null);
        if(task == null) {
            throw new NoSuchFieldException("not found"+" "+taskId);
        }
        NoteEntity note=noteRepository.findById(noteId).orElse(null);
        if(note == null){
            throw new NoSuchFieldException("not found"+" "+ noteId);
        }
        noteRepository.deleteNoteByTaskId(taskId,noteId);
    }
}
