package com.example.springtrainingdemo.api;

import com.example.springtrainingdemo.model.Student;
import com.example.springtrainingdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {

    /* C R U D operations*/
    @Autowired //Searches for the Student Service in Spring IOC : Inverion of Control
    private StudentService studentService;

    @PostMapping //C ..create
    public ResponseEntity<Student> saveStudent(@RequestBody @Valid Student student) {

        student= studentService.saveStudent(student);
        return new ResponseEntity<Student>(student
               ,
                HttpStatus.CREATED);
    }

}
