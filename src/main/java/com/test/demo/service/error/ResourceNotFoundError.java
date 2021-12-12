package com.test.demo.service.error;

public class ResourceNotFoundError extends RuntimeException {
    
    private static final long serialVersionUID = 2L;

    public ResourceNotFoundError(){}

    public ResourceNotFoundError(String msn){
        super("Resource not fund Exception: "+msn);
    }
}
