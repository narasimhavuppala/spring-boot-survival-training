package com.example.springtrainingdemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

/***
 * Domain Object ...Business Folks: Finanace Domain/Healthcare Domain
 * Model Object.....Technical People : Model Diagrams
 * ...Domain Driven API Development
 */

/***
 *  Validation works in Spring Projects only...Every object in SPring project is called as Bean
 *  and the validation is called Bean Validation
 */
@Entity
@Getter  //Lombok Annotations
@Setter  //Lombok Annotations
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name must not be blank and it should be proper value")
    @Length(min = 8, max=50, message = " Name should be between 8 and 50 characters")
    private String name;

    @Email
    private String email;

    // @Transient
    //private OffsetDateTime dob=OffsetDateTime.from(ZonedDateTime.now());

    @Transient //Absent from database
    @JsonIgnore // Absent from Input/Output
    private String password;




}
