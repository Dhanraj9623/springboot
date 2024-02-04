package com.example.demo.controller;

import com.example.demo.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student") // http://localhost:8080/student
    public Student getStudent(){
        Student student = new Student(1,"Dhanraj","Kadam");
        return student;
    }
    @GetMapping("students") // http://localhost:8080/students
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(2,"Arya","Kadam"));
        students.add(new Student(3,"asd","qwe"));
        return students;
    }

    //Spring boot rest api with path variable
    @GetMapping("students/{id}")  // {id} - is called URI template variable ....gets replaced by function input
    // http://localhost:8080/students/2
    public Student studentPathVariable(@PathVariable int id){
        return new Student (id,"Arya","Kadam");
    }

    //Spring boot rest api with Request parameter
    // http://localhost:8080/students/query?id=1&firstname=qwerty
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,@RequestParam String firstname){
        return new Student(id,firstname,"blaawds");
    }

    // Spring boot rest api that handles http post request
    // @PostMapping and @RequestBody
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return student;
    }



}
