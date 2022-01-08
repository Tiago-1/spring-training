package com.test.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.test.demo.data.DCertErrorRepository;
import com.test.demo.models.DCertError;
import com.test.demo.service.command.DCertErrorCommand;
import com.test.demo.service.error.ResourceNotFoundError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping( value ="api/cert-error")
public class DCertErrorService {
    
    @Autowired
    private DCertErrorRepository certErrorRepository;

    /**
     * GetMappings
     */
    @Transactional(readOnly = true)
    @GetMapping( value = "/" )
    private List<DCertError> getAll(){
     return certErrorRepository.findAll();   
    }

    @Transactional(readOnly = true)
    @GetMapping( value = "/count" )
    private Long getAllCount(){
     return certErrorRepository.count();   
    }

    /**
     * PostMapping
     */

    @PostMapping( value = "/add")
    public void addError(@RequestBody DCertErrorCommand command){
        log.info("Create delivery certification error for delivery {}", command.getDelivery());

        DCertError certError = new DCertError();
        certError.setDeliveryOrderId(command.getDelivery());
        certError.setCreatedAt(LocalDateTime.now());
        certError.setDescription(command.getDescription());

        certErrorRepository.saveAndFlush(certError);
    }

    /**
     * PutMapping
     */

    @PutMapping( value = "/{id}/update")
    public void updateCertError(@PathVariable Long id,@RequestBody DCertErrorCommand command){
        log.info("Update mapping for delivery {}", command.getDelivery());

        DCertError certError =  certErrorRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundError(String.format("Delivery with id is %s", id)));

        certError.setDescription(command.getDescription());

        certErrorRepository.saveAndFlush(certError);
    }

    /**
     * DeleteMapping
     */
    @DeleteMapping( value = "/{id}/delete")
    public void deleteCertError(@PathVariable Long id){
        log.info("Update mapping for delivery {}", id);

        DCertError certError =  certErrorRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundError(String.format("Delivery with id is %s", id)));

        certErrorRepository.delete(certError);
    }




    

}
