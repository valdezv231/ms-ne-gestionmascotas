package com.example.msnegestionmascotas.dto;

import jakarta.validation.constraints.*;

public record Headers(

        @NotBlank(message = "No se envió el header obligatorio: Id-Transaccion")
        String idTransaccion,

        @NotBlank(message = "No se envió el header obligatorio: Application-Name")
        String applicationName,

        @NotBlank(message = "No se envió el header obligatorio: Application-Code")
        String applicationCode,

        @NotBlank(message = "No se envió el header obligatorio: Consumer-Id")
        String consumerId
) {}
