package com.noteapp.mywebapp.Subject;

import com.noteapp.mywebapp.Prof.ProfDao;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



@Entity
@Table(name = "matieres")

public class SubjectDao{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true, length = 45)
    private String name;


    public SubjectDao(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SubjectDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /*
    @ManyToMany(mappedBy ="subjectListMtM")
    private List<UserDao> userListMtM;

    public List<UserDao> getUserListMtM() {
        return userListMtM;
    }

    public void setUserListMtM(List<UserDao> userListMtM) {
        this.userListMtM = userListMtM;
    }*/
    /*
    @OneToOne(mappedBy = "subject")
    private ProfDao prof;

     */
}