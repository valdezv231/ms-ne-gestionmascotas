package com.example.msnegestionmascotas.entity;

import com.example.msnegestionmascotas.enums.EspecieAnimal;
import com.example.msnegestionmascotas.enums.EstadoAnimal;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "animales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EspecieAnimal especie;

    private Integer edad;

    private Double peso;

    @Enumerated(EnumType.STRING)
    private EstadoAnimal estado;

    private LocalDate fechaIngreso;

    @Column(nullable = false)
    @Builder.Default
    private Boolean deleted = false;
}
