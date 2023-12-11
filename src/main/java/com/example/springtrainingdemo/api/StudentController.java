package com.example.springtrainingdemo.api;

import com.example.springtrainingdemo.aop.util.ValidationGroups;
import com.example.springtrainingdemo.exception.CustomerNotFoundException;
import com.example.springtrainingdemo.model.Student;
import com.example.springtrainingdemo.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@Tag(name = "student", description = "the Student  API")
@Validated
public class StudentController {

    /* C R U D operations*/
    @Autowired //Searches for the Student Service in Spring IOC : Inversion of Control
    private StudentService studentService;

    @Operation(summary = "Add a new Student", description = "creates a new Student", tags = {"contact"})
    @PostMapping //C ..create
    public ResponseEntity<Student> saveStudent(@RequestBody @Validated(ValidationGroups.create.class) Student student) {
        return new ResponseEntity<>(studentService.saveOrUpdate(student), HttpStatus.CREATED);
    }

    @GetMapping  //Retrieve
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    /***
     * ResponseEntity is used when status code / response body dynamic
     * @param studentId
     * @return
     */
    @Operation(responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Customer is not found the given Customer Id")
    })
    @GetMapping("/{id}")  //Retrieve
    public ResponseEntity<Student> getStudent(@PathVariable("id") Integer studentId) {
        Optional<Student> optStudetn = studentService.getStudentById(studentId);
        if (optStudetn.isPresent()) {
            return ResponseEntity.ok(optStudetn.get());
        }

        throw new CustomerNotFoundException("Customer Id =" + studentId);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody @Validated(ValidationGroups.update.class) Student student) {
        Optional<Student> optStudent = studentService.getStudentById(student.getId());
        if (optStudent.isPresent()) {
            student = studentService.saveOrUpdate(student);
            return ResponseEntity.ok(student);
        } else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")  //Retrieve
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer studentId) {

        Optional<Student> optStudent = studentService.getStudentById(studentId);
        if (optStudent.isPresent()) {
            studentService.deleteStudent(studentId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleException(CustomerNotFoundException rte) {
        rte.printStackTrace();
        return new ResponseEntity<>("Customer not Exist for the Given input " + rte.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{name}/{page}")
    public List<Student>  findAllWithPagination(@PathVariable("name")  String name,
                                                @PathVariable("page")   Integer page,
                                                @RequestParam("offset") Integer offset,
                                                @RequestParam("sort1")  String sort1,
                                                @RequestParam("sort2")  String sort2){

        //page 0 and offet 5 means ::: return rows 0-4  ..page starts from zero and offset means limit the records

        return this.studentService.findByName(name,page,offset,sort1,sort2);

    }


}
