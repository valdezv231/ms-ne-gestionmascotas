package com.example.msnegestionmascotas.dto.request;

import com.example.msnegestionmascotas.enums.EspecieAnimal;
import jakarta.validation.constraints.*;

public record AnimalRequest(
        @NotBlank
        @Size(min=3)
        String nombre,

        EspecieAnimal especie,

        @Min(0)
        Integer edad,

        @Positive
        Double peso
) {
}
