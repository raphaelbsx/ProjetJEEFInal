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
        Optional<UserDao> foundById = repoUsers.findById(id);
        if (foundById.isPresent()) {
            return foundById.get();
        }
        throw new UserNotFoundException("L'utilisateur n'a pas était trouvé" + id);
    }

    public void saveUser(UserDao user) {
        repoUsers.save(user);
    }
    public void saveProfs(ProfDao profs) {
        repoProf.save(profs);
    }

    public void delete(Integer id) throws UserNotFoundException{
        Long count = repoProf.countById(id);
        if (count == null || count == 0){
            throw new UserNotFoundException("L'utilisateur n'a pas était trouvé" + id);
        }
        repoUsers.deleteById(id);
    }

    public void deleteProf(Integer id){
        repoProf.deleteById(id);
    }


}
