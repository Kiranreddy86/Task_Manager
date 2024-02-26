package Controllers;

import DTO.NoteRequest;
import Entity.NoteEntity;
import Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/all")
    public List<NoteEntity> getAllNotes(){
        return noteService.getAllNotes();
    }

    @GetMapping("id/{id}")
    public NoteEntity getById(@PathVariable int id){
        return noteService.getById(id);
    }

}
