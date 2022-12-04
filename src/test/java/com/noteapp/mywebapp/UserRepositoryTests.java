package com.noteapp.mywebapp;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.noteapp.mywebapp.User.UserDao;
import com.noteapp.mywebapp.User.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.sql.SQLOutput;
import java.util.Optional;

@DataJpaTest
// Test execute in the real db instead of the default memory database
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

// keep the data commited to the db
@Rollback(false)

public class UserRepositoryTests {

    //Reference to the userRepository
    @Autowired private UserRepository repo;

    @Test
    //add data into a row of a table
    public void testAddNew() {
        UserDao user = new UserDao();
        user.setEmail("test10.test@gmail.com");
        user.setPhoneNumber(3211);
        user.setPassword("test");
        user.setLastName("test6");
        user.setMatiere("Math§ez");
        user.setFirstName("testdez");

        //save method from crudRepository class
        //new instance of the object
        UserDao savedUser = repo.save(user);
        //fluent testion API
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindUserByEmail() {
        String email = "test12.test@gmail.com";

        UserDao user = repo.findByEmail(email);

        Assertions.assertThat(user).isNotNull();
    }



    // toString method was added in userDao to allow this by right click -> generate ->toString() ->
    // select all fields->  ok
    // in the userDao class it would be the same for prof and admin classes
    //list out all the data from a table
    @Test
    public void testListAll(){
        Iterable<UserDao> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for (UserDao user : users) {
            System.out.println(user);

        }
    }



    // The tests below would not be done in all the Test classes since they are really similar between each other.

    //update data in db
    @Test
    public void testUpdate() {
        Integer userId = 1;
        Optional<UserDao> optionalUserDao = repo.findById(userId);
        UserDao user = optionalUserDao.get();
        user.setPassword("updated");
        repo.save(user);

        UserDao updateUser = repo.findById(userId).get();
        Assertions.assertThat(updateUser.getPassword()).isEqualTo("updated");


    }


    //retrieve
    @Test
    public void testGet(){
        Integer userId = 2;
        Optional<UserDao> optionalUserDao = repo.findById(userId);
        Assertions.assertThat(optionalUserDao).isPresent();
        System.out.println(optionalUserDao.get());
    }

    @Test
    public void testGetEmail(){
        String email = "raphael37315170@gmail.com";
        Optional<UserDao> optionalUserDao = Optional.ofNullable(repo.findByEmail(email));
        Assertions.assertThat(optionalUserDao).isPresent();
        System.out.println(optionalUserDao.get());
    }

    @Test
    public void testDelete(){
        Integer userId = 4;
        repo.deleteById(userId);
        Optional<UserDao> optionalUserDao = repo.findById(userId);
        Assertions.assertThat(optionalUserDao).isNotPresent();


    }

}
