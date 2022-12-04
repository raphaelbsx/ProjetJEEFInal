package com.noteapp.mywebapp.User;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    private UserRepository repo;

    //Etablie un lien avec la db
    @Transactional
    public void save(UserDao user) {
        repo.save(user);
    }

    @Transactional
    public void delete(UserDao user) {
        repo.delete(user);
    }

    @Transactional
    public UserDao findByEmail(String email) {
        return repo.findByEmail(email);
    }





}
