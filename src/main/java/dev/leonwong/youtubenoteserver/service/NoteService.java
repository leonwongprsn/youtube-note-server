package dev.leonwong.youtubenoteserver.service;

import dev.leonwong.youtubenoteserver.entity.Note;

import java.util.List;

public interface NoteService {
    public Note insertNewNote(Note note) throws Exception;

    public List<Note> findAll();

    public Note findById(Integer id) throws Exception;

    public Note updateNote(Note newNote, Integer id) throws Exception;

    public void deleteNote(Integer id);
}
