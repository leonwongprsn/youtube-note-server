package dev.leonwong.youtubenoteserver.controller;

import dev.leonwong.youtubenoteserver.entity.Note;
import dev.leonwong.youtubenoteserver.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.PATCH, RequestMethod.POST, RequestMethod.PUT, RequestMethod.TRACE})
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("")
    public List<Note> getAllNotes() {
        HashMap<String, List<Note>> json = new HashMap<>();
        json.put("notes", noteService.findAll());
        return noteService.findAll();
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Integer id) throws Exception {
        return noteService.findById(id);
    }

    @PostMapping("")
    public Note createNote(@RequestBody Note note) throws Exception {
        System.out.println(note);
        Note savedNote = noteService.insertNewNote(note);
        return savedNote;
    }

    @PutMapping("/{id}")
    public Note editNote(@PathVariable Integer id, @RequestBody Note newNote) throws Exception {
        System.out.println(newNote);
        noteService.updateNote(newNote, id);
        return noteService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable Integer id) {
        System.out.println("deleting note with id: " + String.valueOf(id));
        noteService.deleteNote(id);
        return "delete successful";
    }
}
