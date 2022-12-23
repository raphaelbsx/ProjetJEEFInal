package com.noteapp.mywebapp.Prof;

import com.noteapp.mywebapp.User.UserDao;
import org.springframework.data.repository.CrudRepository;

// passer la souris sur l'interface CrudRepository ci dessous 3 petits points -> "jump to code source" pour visualiser
// les methodes presentes dans l'interface.
public interface ProfRepository extends CrudRepository<ProfDao, Integer> {

    ProfDao findByEmail(String email);

    Object findByEmailAndPassword(String email, String password);

    public Long countById(Integer id);
}
