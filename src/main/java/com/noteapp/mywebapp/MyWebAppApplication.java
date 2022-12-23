package com.noteapp.mywebapp;

import com.noteapp.mywebapp.Admin.AdminDao;
import com.noteapp.mywebapp.Admin.AdminRepository;
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


    public static void main(String[] args) {

        SpringApplication.run(MyWebAppApplication.class, args);
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {

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

        if (!repoAdmin.existsByEmail("admin.admin@gmail.com")) {
            repoAdmin.save(new AdminDao(1, "admin.admin@gmail.com",
                    "adminPassword", "adminFirstName"));

        }

        if (!repoProf.existsByEmail("Koro.Sensei@gmail.com")) {
            repoProf.save(new ProfDao(1, "Koro.Sensei@gmail.com", 0600000000, "Sensei", "poulpe", "Koro", "JEE"));
        }
        if (!repoProf.existsByEmail("Shouta.Aizawa@gmail.com")) {
            repoProf.save(new ProfDao(2, "Shouta.Aizawa@gmail.com", 0601010101, "Aizawa", "prof", "Shouta", "JEE"));
        }
        if (!repoProf.existsByEmail("Albert.Einstein@gmail.com")) {
            repoProf.save(new ProfDao(3, "Albert.Einstein@gmail.com", 0700000000, "Einstein", "BigBrain1", "Albert", "Communications"));
        }


        if (!repoUser.existsByEmail("Kylian.Mbappé@gmail.com")) {
            repoUser.save(new UserDao(1, "Kylian.Mbappé@gmail.com", 0602020202, "Mbappé", "eleve", "Kylian", "JEE"));
        }

        if (!repoUser.existsByEmail("François.Hollande@gmail.com")) {
            repoUser.save(new UserDao(2, "François.Hollande@gmail.com", 0603030302, "Hollande", "eleveH", "François", "JEE"));
        }


    }


}