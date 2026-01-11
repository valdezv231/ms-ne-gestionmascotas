package com.example.msnegestionmascotas.dto.request;

import com.example.msnegestionmascotas.enums.EspecieAnimal;
import jakarta.validation.constraints.*;

public record AnimalRequest(

        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @NotNull(message = "La especie es obligatoria")
        EspecieAnimal especie,

        @Min(value = 0, message = "La edad no puede ser negativa")
        int edad,

        @Positive(message = "El peso debe ser mayor a 0")
        double peso
) {}

