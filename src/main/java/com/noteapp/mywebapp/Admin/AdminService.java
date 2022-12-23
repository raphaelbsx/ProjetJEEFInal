package com.noteapp.mywebapp.Admin;
import com.noteapp.mywebapp.Prof.ProfRepository;
import com.noteapp.mywebapp.User.UserDao;
import com.noteapp.mywebapp.Prof.ProfDao;
import com.noteapp.mywebapp.User.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private UserRepository repoStudent;
    @Autowired
    private ProfRepository repoTeacher;

    public List<UserDao> listAll() {
        return (List<UserDao>) repoStudent.findAll();
    }

    public List<ProfDao> listAllProf() {
        return (List<ProfDao>) repoTeacher.findAll();
    }



    public UserDao get(Integer id) throws UserNotFoundException {
        Optional<UserDao> foundById = repoStudent.findById(id);
        if (foundById.isPresent()) {
            return foundById.get();
        }
        throw new UserNotFoundException("L'utilisateur n'a pas était trouvé" + id);
    }


    public ProfDao gets(Integer id) throws UserNotFoundException {
        Optional<ProfDao> foundById = repoTeacher.findById(id);
        if (foundById.isPresent()) {
            return foundById.get();
        }
        throw new UserNotFoundException("L'utilisateur n'a pas était trouvé" + id);
    }

    public void saveUser(UserDao user) {

        repoStudent.save(user);

    }
    public void saveProfs(ProfDao profs) {
        repoTeacher.save(profs);
    }

    public void delete(Integer id){
        repoStudent.deleteById(id);
        //repoTeacher.deleteById(id);
    }
    public void deleteProf(Integer id){
        repoTeacher.deleteById(id);
        //repoTeacher.deleteById(id);
    }

}
