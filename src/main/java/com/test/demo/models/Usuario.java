package com.test.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USERS")
public class Usuario {
    
    @Id
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "NAME")
    private String nombre;

    @Column(name = "LAST_NAME")
    private String apellido;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String telefono;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ACTIVE")
    private Integer active;
    
}
