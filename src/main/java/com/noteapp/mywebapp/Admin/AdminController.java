package com.noteapp.mywebapp.Admin;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.noteapp.mywebapp.Note.NoteDao;
import com.noteapp.mywebapp.Note.NoteRepository;
import com.noteapp.mywebapp.Prof.ProfDao;
import com.noteapp.mywebapp.Prof.ProfRepository;
import com.noteapp.mywebapp.User.UserDao;
import com.noteapp.mywebapp.User.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    private UserRepository repoStudent;

    @Autowired
    private AdminRepository repoAdmin;
    @Autowired
    private ProfRepository repoTeacher;

    @Autowired
    private NoteRepository repoNote;

    @Autowired private AdminService service;

    @GetMapping("/manageUsers")
    public String ShowManageUsers(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("mail") != "") {
            List<UserDao> userDaoList = service.listAll();
            List<ProfDao> profDaoList = service.listAllProf();
            model.addAttribute("userDaoList", userDaoList);
            model.addAttribute("profDaoList", profDaoList);

            return "/Admin/manageUsers";
        } else {
            return "/Login/login";
        }
    }

    @GetMapping("/Admin/manageEdit/{id}")
    public String ShowManageEdit(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            UserDao user = service.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User (ID: " + id + ")" );
            model.addAttribute("id", id);
            return "Admin/manageEdit";


        }
        catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", "An error as occur, the user hasn't been saved.");
            return "redirect:/manageUsers";
        }

    }

    @GetMapping("/Admin/manageEditP/{id}")
    public String ShowManageEditP(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            ProfDao prof = service.gets(id);
            model.addAttribute("prof", prof);
            model.addAttribute("pageTitle", "Edit Prof (ID: " + id + ")" );
            model.addAttribute("id", id);
            return "Admin/manageEditP";


        }
        catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", "An error as occur, the user hasn't been saved.");
            return "redirect:/manageUsers";
        }

    }

    @PostMapping("/saveEditUsers")
    public String saveEditUsers( UserDao user, RedirectAttributes ra){
        service.saveUser(user);
        ra.addFlashAttribute("message", "The user has been saved successfully.");
        return "redirect:/manageUsers";

    }


    @PostMapping("/saveEditProf")
    public String saveEditUsers(ProfDao profs, RedirectAttributes ra){
        service.saveProfs(profs);
        ra.addFlashAttribute("message", "The user has been saved successfully.");
        return "redirect:/manageUsers";
    }

    @GetMapping("/Admin/manageDelete/{id}")
    public String userDelete(@PathVariable("id") Integer id, RedirectAttributes ra){
            service.delete(id);
            ra.addFlashAttribute("message","The user has been deleted successfully.");
            return "redirect:/manageUsers";

    }

    @GetMapping("/Admin/manageDeleteP/{id}")
    public String profDelete(@PathVariable("id") Integer id, RedirectAttributes ra){
        service.deleteProf(id);
        ra.addFlashAttribute("message","The prof has been deleted successfully.");
        return "redirect:/manageUsers";
    }



}