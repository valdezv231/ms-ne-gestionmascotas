package com.example.msnegestionmascotas.repository;

import com.example.msnegestionmascotas.entity.AnimalEntity;
import com.example.msnegestionmascotas.enums.EspecieAnimal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {

    Optional<AnimalEntity> findByIdAndDeletedFalse(Long id);

    Page<AnimalEntity> findAllByDeletedFalse(Pageable pageable);

    Page<AnimalEntity> findByEspecieAndDeletedFalse(
            EspecieAnimal especie,
            Pageable pageable
    );
}