package com.test.demo.data;

import com.test.demo.models.CatUmu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CatUmuRepository extends JpaRepository<CatUmu, String> {
    
}
