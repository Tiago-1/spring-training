package com.test.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "CAT_UMU")
public class CatUmu {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid2")
    @Column(name = "UMU_ID")
    private String id;

    @Column(name = "UMU_CODE")
    private String umuCode;

    @Column(name = "BUDGET_CODE")
    private String budgetCode;

}
