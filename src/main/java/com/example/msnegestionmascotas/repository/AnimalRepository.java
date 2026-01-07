package com.example.msnegestionmascotas.repository;

import com.example.msnegestionmascotas.entity.Animal;
import com.example.msnegestionmascotas.enums.EspecieAnimal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    Optional<Animal> findByIdAndDeletedFalse(Long id);

    Page<Animal> findAllByDeletedFalse(Pageable pageable);

    Page<Animal> findByEspecieAndDeletedFalse(
            EspecieAnimal especie,
            Pageable pageable
    );
}