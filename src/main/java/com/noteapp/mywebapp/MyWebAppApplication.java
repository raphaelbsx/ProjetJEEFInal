package com.noteapp.mywebapp;

import com.noteapp.mywebapp.Admin.AdminDao;
import com.noteapp.mywebapp.Admin.AdminRepository;
import com.noteapp.mywebapp.Note.NoteDao;
import com.noteapp.mywebapp.Note.NoteRepository;
import com.noteapp.mywebapp.Prof.ProfDao;
import com.noteapp.mywebapp.Prof.ProfRepository;
import com.noteapp.mywebapp.Subject.SubjectDao;
import com.noteapp.mywebapp.Subject.SubjectRepository;
import com.noteapp.mywebapp.User.UserDao;
import com.noteapp.mywebapp.User.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;


@SpringBootApplication
public class MyWebAppApplication implements CommandLineRunner{

    @Autowired
    private SubjectRepository repoSubject;

    @Autowired
    private AdminRepository repoAdmin;

    @Autowired
    private ProfRepository repoProf;

    @Autowired
    private UserRepository repoUser;

    @Autowired
    private NoteRepository repoNote;


    public static void main(String[] args) {

        SpringApplication.run(MyWebAppApplication.class, args);
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // Add subjects
        if (!repoSubject.existsByName("Design Patterns")) {
            ArrayList subjectlst = new ArrayList();
            subjectlst.add("Design Patterns");
            subjectlst.add("JEE");
            subjectlst.add("Media Technology");
            subjectlst.add("Communications");
            subjectlst.add("Business Ethics");
            subjectlst.add("Photography");
            subjectlst.add("Web Development");
            subjectlst.add("Learn HTML CSS");
            subjectlst.add("Social Media");
            subjectlst.add("Digital Arts");
            subjectlst.add("Media Streaming");
            for (int i = 0; i < subjectlst.size(); i++) {
                repoSubject.save(new SubjectDao(i+1, (String) subjectlst.get(i)));
            }
        }

        // Add default admin
        if (!repoAdmin.existsByEmail("admin.admin@gmail.com")) {
            repoAdmin.save(new AdminDao(1, "admin.admin@gmail.com",
                    "adminPassword", "adminFirstName"));

        }

        // Add default teachers
        if (!repoProf.existsByEmail("Koro.Sensei@gmail.com")) {
            repoProf.save(new ProfDao(1, "Koro.Sensei@gmail.com", 0600000000, "Sensei", "poulpe", "Koro", "JEE"));
        }
        if (!repoProf.existsByEmail("Shouta.Aizawa@gmail.com")) {
            repoProf.save(new ProfDao(2, "Shouta.Aizawa@gmail.com", 0601010101, "Aizawa", "prof", "Shouta", "JEE"));
        }
        if (!repoProf.existsByEmail("Albert.Einstein@gmail.com")) {
            repoProf.save(new ProfDao(3, "Albert.Einstein@gmail.com", 0700000000, "Einstein", "BigBrain1", "Albert", "Communications"));
        }

        // Add default users
        if (!repoUser.existsByEmail("Kylian.Mbappe@gmail.com")) {
            repoUser.save(new UserDao(1, "Kylian.Mbappe@gmail.com", 0602020202, "Mbappe", "eleve", "Kylian", "JEE"));
        }
        if (!repoUser.existsByEmail("Francois.Hollande@gmail.com")) {
            repoUser.save(new UserDao(2, "Francois.Hollande@gmail.com", 0603030302, "Hollande", "eleveH", "Francois", "JEE"));
        }

        // Add default notes
        if (!repoNote.existsByEmailAndTitle("Koro.Sensei@gmail.com", "Definition of JEE")) {
            repoNote.save(new NoteDao(1, "Definition of JEE","Jakarta EE is a specification for Oracle's Java platform for enterprise applications.",  new Date(), "JEE", "Koro.Sensei@gmail.com", 1));
        }
        if (!repoNote.existsByEmailAndTitle("Shouta.Aizawa@gmail.com", "Purpose of the course")) {
            repoNote.save(new NoteDao(2, "Purpose of the course","Learning.",  new Date(), "JEE", "Shouta.Aizawa@gmail.com", 1));
        }
        if (!repoNote.existsByEmailAndTitle("Francois.Hollande@gmail.com", "My first note")) {
            repoNote.save(new NoteDao(3, "My first note","This is my first note",  new Date(), "JEE", "Francois.Hollande@gmail.com", 3));
        }
        if (!repoNote.existsByEmailAndTitle("Kylian.Mbappe@gmail.com", "My first note :)")) {
            repoNote.save(new NoteDao(4, "My first note :)","This is my first note",  new Date(), "JEE", "Kylian.Mbappe@gmail.com", 3));
        }
    }


}