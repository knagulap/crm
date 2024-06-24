package com.crm.customer.domain.repository;

import com.crm.customer.domain.model.UserEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CustomerBaseRepository<UserEntity, Long> {
    UserEntity findByUsername(@Param("userName") String userName);
}
