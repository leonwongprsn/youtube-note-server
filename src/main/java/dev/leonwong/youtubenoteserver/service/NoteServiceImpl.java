package dev.leonwong.youtubenoteserver.service;

import dev.leonwong.youtubenoteserver.entity.Note;
import dev.leonwong.youtubenoteserver.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public void insertNewNote(Note note) {
        note.setId(0);
        noteRepository.save(note);
    }

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note findById(Integer id) throws Exception {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            return optionalNote.get();
        } else {
            throw new Exception("Fail to get note data, id not found.");
        }
    }

    @Override
    public Note updateNote(Note newNote, Integer id) throws Exception {
        Optional<Note> optionalNote = noteRepository.findById(id)
                .map(note -> {
                    note.setTitle(newNote.getTitle());
                    note.setDescription(newNote.getDescription());
                    note.setUrl(newNote.getUrl());
                    note.setContent(newNote.getContent());
                    return noteRepository.save(note);
                });
        if (optionalNote.isPresent()) {
            return  optionalNote.get();
        } else {
            throw new Exception("Fail to edit note");
        }
    }

    @Override
    public void deleteNote(Integer id) {
        noteRepository.deleteById(id);
    }
}
