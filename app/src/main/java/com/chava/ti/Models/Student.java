package com.chava.ti.Models;

public class Student {
    private String name;
    private String lastName;
    private String job;
    private String mail;
    private int photo;

    public Student(){

    }

    public Student(String name, String lastName, String job, String mail, int photo) {
        this.name = name;
        this.lastName = lastName;
        this.job = job;
        this.mail = mail;
        this.photo = photo;

    }

    public Student(String name, String lastName, String job, String mail) {
        this.name = name;
        this.lastName = lastName;
        this.job = job;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String area) {
        this.job = area;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
