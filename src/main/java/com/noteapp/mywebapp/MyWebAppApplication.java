package com.noteapp.mywebapp;

import com.noteapp.mywebapp.User.UserDao;
import com.noteapp.mywebapp.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyWebAppApplication {

    @Autowired
    private static UserRepository repoUser;

    public static void main(String[] args) {

        SpringApplication.run(MyWebAppApplication.class, args);
    }

    /*
    @Override
    public void run(String... args) {
        UserDao user1 = new UserDao();
        user1.setEmail("Kilian.Mbappé@gmail.com");
        user1.setPhoneNumber(0655555555);
        user1.setPassword("Kilian>Messi");
        user1.setLastName("Mbappé");
        user1.setFirstName("Kilian");
        user1.setMatiere("Anglais");

        repoUser.save(user1);
    }
     */


        /*
        UserDao user1 = new UserDao();
        user1.setEmail("Kilian.Mbappé@gmail.com");
        user1.setPhoneNumber(0655555555);
        user1.setPassword("Kilian>Messi");
        user1.setLastName("Mbappé");
        user1.setFirstName("Kilian");
        user1.setMatiere("Anglais");

        if (repoUser.findByEmail(user1.getEmail()).equals(null)) {
            repoUser.save(user1);
        }
        */
}