package com.test.demo.service.aspects;

import com.test.demo.models.Umu;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Aspect
@Component
public class EventAspect {

  @Async
  @AfterReturning(value = "execution( * com.test.demo.service.UmuService.getUmu(..) )", returning = "response")
  public void testAspect(Umu response) {
    log.info("Necesito esta prueba {}", response.getId());
  }
    
}
