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
    private UserRepository repoUsers;
    @Autowired
    private ProfRepository repoProf;

    public List<UserDao> listAll() {
        return (List<UserDao>) repoUsers.findAll();
    }

    public List<ProfDao> listAllProf() {
        return (List<ProfDao>) repoProf.findAll();
    }

    public UserDao get(Integer id) throws UserNotFoundException {
        Optional<UserDao> FoundById = repoUsers.findById(id);
        if (FoundById.isPresent()) {
            return FoundById.get();

        }
        throw new UserNotFoundException("L'utilisateur n'a pas était trouvé" + id);
    }

    public void saveUsers(UserDao users) {
        repoUsers.save(users);
    }
    public void saveProfs(ProfDao profs) {
        repoProf.save(profs);
    }

}
