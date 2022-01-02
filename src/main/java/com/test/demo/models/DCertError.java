package com.test.demo.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DELIVERY_CERTIFICATION_ERROR")
public class DCertError {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVERY_CERTIFICATION_ERROR_ID")
    private Long id;

    @Column(name = "DELIVERY_ORDER_ID")
    private String deliveryOrderId;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "DESCRIPTION")
    private String description;

}
