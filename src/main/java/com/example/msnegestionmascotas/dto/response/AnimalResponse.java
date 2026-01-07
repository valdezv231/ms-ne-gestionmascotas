package com.example.msnegestionmascotas.dto.response;

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
