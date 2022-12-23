package com.noteapp.mywebapp.Prof;

import jakarta.persistence.*;
import com.noteapp.mywebapp.Subject.SubjectDao;

import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "profs")
//for the html call diff pages
public class ProfDao {

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



    public ProfDao(){

    }

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "ProfDao{" +
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
    @OneToOne
    private SubjectDao subject;

     */
}

