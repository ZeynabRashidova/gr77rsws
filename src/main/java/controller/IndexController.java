package controller;

import model.StudentModel;
import persistence.service.StudentService;
import persistence.service.StudentServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path("/index")
public class IndexController {

    @Path("/hello")
    @GET
    public void sayHello(){
        System.out.println("Hello World!!!");
    }

    /*@Path("/hello/{name}/{surname}")
    @GET
    public String sayHello(@PathParam("name") String ad, @PathParam("surname") String soyad){

        return "Hello  " + ad+" "+soyad;
    }*/

    /*@Path("/hello")
    @GET
    public String sayHello(@QueryParam("namestudent") String ad, @QueryParam("surnamestudent") String soyad){

        return "Hello  " + ad+" "+soyad;
    }*/

   /* @Path("/hello")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public StudentModel sayHello(){

        PersonModel person = new PersonModel();
        person.setId(100);
        person.setName("Zeyneb");
        person.setSurname("Rashidova");

        return person; //new PersonModel(1000,"Afaq","Tanriverdiyeva");
    }*/

  /* @Path("/hello")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public PersonModel sayHello(@QueryParam("idstudent") Integer id){

        return new PersonModel(id,"Afaq","Tanriverdiyeva");
    }*/

        private StudentService studentService = new StudentServiceImpl();

        @Path("/")
        @GET
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public List<StudentModel> getAllPersons(){

            return studentService.getAllStudent();
        }



        @Path("/add")
        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public void add(StudentModel model){

            studentService.addStudent(model);
        }

        @Path("/update")
        @PUT
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public void update(StudentModel model){

            studentService.updateStudent(model);
        }


        @Path("/{id}")
        @DELETE
        public void delete (@PathParam("id") Integer id){

            studentService.deleteStudent(id);

        }


}
