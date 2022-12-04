package com.noteapp.mywebapp.User;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name = "users")
//for the html call diff pages
//Mieux UserModel
public class UserDao{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true, length = 45)
    private String email;

    @Column(length =15, nullable = false,unique = true)

    private int phoneNumber;


    @Column(length =45, nullable = false, name = "last_name")
    private String lastName;
    private String password;

    @Column(length =45, nullable = false, name = "first_name")
    private String firstName;


    @Column(length =45, nullable = false)
    private String matiere;
    //math physique info
    //math physique info
    //prof math 2 eleves
    //prof 2 physique 2 ele
    //info 2 eleves

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", matiere='" + matiere + '\'' +
                '}';
    }

/*
    @ManyToMany
    private List<SubjectDao> subjectListMtM;

    public List<SubjectDao> getSubjectListMtM() {
        return subjectListMtM;
    }

    public void setSubjectListMtM(List<SubjectDao> subjectListMtM) {
        this.subjectListMtM = subjectListMtM;
    */
}

