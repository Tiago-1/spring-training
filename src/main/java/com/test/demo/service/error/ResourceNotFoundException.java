package com.test.demo.service.error;

import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -4664988249648498307L;

    public ResourceNotFoundException(String resource, Serializable id) {
        super(String.format("%s with id %s does not exist", resource, id));
    }

}
