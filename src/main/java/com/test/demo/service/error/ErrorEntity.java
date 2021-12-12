package com.test.demo.service.error;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(Include.NON_NULL)
public class ErrorEntity implements Serializable {

    private static final long serialVersionUID = -3256565852001622131L;

    private String error;

    private String message;

    public ErrorEntity(String error, String message) {
        this.error = error;
        this.message = message;
    }
    
    
    public ErrorEntity(Exception e, String description) {
        this.error = getDefaultCode(e);
        this.message = description;
    }
    
    protected static final String getDefaultCode(Exception e) {
        String msg = e.getClass().getSimpleName();
        msg = msg.substring(0, msg.indexOf("Exception"));
        msg = msg.replaceAll("(.)([A-Z])", "$1_$2");
        return msg.toLowerCase();
    }
}
