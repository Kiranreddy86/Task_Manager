package com.Project.Task_Manager.Service;

import DTO.NoteRequest;
import com.Project.Task_Manager.Entity.NoteEntity;
import com.Project.Task_Manager.Entity.TaskEntity;
import com.Project.Task_Manager.Repository.NoteRepository;
import com.Project.Task_Manager.Repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<NoteEntity> addNoteTaskId(int taskId, NoteRequest noteRequest) {
        TaskEntity task = taskRepository.findById(taskId).orElse(null);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        NoteEntity note = new NoteEntity();
        note.setBody(noteRequest.getBody());
        note.setTitle(noteRequest.getTitle());
        task.getNotes().add(note);
        return ResponseEntity.ok(noteRepository.save(note));
    }
    @Transactional
    public ResponseEntity<NoteEntity> deleteNoteById(int taskId, int noteId) {
        TaskEntity task=taskRepository.findById(taskId).orElse(null);
        if(task == null) {
            return ResponseEntity.notFound().build();
        }
        NoteEntity note=noteRepository.findById(noteId).orElse(null);
        if(note == null){
            return ResponseEntity.notFound().build();
        }
        noteRepository.deleteNoteByTaskId(taskId,noteId);
        return ResponseEntity.ok(note);
    }

    public List<NoteEntity> getAllNotes() {
        return noteRepository.findAll();
    }

    @Transactional
    public ResponseEntity<NoteEntity> updateNoteByTaskId(int taskId, int noteId, NoteRequest noteRequest) {
        TaskEntity task=taskRepository.findById(taskId).orElse(null);
        if(task == null) {
            return ResponseEntity.notFound().build();
        }
        NoteEntity note=noteRepository.findById(noteId).orElse(null);
        if(note == null){
            return ResponseEntity.notFound().build();
        }
        if(noteRequest.getTitle()!=null){
            note.setTitle(noteRequest.getTitle());
        }
        if(noteRequest.getBody()!=null){
            note.setBody(noteRequest.getBody());
        }
        noteRepository.save(note);
        return ResponseEntity.ok(note);
    }
}
