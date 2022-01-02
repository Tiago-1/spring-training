package com.test.demo.service;

import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/{id}")
    public Umu getUmu(@PathVariable String id){
        log.info("Getting umu by id: {}",id);
            return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundError("Umu Id : " + id));
    }
    
    @Transactional( readOnly = true)
    @GetMapping(value = "/isClosed")
    public Page<Umu> getIsClosedUmu(
                                    @RequestParam(name = "isClosed", required = false, defaultValue = "1") Long isClosed, 
                                    Pageable pageable){
        log.info("Getting all umu then is closed");

        return repository.findAll(buildSpecificationClosed(isClosed),pageable);
    }

    @GetMapping(value = "/isClosed/count")
    public Long getIsCounClosedUmu(){
        log.info("Getting count of umu then is closed");
        
        return repository.countByisClosed(1);
    }

    public Specification<Umu> buildSpecificationClosed(Long isClosed){
        return new Specification<Umu>(){
            private static final long serialVersionUID = 6616138986370868410L;
            @Override
            public Predicate toPredicate(Root<Umu> root, CriteriaQuery<?> query, CriteriaBuilder cb){
                
                List<Predicate> predicates = new ArrayList<>();
                
                Predicate isClose = cb.equal(root.get("isClosed"),isClosed);

                predicates.add(isClose);

                query.distinct(true);
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }


    
}
