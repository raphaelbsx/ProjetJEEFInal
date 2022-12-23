package com.noteapp.mywebapp.User;

import com.noteapp.mywebapp.Subject.SubjectDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.security.auth.Subject;

// passer la souris sur l'interface CrudRepository ci dessous 3 petits points -> "jump to code source" pour visualiser
// les methodes presentes dans l'interface.
@Repository
public interface UserRepository extends JpaRepository<UserDao, Integer> {

    boolean existsByEmail(String email);

    UserDao findByEmail(String email);
    public Long countById(Integer id);

    Object findByEmailAndPassword(String email, String password);
}
