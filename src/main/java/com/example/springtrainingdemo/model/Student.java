package com.example.springtrainingdemo.model;

import com.example.springtrainingdemo.aop.util.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

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
public class Student extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = ValidationGroups.update.class)
    private Integer id;

    @NotBlank(message = "Name must not be blank and it should be proper value")
    @Length(min = 8, max = 50, message = " Name should be between 8 and 50 characters")
    private String name;

    @Email(groups = {ValidationGroups.create.class, ValidationGroups.update.class})
    private String email;

    // @Transient
    //private OffsetDateTime dob=OffsetDateTime.from(ZonedDateTime.now());

    @Transient //Absent from database
    @JsonIgnore // Absent from Input/Output
    private String password;


    private String age;


}
