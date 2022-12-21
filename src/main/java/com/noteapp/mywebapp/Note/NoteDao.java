package com.noteapp.mywebapp.Note;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


@Entity
@Table(name = "notes")
public class NoteDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = 45)
    private String title;

    @Column(length = 1500)
    private String content;

    private Date addedDate;

    public NoteDao(String title, String content, Date addedDate) {
        super();
        this.id = new Random().nextInt(100000);
        this.title = title;
        this.content = content;
        this.addedDate = addedDate;
    }

    public NoteDao() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public void setDate(Date date) {
        this.addedDate = date;
    }
}