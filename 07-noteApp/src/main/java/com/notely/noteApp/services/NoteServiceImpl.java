package com.notely.noteApp.services;

import com.notely.noteApp.dtos.NoteDto;
import com.notely.noteApp.entities.Note;
import com.notely.noteApp.entities.User;
import com.notely.noteApp.repositories.NoteRepository;
import com.notely.noteApp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {
  private NoteRepository noteRepository;
  private UserRepository userRepository;

  @Override
  public Note getNoteById(Long noteId) {
    Optional<Note> noteOptional = noteRepository.findById(noteId);
    Note foundNote = NoteServiceImpl.unwrapNote(noteOptional);
    return foundNote;
  }

  @Override
  public List<Note> getNotesByUserId(Long userId) {
    User foundUser = UserServiceImpl.unwrapUser(userRepository.findById(userId));
    return (List<Note>) foundUser.getNotes();
  }

  @Override
  @Transactional
  public Note addNote(NoteDto noteDto, Long userId) {
    Optional<User> optionalFoundUser  = userRepository.findById(userId);
    User foundUser = UserServiceImpl.unwrapUser(optionalFoundUser);
    Note note = new Note(noteDto);
    note.setUser(foundUser);
    return noteRepository.saveAndFlush(note);
  }

  @Override
  @Transactional
  public void deleteNoteById(Long noteId) {
    Optional<Note> noteOptional = noteRepository.findById(noteId);
    Note foundNote = unwrapNote(noteOptional);
    noteRepository.delete(foundNote);
  }

  @Override
  @Transactional
  public Note updateNoteById(NoteDto noteDto) {
    Note foundNote = getNoteById(noteDto.getId());
    foundNote.setBody(noteDto.getBody());
    return noteRepository.saveAndFlush(foundNote);
  }

  static Note unwrapNote(Optional<Note> noteEntity) {
    if (noteEntity.isPresent()) {
      return noteEntity.get();
    }
    throw new RuntimeException("note not found");
  }

}
