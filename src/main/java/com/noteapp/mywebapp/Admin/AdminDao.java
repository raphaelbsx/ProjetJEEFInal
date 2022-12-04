package com.noteapp.mywebapp.Admin;

import jakarta.persistence.*;


@Entity
@Table(name = "admins")
//for the html call diff pages
public class AdminDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true, length = 45)
    private String email;

    @Column(length =15, nullable = false)
    private String password;

    @Column(length =45, nullable = false, name = "first_name")
    private String firstName;


    public AdminDao(){

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Override
    public String toString() {
        return "AdminDao{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}

