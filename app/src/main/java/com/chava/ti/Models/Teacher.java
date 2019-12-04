package com.chava.ti.Models;

public class Teacher {
    private String name;
    private String lastName;
    private String area;
    private String mail;
    private int photo;

    public Teacher(){

    }

    public Teacher(String name, String lastName, String area, String mail, int photo) {
        this.name = name;
        this.lastName = lastName;
        this.area = area;
        this.mail = mail;
        this.photo = photo;
    }

    public Teacher(String name, String lastName, String area, String mail) {
        this.name = name;
        this.lastName = lastName;
        this.area = area;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
