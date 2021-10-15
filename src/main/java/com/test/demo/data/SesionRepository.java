package com.test.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.demo.models.SesionUser;

import java.util.List;

public interface SesionRepository extends JpaRepository<SesionUser, String>{
    
    List<SesionUser> findBySystem(String system);

    SesionUser findFirstByOrderByCreatedAtDesc();

}
