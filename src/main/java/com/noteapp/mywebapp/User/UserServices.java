package com.noteapp.mywebapp.User;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    private UserRepository repoStudent;

    //Etablie un lien avec la db
    @Transactional
    public void save(UserDao user) {
        repoStudent.save(user);
    }

    @Transactional
    public void delete(UserDao user) {
        repoStudent.delete(user);
    }

    @Transactional
    public UserDao findByEmail(String email) {
        return repoStudent.findByEmail(email);
    }





}
