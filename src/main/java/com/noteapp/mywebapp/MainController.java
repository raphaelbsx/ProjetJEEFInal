package com.noteapp.mywebapp;

import com.noteapp.mywebapp.Note.NoteDao;
import com.noteapp.mywebapp.Note.NoteRepository;
import com.noteapp.mywebapp.Prof.ProfDao;
import com.noteapp.mywebapp.Prof.ProfRepository;
import com.noteapp.mywebapp.User.UserDao;
import com.noteapp.mywebapp.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private UserRepository repoStudent;

    @Autowired
    private ProfRepository repoTeacher;

    @Autowired
    private NoteRepository note;

    @GetMapping("/")
    public String ShowHomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String ShowLoginPage() {
        return "login";
    }

    @GetMapping("/members")
    public String ShowMembersPage(Model model) {
        model.addAttribute("users", repoStudent.findAll());
        return "/members";
    }

    @PostMapping("/register")
    public String showSignUpFormEleve(@RequestParam String role, Model model)
    {
        if (role.equals("prof")) {
            model.addAttribute("prof", new ProfDao());
            return "registerProf";
        } else{
            model.addAttribute("user", new UserDao());
            return "registerEleve";
        }
    }


    /*
    @GetMapping("/registerProf")
    public String showSignUpForm(Model model) {

        model.addAttribute("user", new ProfDao());
        return "registerProf"; }

     */



    @PostMapping("/processRegisterStudent")
    public String processRegistrationStudent(UserDao user) {
        repoStudent.save(user);
        return "register_success";
    }

    @PostMapping("/processRegisterTeacher")
    public String processRegistrationTeacher(ProfDao prof) {
        repoTeacher.save(prof);
        return "register_success";
    }


    @PostMapping("/loginsuccessful")
    public String ShowLoginSuccessfulPage(@RequestParam String email, @RequestParam String password, Model model) {

        UserDao user = repoStudent.findByEmail(email);

        if (user != null) {
            if (user.getPassword().equals(password)) {
                model.addAttribute("user", user);
                return "/loginsuccessful";
            }
        }


        return "/login";
    }

    //***************** Connected *****************\\

    @GetMapping("../index")
    public String LogOut() { return "/index"; }

    //***************** Notes *****************\\

    @GetMapping("/home")
    public String BackToHome() { return "/loginsuccessful"; }

    @GetMapping("/add_notes")
    public String ShowAddNotes(Model model) {
        model.addAttribute("note", new NoteDao());
        return "/notes/add_notes"; }

    @GetMapping("/show_notes")
    public String ShowShowNotes() { return "/notes/show_notes"; }

    @GetMapping("/teacher_notes")
    public String ShowTeacherNotes() { return "/notes/teacher_notes"; }

    @PostMapping("/save_notes")
    public String ShowSaveNotes(NoteDao newNote) {
        note.save(newNote);
        return "note_saved";
    }
}
