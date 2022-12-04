package com.example.springtrainingdemo.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

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
