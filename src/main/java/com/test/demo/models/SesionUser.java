package com.test.demo.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "SESION_USER")
public class SesionUser {

    @Id
    @Column(name = "SESION_ID")
    private String id;

    @Column(name = "SYSTEM_PROVIDER")
    private String system;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt ;

}
