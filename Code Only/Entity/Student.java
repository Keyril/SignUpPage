package com.app.crud.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student {

    private int id;
    private String Firstname;
    private String Lastname;
    private String course;
    private String gender;


    public Student(int id, String Firstname, String Lastname, String course, String gender) {
        this.id = id;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.course = course;
        this.gender = gender;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

}
