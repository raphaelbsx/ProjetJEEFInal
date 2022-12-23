/*
package com.noteapp.mywebapp;

import com.noteapp.mywebapp.Admin.AdminDao;
import com.noteapp.mywebapp.Admin.AdminRepository;
import com.noteapp.mywebapp.Prof.ProfDao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
// Test execute in the real db instead of the default memory database
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

// keep the data commited to the db
@Rollback(false)

public class AdminRepositoryTests {

    //Reference to the userRepository
    @Autowired private AdminRepository repo;

    @Test
    public void testAddNew() {
        AdminDao admin = new AdminDao();
        admin.setEmail("test1.test@gmail.com");
        admin.setPassword("test1");
        admin.setFirstName("test");



        //save method from crudRepository class
        //new instance of the object
        AdminDao savedAdmin = repo.save(admin);
        //fluent testion API
        Assertions.assertThat(savedAdmin).isNotNull();
        Assertions.assertThat(savedAdmin.getId()).isGreaterThan(0);
    }





    // toString method was added in userDao to allow this by right click -> generate ->toString() ->
    // select all fields->  ok
    // in the userDao class it would be the same for prof and admin classes
    @Test
    public void testListAll(){
        Iterable<AdminDao> admins = repo.findAll();
        Assertions.assertThat(admins).hasSizeGreaterThan(0);
        for (AdminDao admin : admins) {
            System.out.println(admin);

        }
    }



}*/
