package com.notely.noteApp.controllers;

import com.notely.noteApp.dtos.NoteDto;
import com.notely.noteApp.entities.Note;
import com.notely.noteApp.services.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/notes")
@AllArgsConstructor
public class NoteController {
  private NoteService noteService;


  @PostMapping("/user/{userId}")
  public ResponseEntity<Note> addNote(@RequestBody NoteDto noteDto, @PathVariable Long userId){
    return new ResponseEntity<>(noteService.addNote(noteDto, userId), HttpStatus.OK);
  }

  @GetMapping("/{noteId}")
  public ResponseEntity<Note> getNoteById(@PathVariable Long noteId) {
    return new ResponseEntity<>(noteService.getNoteById(noteId), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<Note> updateNote(@RequestBody NoteDto noteDto) {
    return new ResponseEntity<>(noteService.updateNoteById(noteDto), HttpStatus.OK);
  }

  @DeleteMapping("/{noteId}")
  public ResponseEntity<Object> deleteNoteById(@PathVariable Long noteId) {
    noteService.deleteNoteById(noteId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<List<NoteDto>> getNotesByUser(@PathVariable Long userId) {
    return new ResponseEntity<>(noteService.getNotesByUserId(userId), HttpStatus.OK);
  }
}
