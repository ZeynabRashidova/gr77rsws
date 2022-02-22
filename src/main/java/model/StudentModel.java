package model;

public class StudentModel {
    private int idstudent;
    private String namestudent;
    private String surnamestudent;

    public StudentModel(int idstudent, String namestudent, String surnamestudent) {
        this.idstudent = idstudent;
        this.namestudent = namestudent;
        this.surnamestudent = surnamestudent;
    }

    public StudentModel(){

    }

    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }

    public String getNamestudent() {
        return namestudent;
    }

    public void setNamestudent(String namestudent) {
        this.namestudent = namestudent;
    }

    public String getSurnamestudent() {
        return surnamestudent;
    }

    public void setSurnamestudent(String surnamestudent) {
        this.surnamestudent = surnamestudent;
    }
}
