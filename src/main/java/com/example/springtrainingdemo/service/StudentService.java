package com.example.springtrainingdemo.service;

import com.example.springtrainingdemo.model.Student;
import com.example.springtrainingdemo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired //Dependency Injection
    private StudentRepository studentRepository;

    /***
     * Sending without Id...and Returning with id
     * ...few fields are auto calculated
     * @param student
     * @return
     */
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    /***
     * Electives/Optional Courses...Grading system
     * @param id
     * @return
     */
    public Optional<Student> searchStudent(Integer id) {
        return studentRepository.findById(id);
    }

}
