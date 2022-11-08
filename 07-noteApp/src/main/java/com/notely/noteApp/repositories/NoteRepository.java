package com.notely.noteApp.repositories;

import com.notely.noteApp.entities.Note;
import com.notely.noteApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
  Optional<List<Note>> findByUser(User user);
}
