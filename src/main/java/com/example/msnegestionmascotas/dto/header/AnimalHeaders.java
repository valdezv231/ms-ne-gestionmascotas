package com.example.msnegestionmascotas.dto.header;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record  AnimalHeaders(
        @NotBlank(message = "No se envió el header obligatorio: Id-Transaccion")
        @Pattern(
                regexp = "^[0-9a-fA-F\\-]{36}$",
                message = "El header Id-Transaccion no es un UUID válido"
        )
        String idTransaccion,

        @NotBlank(message = "No se envió el header obligatorio: Application-Name")
        String applicationName,

        @NotBlank(message = "No se envió el header obligatorio: Application-Code")
        String applicationCode,

        @NotBlank(message = "No se envió el header obligatorio: Consumer-Id")
        String consumerId
) {

}
