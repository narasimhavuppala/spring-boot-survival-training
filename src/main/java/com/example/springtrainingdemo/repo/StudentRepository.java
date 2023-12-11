package com.example.springtrainingdemo.repo;

import com.example.springtrainingdemo.model.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * Proxy Design pattern
 *
 * JPA Repositroy ...is for the SQL Based data stores/databases
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name, Pageable pageable);

    /***
     * Finding top 3 records
     * @param name
     * @return
     */
    List<Student> findTop3ByName(String name);

}
