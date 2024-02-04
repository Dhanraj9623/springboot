package com.example.demo.controller;

import com.example.demo.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")  //common to all methods so written at the top as this is base url
public class StudentController {

    @GetMapping("student") // http://localhost:8080/student
                           // http://localhost:8080./students/student
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,"Dhanraj","Kadam");

        //return new ResponseEntity<>(student,HttpStatus.OK);
        return ResponseEntity.ok().header("custom header","dsk").body(student);
    }
    @GetMapping // http://localhost:8080/students
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(2,"Arya","Kadam"));
        students.add(new Student(3,"asd","qwe"));
        return ResponseEntity.ok(students);
    }

    //Spring boot rest api with path variable
    @GetMapping("{id}")  // {id} - is called URI template variable ....gets replaced by function input
    // http://localhost:8080/students/2
    public ResponseEntity<Student> studentPathVariable(@PathVariable int id){
        Student student =new Student(id,"Arya","Kadam");
        return ResponseEntity.ok(student);
    }

    //Spring boot rest api with Request parameter
    // http://localhost:8080/students/query?id=1&firstname=qwerty
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,@RequestParam String firstname){
        Student student =new Student(id,firstname,"blaawds");
        return ResponseEntity.ok(student);
    }

    // Spring boot rest api that handles http post request
    // @PostMapping and @RequestBody
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //Spring boot rest api that handles http put request
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return ResponseEntity.ok(student);

    }

    // Spring boot rest api that handles http DELETE request - deleting the existing resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> delStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted sucessfully");
    }

}
