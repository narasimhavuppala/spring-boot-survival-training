package com.example.springtrainingdemo.repo;

import com.example.springtrainingdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/***
 * Proxy Design pattern
 *
 * JPA Repositroy ...is for the SQL Based data stores/databases
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
