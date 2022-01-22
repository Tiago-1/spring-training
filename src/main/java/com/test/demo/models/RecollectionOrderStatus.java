package com.test.demo.models;

import lombok.Getter;

@Getter
public enum RecollectionOrderStatus {

    VALIDATED("VALIDADA"),
    DRAFT("BORRADOR"),
    CREATED("POR APROBAR DELEGACIÓN"),
    APPROVED("POR APROBAR NC"),
    PRE_AUTHORIZED("PRE-POR AUTORIZAR SA"),
    AUTHORIZED("AUTORIZADO"),
    PROGRAMMED("PROGRAMADA"),
    IN_TRANSIT("EN TRÁNSITO"),
    VALIDATION_PENDING("PENDIENTE DE VALIDACIÓN"),
    FINISHED("FINALIZADA"),
    CANCELED("CANCELADA"),
    REJECTED("RECHAZADA");

    private String regularName;

    private RecollectionOrderStatus(String regularName) {
        this.regularName = regularName;
    }

}

