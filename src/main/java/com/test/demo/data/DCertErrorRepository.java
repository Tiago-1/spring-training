package com.test.demo.data;


import java.util.Optional;

import com.test.demo.models.DCertError;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DCertErrorRepository extends JpaRepository <DCertError,Long>{

    @Override
    Optional<DCertError> findById(Long id);


}
