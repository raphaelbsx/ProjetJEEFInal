package com.noteapp.mywebapp.Note;

import com.noteapp.mywebapp.Admin.AdminDao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// passer la souris sur l'interface CrudRepository ci dessous 3 petits points -> "jump to code source" pour visualiser
// les methodes presentes dans l'interface.
public interface NoteRepository extends CrudRepository<NoteDao, Integer> {

    boolean existsByEmailAndTitle(String email, String title);

    List<NoteDao> findByEmail(String email);

    List<NoteDao> findByEmailAndRefnote(String email, int refnote);

    List<NoteDao> findByMatiereAndRefnote(String matiere, int refnote);

}