package com.Project.Task_Manager.Controllers;

import DTO.NoteRequest;
import com.Project.Task_Manager.Entity.NoteEntity;
import com.Project.Task_Manager.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("note")
public class NoteController {
    @Autowired
    NoteService noteService;
    @GetMapping("/{task_id}/notes")
    @ResponseStatus(HttpStatus.FOUND)
    @PreAuthorize("hasRole('ADMIN')")
    public List<NoteEntity> getNotesTaskId(@PathVariable int task_id){
        return noteService.getNotesTaskId(task_id);
    }
    @PostMapping("/{task_id}/notes")
    public ResponseEntity<NoteEntity> addNoteTaskId(@PathVariable int task_id, @RequestBody NoteRequest noteRequest) throws NoSuchFieldException {
        return noteService.addNoteTaskId(task_id, noteRequest);
    }
    @DeleteMapping("/{task_id}/notes/{note_id}")
    public ResponseEntity<NoteEntity> deleteNoteById(@PathVariable int task_id,@PathVariable int note_id) throws NoSuchFieldException {
        return noteService.deleteNoteById(task_id,note_id);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<NoteEntity> getAllNotes(){
        return noteService.getAllNotes();
    }
//    @GetMapping("/{note_id}")
//    public ResponseEntity<NoteEntity> getById(@PathVariable int noteId){
//        return noteService.getById(noteId);
//    }
}
