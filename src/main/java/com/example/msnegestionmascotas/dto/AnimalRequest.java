package com.example.msnegestionmascotas.dto;

import com.example.msnegestionmascotas.entity.Especie;
import jakarta.validation.constraints.*;

public record AnimalRequest(

        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @NotNull(message = "La especie es obligatoria")
        Especie especie,

        @Min(value = 0, message = "La edad no puede ser negativa")
        int edad,

        @Positive(message = "El peso debe ser mayor a 0")
        double peso
) {}