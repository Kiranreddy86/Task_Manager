package com.Project.Task_Manager.Controllers;

import DTO.NoteRequest;
import com.Project.Task_Manager.Entity.NoteEntity;
import com.Project.Task_Manager.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notes")
public class NoteController {
    @Autowired
    NoteService noteService;
    @GetMapping("/{task_id}/notes")
    @ResponseStatus(HttpStatus.FOUND)
    public List<NoteEntity> getNotesTaskId(@PathVariable int task_id){
        return noteService.getNotesTaskId(task_id);
    }
    @PostMapping("/{task_id}/notes")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNoteTaskId(@PathVariable int task_id, @RequestBody NoteRequest noteRequest) throws NoSuchFieldException {
        noteService.addNoteTaskId(task_id, noteRequest);
    }
    @DeleteMapping("/{task_id}/notes/{note_id}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteNoteById(@PathVariable int task_id,@PathVariable int note_id) throws NoSuchFieldException {
        noteService.deleteNoteById(task_id,note_id);
    }
}