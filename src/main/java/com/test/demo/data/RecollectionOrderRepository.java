package com.test.demo.data;

import java.util.Optional;

import com.test.demo.models.RecollectionOrder;
import com.test.demo.models.RecollectionOrderStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface RecollectionOrderRepository extends JpaRepository<RecollectionOrder, String>, JpaSpecificationExecutor<RecollectionOrder> {
    

    Optional<RecollectionOrder> findFirstByUmuIdAndCreatedByUserIdAndStatus (String umuId, String userId,
                                                                        RecollectionOrderStatus status);


}
