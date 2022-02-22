package persistence.dao;

import model.StudentModel;
import persistence.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{

    @Override
    public List<StudentModel> getAllStudent() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gr77RestProject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String sql= "select u from Student u";
        List <Student> studentList=entityManager.createQuery(sql).getResultList();
        List<StudentModel> studentModels=new ArrayList<>();

        for (Student student: studentList){
            studentModels.add(new StudentModel(Student.getIdstudent(),Student.getNamestudent(),Student.getSurnamestudent()));
        }

        return studentModels;

    }

    @Override
    public void addStudent(StudentModel model){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gr77RestProject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student student=new Student();

        student.getStudent(model);

        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateStudent(StudentModel model){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gr77RestProject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, model.getIdstudent());
        student.setNamestudent(model.getNamestudent());
        student.setSurnamestudent(model.getSurnamestudent());
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteStudent(Integer Idstudent){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gr77RestProject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, Idstudent);
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }
}
