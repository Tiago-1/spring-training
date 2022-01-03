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
@Table(name = "CAT_UMU")
public class Umu {
    
    @Id
    @Column(name = "UMU_ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IS_CLOSED")
    private int isClosed;
}

