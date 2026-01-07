package com.example.msnegestionmascotas.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {

    private final String codigo;

    public ResourceNotFoundException(String codigo, String mensaje) {
        super(mensaje);
        this.codigo = codigo;
    }
}