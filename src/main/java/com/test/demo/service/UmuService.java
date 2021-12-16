package com.test.demo.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
 
import com.test.demo.models.Umu;
import com.test.demo.service.error.ResourceNotFoundError;
import com.test.demo.data.UmuRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "api/umu")
public class UmuService {

    @Autowired
    private UmuRepository repository;

    @GetMapping(value = "/test")
    public String getTest(){
        log.info("Exito hermano");
        return "Solo te falta la conexion Mysql";
    }

    @RequestMapping(value = "/test/{id}")
    public Umu getUmu(@PathVariable String id){
        log.info("Getting umu by id: {}",id);
            return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundError("Umu Id : " + id));
    }

    @GetMapping(value = "/isClosed")
    public List<Umu> getIsClosedUmu(){
        log.info("Getting all umu then is closed");
        
        int state = 1;
        
        return repository.findByisClosed(state);
    }

    @GetMapping(value = "/isClosed/count")
    public Long getIsCounClosedUmu(){
        log.info("Getting count of umu then is closed");
        
        int state = 1;
        
        return repository.countByisClosed(state);
    }



    
}
