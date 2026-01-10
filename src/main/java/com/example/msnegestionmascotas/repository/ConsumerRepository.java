package com.example.msnegestionmascotas.repository;

import com.example.msnegestionmascotas.entity.ConsumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConsumerRepository extends JpaRepository<ConsumerEntity, Long> {
    Optional<ConsumerEntity> findByConsumerIdAndEnabledTrue(String consumerId);
}
