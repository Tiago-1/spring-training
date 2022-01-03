package com.test.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

import com.test.demo.models.Umu;

public interface UmuRepository extends JpaRepository<Umu, String>, JpaSpecificationExecutor<Umu>{
 
    List<Umu> findByisClosed(int state);

    Long countByisClosed(int state);
}
