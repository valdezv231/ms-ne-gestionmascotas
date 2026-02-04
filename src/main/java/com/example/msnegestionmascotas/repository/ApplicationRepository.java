package com.example.msnegestionmascotas.repository;

import com.example.msnegestionmascotas.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {

    boolean existsByApplicationNameAndApplicationCodeAndConsumerId(
            String applicationName,
            String applicationCode,
            String consumerId
    );
}