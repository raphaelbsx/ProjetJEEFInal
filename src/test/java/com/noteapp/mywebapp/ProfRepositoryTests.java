/*
package com.noteapp.mywebapp;

import com.noteapp.mywebapp.Prof.ProfDao;
import com.noteapp.mywebapp.Prof.ProfRepository;
import com.noteapp.mywebapp.User.UserDao;
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

public class ProfRepositoryTests {

    //Reference to the userRepository
    @Autowired private ProfRepository repo;

    @Test
    public void testAddNew() {
        ProfDao prof = new ProfDao();
        prof.setEmail("test1.test@gmail.com");
        prof.setPhoneNumber(321);
        prof.setPassword("test1");
        prof.setLastName("test");
        prof.setMatiere("Math");
        prof.setFirstName("test");



        //save method from crudRepository class
        //new instance of the object
        ProfDao savedProf = repo.save(prof);
        //fluent testion API
        Assertions.assertThat(savedProf).isNotNull();
        Assertions.assertThat(savedProf.getId()).isGreaterThan(0);
    }


    // toString method was added in userDao to allow this by right click -> generate ->toString() ->
    // select all fields->  ok
    // in the userDao class it would be the same for prof and admin classes
    @Test
    public void testListAll(){
        Iterable<ProfDao> profs = repo.findAll();
        Assertions.assertThat(profs).hasSizeGreaterThan(0);
        for (ProfDao prof : profs) {
            System.out.println(prof);

        }
    }

}
*/