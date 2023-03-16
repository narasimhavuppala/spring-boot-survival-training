package com.example.springtrainingdemo.service;

import com.example.springtrainingdemo.aop.util.TrackTimeTaken;
import com.example.springtrainingdemo.model.Student;
import com.example.springtrainingdemo.repo.RedisRepository;
import com.example.springtrainingdemo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    /***
     * Thsi service is to demonstrate how to use the searching with offset, sort , amd page
     * and writing a custom DSL Query
     * @param name
     * @param page
     * @param offset
     * @param sort1
     * @return
     */
    public List<Student>  findByName(String name, int page, int offset, String sort1, String sort2){


        Pageable pageable= PageRequest.of(
                page,
                offset,
                Sort.by(sort1)
                        .descending()
                        .and(Sort.by(sort2)
                                .ascending()
                        )
        );
        return this.studentRepository.findByName(name , pageable);
    }

}
