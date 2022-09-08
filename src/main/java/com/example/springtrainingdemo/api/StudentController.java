package com.example.springtrainingdemo.api;

import com.example.springtrainingdemo.exception.CustomerNotFoundException;
import com.example.springtrainingdemo.model.Student;
import com.example.springtrainingdemo.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@Tag(name = "student", description = "the Student  API")
public class StudentController {

    /* C R U D operations*/
    @Autowired //Searches for the Student Service in Spring IOC : Inversion of Control
    private StudentService studentService;

    @Operation(summary = "Add a new Student", description = "creates a new Student", tags = { "contact" })
    @PostMapping //C ..create
    public ResponseEntity<Student> saveStudent(@RequestBody @Valid Student student) {
        return new ResponseEntity<>(studentService.saveOrUpdate(student), HttpStatus.CREATED);
    }

    @GetMapping  //Retrieve
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    /***
     * ResponseEntity is used when status code / respone body dynamic
     * @param studentId
     * @return
     */
    @Operation(responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404",description = "Customer is not found the given Customer Id")
    })
    @GetMapping("/{id}")  //Retrieve
    public ResponseEntity<Student> getStudent(@PathVariable("id") Integer studentId) {
        Optional<Student> optStudetn = studentService.getStudents(studentId);
        if (optStudetn.isPresent()) {
            return new ResponseEntity<>(optStudetn.get(), HttpStatus.OK);
        }

        throw new CustomerNotFoundException("Customer Id =" + studentId);
        // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody @Valid Student student) {
        Optional<Student> optStudent = studentService.getStudents(student.getId());
        if (optStudent.isPresent()) {
            student = studentService.saveOrUpdate(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")  //Retrieve
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer studentId) {

        Optional<Student> optStudent = studentService.getStudents(studentId);
        if (optStudent.isPresent()) {
            studentService.deleteStudent(studentId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity handleException(RuntimeException rte) {
        rte.printStackTrace();
        return new ResponseEntity("Customer not Exist for the Given input " + rte.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }


}
