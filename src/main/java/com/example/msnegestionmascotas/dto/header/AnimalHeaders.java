package com.example.msnegestionmascotas.dto.header;

import jakarta.validation.constraints.NotBlank;

public record AnimalHeaders(
        @NotBlank String idTransaccion,
        @NotBlank String applicationName,
        @NotBlank String applicationCode,
        @NotBlank String consumerId
) {}
