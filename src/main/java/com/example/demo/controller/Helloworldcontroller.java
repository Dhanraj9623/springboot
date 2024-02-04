package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworldcontroller {

    //HTTP GET Request

    @GetMapping("/hello-world")  // http://localhost:8080/hello-world
    public String HelloWorld(){
        return "Hello World";
    }
}