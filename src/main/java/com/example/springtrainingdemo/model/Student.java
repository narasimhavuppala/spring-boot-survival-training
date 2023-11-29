package com.example.springtrainingdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Name must not be blank and it should be proper value")
    private String name;

    @Email
    private String email;

    private OffsetDateTime dob=OffsetDateTime.from(ZonedDateTime.now());

    @Transient //Absent from database
    @JsonIgnore // Absent from Input/Output
    private String password;


}
