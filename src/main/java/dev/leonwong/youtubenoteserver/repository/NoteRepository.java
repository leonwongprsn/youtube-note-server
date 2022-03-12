package dev.leonwong.youtubenoteserver.repository;

import dev.leonwong.youtubenoteserver.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note,Integer> {
}
