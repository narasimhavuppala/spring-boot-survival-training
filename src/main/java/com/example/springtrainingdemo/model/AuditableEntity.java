package com.example.springtrainingdemo.model;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.util.Date;

import static jakarta.persistence.TemporalType.TIMESTAMP;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity {


    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date creationDate;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    protected Date lastModifiedDate;
}
