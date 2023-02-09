package com.example.springtrainingdemo.service;

import com.example.springtrainingdemo.aop.util.TrackTimeTaken;
import com.example.springtrainingdemo.model.Student;
import com.example.springtrainingdemo.repo.RedisRepository;
import com.example.springtrainingdemo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired //Dependency Injection
    private StudentRepository studentRepository;

    @Autowired(required = false)
    private RedisRepository redisRepository;


    /***
     * Sending without Id...and Returning with id
     * ...few fields are auto calculated
     * @param student
     * @return
     */
    public Student saveOrUpdate(Student student) {
        student = studentRepository.save(student);  //Save is for create and update
        if (redisRepository != null)
            redisRepository.saveStudent(student);
        return student;
    }


    @TrackTimeTaken
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer studentId) {
        return studentRepository.findById(studentId);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

}
