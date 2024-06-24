package com.crm.customer.domain.repository;

import com.crm.customer.domain.model.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CustomerBaseRepository<CustomerEntity, Long> {
	Page<CustomerEntity> findByCmpIdAndStatus(@Param("cmpId") Long cmpId, @Param("status") Integer status, Pageable pageable);
}
