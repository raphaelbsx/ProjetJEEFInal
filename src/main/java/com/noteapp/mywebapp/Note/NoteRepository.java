package com.noteapp.mywebapp.Note;

import org.springframework.data.repository.CrudRepository;

// passer la souris sur l'interface CrudRepository ci dessous 3 petits points -> "jump to code source" pour visualiser
// les methodes presentes dans l'interface.
public interface NoteRepository extends CrudRepository<NoteDao, Integer> {

}