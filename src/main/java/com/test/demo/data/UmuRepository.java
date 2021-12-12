package com.test.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.test.demo.models.Umu;

public interface UmuRepository extends JpaRepository<Umu, String>{
 
    List<Umu> findByisClosed(int state);

    Long countByisClosed(int state);
}
