package com.example.msnegestionmascotas.repository;

import com.example.msnegestionmascotas.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {
    Optional<ApplicationEntity> findByApplicationCodeAndEnabledTrue(String code);
}
