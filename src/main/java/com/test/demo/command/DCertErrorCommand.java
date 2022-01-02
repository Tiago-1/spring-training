package com.test.demo.command;

import org.springframework.context.annotation.Description;

import lombok.Data;

@Data
public class DCertErrorCommand {
    
    private String delivery;

    private String description;
}
