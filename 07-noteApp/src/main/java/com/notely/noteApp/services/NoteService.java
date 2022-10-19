package com.notely.noteApp.services;

import com.notely.noteApp.dtos.NoteDto;
import com.notely.noteApp.entities.Note;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface NoteService {


  Note getNoteById(Long noteId);

  List<Note> getNotesByUserId(Long userId);

  @Transactional
  Note addNote(NoteDto noteDto, Long userId);

  @Transactional
  void deleteNoteById(Long noteId);

  @Transactional
  Note updateNoteById(NoteDto noteDto);
}
