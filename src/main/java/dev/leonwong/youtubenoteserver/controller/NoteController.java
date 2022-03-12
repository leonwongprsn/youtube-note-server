package dev.leonwong.youtubenoteserver.controller;

import dev.leonwong.youtubenoteserver.entity.Note;
import dev.leonwong.youtubenoteserver.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
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
    public Note getNoteById(@PathVariable Integer id) throws Exception{

        return noteService.findById(id);
    }

    @PostMapping("")
    public List<Note> createNote(@RequestBody Note note) {
        System.out.println(note);
        noteService.insertNewNote(note);
        HashMap<String, List<Note>> json = new HashMap<>();
        json.put("notes", noteService.findAll());
        return noteService.findAll();
    }

    @PutMapping("/{id}")
    public List<Note> editNote(@PathVariable Integer id, @RequestBody Note newNote) throws Exception{
        System.out.println(newNote);
        noteService.updateNote(newNote, id);
        HashMap<String, List<Note>> json = new HashMap<>();
        json.put("notes", noteService.findAll());
        return noteService.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable Integer id) {
        System.out.println("deleting note with id: " + String.valueOf(id));
        noteService.deleteNote(id);
        return "delete successful";
    }
}
