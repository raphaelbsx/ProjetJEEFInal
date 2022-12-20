package com.noteapp.mywebapp.Admin;

import com.noteapp.mywebapp.Prof.ProfDao;
import com.noteapp.mywebapp.User.UserDao;
import org.springframework.data.repository.CrudRepository;

// passer la souris sur l'interface CrudRepository ci dessous 3 petits points -> "jump to code source" pour visualiser
// les methodes presentes dans l'interface.
public interface AdminRepository extends CrudRepository<AdminDao, Integer> {

    AdminDao findByEmail(String email);
}
