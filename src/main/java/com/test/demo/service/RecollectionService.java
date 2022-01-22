package com.test.demo.service;

import com.test.demo.data.RecollectionOrderRepository;
import com.test.demo.data.CatUmuRepository;

import com.test.demo.models.RecollectionOrder;
import com.test.demo.models.RecollectionOrderStatus;
import com.test.demo.models.CatUmu;

import com.test.demo.service.error.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

import com.antkorwin.xsync.XSync;

@Log4j2
@RestController
@Transactional
@RequestMapping("/requests/api/recollection")
public class RecollectionService {

    @Autowired
    RecollectionOrderRepository repository;

    @Autowired
    CatUmuRepository catUmuRepository;

    private XSync<String> currentRecollectionOrderThreadSync = new XSync<>();

    @Transactional
    @GetMapping(value = "/clients/{clientId}/recollection/{currentUser}")
    public RecollectionOrder get(@PathVariable String currentUser, @PathVariable String clientId) {
        log.info("current user {} and umu {}",currentUser,clientId);
        return currentRecollectionOrderThreadSync.evaluate(currentUser, () -> repository.findByUmuIdAndCreatedByUserIdAndStatus(clientId, currentUser, RecollectionOrderStatus.DRAFT)
                .orElseGet(() -> buildNewRecollectionOrder(currentUser, clientId)));
    }

    @Transactional(readOnly = true)
    @GetMapping(value = "/{orderId}")
    public RecollectionOrder getById(@PathVariable String orderId) {
        return repository.findById(orderId)
                    .orElseThrow(() -> new ResourceNotFoundException("recollection", orderId));
    }

    @Transactional
    public RecollectionOrder buildNewRecollectionOrder(String currentUser, String clientId) {
        log.info("Creating new order for umu: {}", clientId);

        CatUmu umu = catUmuRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("umu", clientId));

        RecollectionOrder recollectionOrder = new RecollectionOrder();
        recollectionOrder.setUmu(umu);
        recollectionOrder.setStatus(RecollectionOrderStatus.DRAFT);
        recollectionOrder.setCreatedAt(LocalDateTime.now());
        recollectionOrder.setCreatedByUserId(currentUser);
        return repository.save(recollectionOrder);
    }


}
