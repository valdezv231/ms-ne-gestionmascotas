package com.example.msnegestionmascotas.dto;

import java.time.LocalDate;

public record AnimalResponse(
        Long id,
        String nombre,
        String especie,
        Integer edad,
        Double peso,
        String estado,
        LocalDate fechaIngreso
) {
}
