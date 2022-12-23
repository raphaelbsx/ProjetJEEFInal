/*
package com.noteapp.mywebapp;

import com.noteapp.mywebapp.Subject.SubjectDao;
import com.noteapp.mywebapp.Subject.SubjectRepository;
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


public class SubjectRepositoryTests {

    //Reference to the subjectRepository
    @Autowired private SubjectRepository repo;
/*
    @Test
    public void testAddNew() {
        SubjectDao subject = new SubjectDao();
        subject.setName("Histoire");


        //save method from crudRepository class
        //new instance of the object
        SubjectDao savedSubject = repo.save(subject);
        //fluent testion API
        Assertions.assertThat(savedSubject).isNotNull();
        Assertions.assertThat(savedSubject.getId()).isGreaterThan(0);
    }



    // toString method was added in subjectDao to allow this by right click -> generate ->toString() ->
    // select all fields->  ok
    // in the subjectDao class it would be the same for prof and admin classes
    @Test
    public void testListAll(){
        Iterable<SubjectDao> subjects = repo.findAll();
        Assertions.assertThat(subjects).hasSizeGreaterThan(0);
        for (SubjectDao subject : subjects) {
            System.out.println(subject);

        }
    }




}
*/