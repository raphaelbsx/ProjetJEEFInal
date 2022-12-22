package com.noteapp.mywebapp;

import com.noteapp.mywebapp.Admin.AdminDao;
import com.noteapp.mywebapp.Admin.AdminRepository;
import com.noteapp.mywebapp.Admin.AdminService;
import com.noteapp.mywebapp.Admin.AdminController;
import com.noteapp.mywebapp.Note.NoteDao;
import com.noteapp.mywebapp.Note.NoteRepository;
import com.noteapp.mywebapp.Prof.ProfDao;
import com.noteapp.mywebapp.Prof.ProfRepository;
import com.noteapp.mywebapp.User.UserDao;
import com.noteapp.mywebapp.User.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletRequest;


import java.util.Date;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private AdminService service;

    @Autowired
    private UserRepository repoStudent;

    @Autowired
    private AdminRepository repoAdmin;
    @Autowired
    private ProfRepository repoTeacher;

    @Autowired
    private NoteRepository repoNote;

    @GetMapping("/")
    public String ShowHomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String ShowLoginPage() {
        return "/Login/login";
    }

    @GetMapping("/members")
    public String ShowMembersPage(Model model) {
        model.addAttribute("users", repoStudent.findAll());
        return "/Register/members";
    }

    @PostMapping("/register")
    public String showSignUpFormEleve(@RequestParam String role, Model model) {
        if (role.equals("prof")) {
            model.addAttribute("prof", new ProfDao());
            return "/Register/registerProf";
        } else if (role.equals("eleve")) {
            model.addAttribute("user", new UserDao());
            return "/Register/registerEleve";
        } else {
            model.addAttribute("admin", new AdminDao());
            return "/Register/registerAdmin";
        }
    }



    /*
    @GetMapping("/registerProf")
    public String showSignUpForm(Model model) {

        model.addAttribute("user", new ProfDao());
        return "registerProf"; }

     */


    @PostMapping("/processRegisterStudent")
    public String processRegistrationStudent(@RequestParam String email, Model model, UserDao user) {
        if (repoStudent.findByEmail(email) != null) {
            model.addAttribute("email", email);
            return "/Register/emailAlreadyExists";
        } else if (repoAdmin.findByEmail(email) != null) {
            model.addAttribute("email", email);
            return "/Register/emailAlreadyExists";
        } else if (repoTeacher.findByEmail(email) != null) {
            model.addAttribute("email", email);
            return "/Register/emailAlreadyExists";
        } else {
            repoStudent.save(user);
            return "/Register/register_success";
        }
    }

    @PostMapping("/processRegisterAdmin")
    public String processRegistrationAdmin(@RequestParam String email, Model model, AdminDao admin) {
        if (repoStudent.findByEmail(email) != null) {
            model.addAttribute("email", email);
            return "/Register/emailAlreadyExists";
        } else if (repoAdmin.findByEmail(email) != null) {
            model.addAttribute("email", email);
            return "/Register/emailAlreadyExists";
        } else if (repoTeacher.findByEmail(email) != null) {
            model.addAttribute("email", email);
            return "/Register/emailAlreadyExists";
        } else {
            repoAdmin.save(admin);
            return "/Register/register_success";
        }
    }

    @PostMapping("/processRegisterTeacher")
    public String processRegistrationTeacher(@RequestParam String email, Model model, ProfDao prof) {
        if (repoStudent.findByEmail(email) != null) {
            model.addAttribute("email", email);
            return "/Register/emailAlreadyExists";
        } else if (repoAdmin.findByEmail(email) != null) {
            model.addAttribute("email", email);
            return "/Register/emailAlreadyExists";
        } else if (repoTeacher.findByEmail(email) != null) {
            model.addAttribute("email", email);
            return "/Register/emailAlreadyExists";
        } else {
            repoTeacher.save(prof);
            return "/Register/register_success";
        }
    }

    /*public String accountExistAlready()*/

    /*
    @PostMapping("/processRegisterStudent")
    public String processRegistrationStudent(UserDao user) {
        repoStudent.save(user);
        return "/Register/register_success";
    }

    @PostMapping("/processRegisterAdmin")
    public String processRegistrationAdmin(AdminDao admin) {
        repoAdmin.save(admin);
        return "/Register/register_success";
    }

    @PostMapping("/processRegisterTeacher")
    public String processRegistrationTeacher(@RequestParam String email, ProfDao prof) {
        if (repoStudent.findByEmail(email) != null) {
            return "/index";
        } else {
            repoTeacher.save(prof);
            return "/Register/register_success";
        }
    }
    */


    @PostMapping("/login")
    public String processLogin(@RequestParam String email, @RequestParam String password, Model model, HttpServletRequest request) {
        if (repoStudent.findByEmailAndPassword(email, password) != null) {
            model.addAttribute("users", repoStudent.findAll());
            HttpSession session = request.getSession();
            // session.invalidate();
            // HttpSession session2 = request.getSession();
            // session2.setAttribute( "mail", email );
            session.setAttribute("mail", email);
            return "/Login/loginsuccessful";
        }

        else if (repoAdmin.findByEmailAndPassword(email, password) != null) {
            model.addAttribute("users", repoAdmin.findAll());
            HttpSession session = request.getSession();
            session.setAttribute("mail", email);
            if (session.getAttribute("mail") != "") {
                List<UserDao> userDaoList = service.listAll();
                List<ProfDao> profDaoList = service.listAllProf();
                model.addAttribute("userDaoList", userDaoList);
                model.addAttribute("profDaoList", profDaoList);
                return "/Admin/manageUsers";
            }
            return "/Login/login";


        } else if (repoTeacher.findByEmailAndPassword(email, password) != null) {
            model.addAttribute("users", repoTeacher.findAll());
            HttpSession session = request.getSession();
            // session.invalidate();
            // HttpSession session2 = request.getSession();
            // session2.setAttribute( "mail", email );
            session.setAttribute("mail", email);
            return "/Login/loginsuccessfulTeacher";
        } else {
            return "/Login/login";
        }
    }

    @GetMapping("/static")
    public String ShowLogOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("mail") != "") {
            // return "/Login/login";
            return "/index";
        } else {
            return "/Login/login";
        }
    }

    // Back to logged page for the teacher
    @GetMapping("/home_teacher")
    public String homeTeacher() {
        return "/Login/loginsuccessfulTeacher";
    }

    // Back to looged page for the user
    @GetMapping("/home_user")
    public String homeStudent() {
        return "/Login/loginsuccessful";
    }


    // ajouter une note pour un prof
    @GetMapping("/add_notesTeacher")
    public String showAddNoteForm(Model model, HttpServletRequest request) {
        NoteDao note = new NoteDao();
        note.setEmail((String) request.getSession().getAttribute("mail"));
        model.addAttribute("note", note);

        ProfDao prof = repoTeacher.findByEmail(note.getEmail());
        model.addAttribute("proflist", prof);
        return "/Teacher/add_notesTeacher";
    }

    @GetMapping("/add_notesAdmin")
    public String showAddNoteFormAdmin(Model model) {
        model.addAttribute("note", new NoteDao());
        return "/Admin/add_notesAdmin";
    }

    // Add user note
    @GetMapping("/add_notesUser")
    public String showAddNoteFormStudent(Model model, HttpServletRequest request) {
        NoteDao note = new NoteDao();
        note.setEmail((String) request.getSession().getAttribute("mail"));
        model.addAttribute("note", note);

        UserDao user = repoStudent.findByEmail(note.getEmail());
        model.addAttribute("userlist", user);
        return "/User/add_notesUser";
    }

    // save note for student
    @PostMapping("/saveNoteUser")
    public String saveNoteStudent(NoteDao note) {
        note.setDate(new Date());
        repoNote.save(note);
        return "/Login/loginsuccessful";
    }


    // save note for teacher
    @PostMapping("/saveNoteTeacher")
    public String saveNoteTeacher(NoteDao note) {
        note.setDate(new Date());
        repoNote.save(note);
        return "/Login/loginsuccessfulTeacher";
    }

    // save note for admin
    @PostMapping("/saveNoteAdmin")
    public String saveNoteAdmin(NoteDao note) {
        note.setDate(new Date());
        repoNote.save(note);
        return "/Login/loginsuccessfulAdmin";
    }

    // show notes for student
    @GetMapping("/show_notesUser")
    public String showNotesStudent(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        model.addAttribute("noteslist", repoNote.findByEmail((String) session.getAttribute("mail")));
        return "/User/show_notesUser";
    }

    // Afficher les notes écrites par un teacher
    @GetMapping("/show_notesTeacher")
    public String showNotesTeacher(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        model.addAttribute("noteslist", repoNote.findByEmail((String) session.getAttribute("mail")));
        return "/Teacher/show_notesTeacher";
    }

    // show notes for admin
    @GetMapping("/show_notesAdmin")
    public String showNotesAdmin(Model model) {
        model.addAttribute("notes", repoNote.findAll());
        return "/Login/loginsuccessfulAdmin";
    }

    // delete note for user
    @GetMapping("/deleteNoteUser")
    public String deleteNoteStudent(@RequestParam int noteId) {
        repoNote.deleteById(noteId);
        return "/Login/loginsuccessful";
    }


    // delete note for teacher
    @GetMapping("/deleteNoteTeacher")
    public String deleteNoteTeacher(@RequestParam int noteId) {
        repoNote.deleteById(noteId);
        return "/Login/loginsuccessfulTeacher";
    }
    /*
    // delete note for admin
    @GetMapping("/deleteNoteAdmin")
    public String deleteNoteAdmin(@RequestParam Long id) {
        repoNote.deleteById(id);
        return "/Login/loginsuccessfulAdmin";
    }
    */

    // update note for user
    @GetMapping("/updateNoteUser")
    public String updateNoteStudent(@RequestParam int noteId, Model model) {
        NoteDao note = repoNote.findById(noteId).get();
        model.addAttribute("note", note);

        UserDao user = repoStudent.findByEmail(note.getEmail());
        model.addAttribute("userlist", user);
        return "/User/add_notesUser";
    }

    // update note for teacher
    @GetMapping("/updateNoteTeacher")
    public String updateNoteTeacher(@RequestParam int noteId, Model model) {
        NoteDao note = repoNote.findById(noteId).get();
        model.addAttribute("note", note);

        ProfDao prof = repoTeacher.findByEmail(note.getEmail());
        model.addAttribute("proflist", prof);
        return "/Teacher/add_notesTeacher";
    }

    /*
    // update note for admin
    @GetMapping("/updateNoteAdmin")
    public String updateNoteAdmin(@RequestParam Long id, Model model) {
        NoteDao note = repoNote.findById(id).get();
        model.addAttribute("note", note);
        return "/Login/loginsuccessfulAdmin";
    }

    // save updated note for student
    @PostMapping("/saveUpdatedNoteStudent")
    public String saveUpdatedNoteStudent(NoteDao note) {
        note.setDate(new Date());
        repoNote.save(note);
        return "/Login/loginsuccessful";
    }

    // save updated note for teacher
    @PostMapping("/saveUpdatedNoteTeacher")
    public String saveUpdatedNoteTeacher(NoteDao note) {
        note.setDate(new Date());
        repoNote.save(note);
        return "/Login/loginsuccessfulTeacher";
    }

    // save updated note for admin
    @PostMapping("/saveUpdatedNoteAdmin")
    public String saveUpdatedNoteAdmin(NoteDao note) {
        note.setDate(new Date());
        repoNote.save(note);
        return "/Login/loginsuccessfulAdmin";
    }

*/
    // Show Student/Teacher notes for the subject (Student view)
    @GetMapping("/subject_notesUser")
    public String showNotesFromSubjectU(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("mail") != "") {
            model.addAttribute("notesUserSubject", repoNote.findByEmailAndRefnote((String) session.getAttribute("mail"), 3));

            model.addAttribute("notesTeacherSubject", repoNote.findByMatiereAndRefnote("prof", 1));
            return "/User/subject_notesUser";
        }
        return "/";
    }

    // Show Student/Teacher notes for the subject (Teacher view)
    @GetMapping("/subject_notesTeacher")
    public String showNotesFromSubjectT(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("mail") != "") {
            model.addAttribute("notesProfSubject", repoNote.findByEmailAndRefnote((String) session.getAttribute("mail"), 1));

            model.addAttribute("notesStudentSubject", repoNote.findByMatiereAndRefnote("user", 3));
            return "/Teacher/subject_notesTeacher";
        }
        return "/";
    }

    //***************** Connected *****************\\

    /*

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
    public String ShowShowNotes() {
        return "/notes/show_notes";
    }

    @GetMapping("/teacher_notes")
    public String ShowTeacherNotes() { return "/notes/teacher_notes"; }

    @PostMapping("/save_notes")
    public String ShowSaveNotes(NoteDao newNote) {
        newNote.setAddedDate(new Date() );
        repoNote.save(newNote);
        return "/loginsuccessful";
    }*/
}
