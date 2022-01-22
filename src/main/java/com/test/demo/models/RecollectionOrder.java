package com.test.demo.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import org.hibernate.annotations.GenericGenerator;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "RECOLLECTION_ORDER")
@EntityListeners(AuditingEntityListener.class)
public class RecollectionOrder {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Column(name = "RECOLLECTION_ORDER_ID")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UMU_ID")
    private CatUmu umu;

    @Enumerated(EnumType.STRING)
    @Column(name = "RECOLLECTION_STATUS")
    private RecollectionOrderStatus status;


    @Column(name = "TRADE_NUMBER")
    private String tradeNumber;

    @Column(name = "JUSTIFICATION_NOTE")
    private String justificationNote;

    @Column(name = "FOLIO")
    private String folio;

    @Column(name = "SAP_ID")
    private String sapId;


    @Column(name = "CREATED_BY_USER_YKZ_ID")
    private String createdByUserId;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

}
