package com.noteapp.mywebapp;

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
    private UserRepository repo;

    @GetMapping("/")
    public String ShowHomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String ShowLoginPage() {
        return "login";
    }

    @GetMapping("/registerProf")
    public String showSignUpForm(Model model) {

        model.addAttribute("user", new UserDao());
        return "registerProf"; }

    @PostMapping("/process_register")
    public String processRegistration(UserDao user) {
        repo.save(user);
        return "register_success";
    }

    @PostMapping("/loginsuccessful")
    public String ShowLoginSuccessfulPage(@RequestParam String email, @RequestParam String password, Model model) {

        UserDao user = repo.findByEmail(email);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                model.addAttribute("user", user);
                return "/loginsuccessful";
            }
        }
        return "/login";
    }

    @GetMapping("/members")
    public String ShowMembersPage(Model model) {
        model.addAttribute("users", repo.findAll());
        return "/members";
    }

    @PostMapping("/register")
    public String showSignUpFormEleve(@RequestParam String role, Model model)
    {
        if (role.equals("prof")) {
            model.addAttribute("user", new UserDao());
            return "registerProf";
        } else {
            model.addAttribute("user", new UserDao());
            return "registerEleve";
        }
    }
}
