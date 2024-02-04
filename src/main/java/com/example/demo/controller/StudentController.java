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

}
