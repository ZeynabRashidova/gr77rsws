package persistence.entity;

import model.StudentModel;

import javax.persistence.*;

@Entity
@Table (name="student")
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private static Integer idstudent;

   // @Column (name= "name")
    private static String namestudent;

    @Column (name= "surname")
    private static String surnamestudent;

    public void getStudent(StudentModel model){
        namestudent= model.getNamestudent();
        surnamestudent=model.getSurnamestudent();
    }

    public Student(){

    }

    public static Integer getIdstudent() { return idstudent; }

    public void setIdstudent(Integer idstudent) {
        this.idstudent = idstudent;
    }

    public static String getNamestudent() {
        return namestudent;
    }

    public void setNamestudent(String namestudent) {
        this.namestudent = namestudent;
    }

    public static String getSurnamestudent() {
        return surnamestudent;
    }

    public void setSurnamestudent(String surnamestudent) {
        this.surnamestudent = surnamestudent;
    }
}
