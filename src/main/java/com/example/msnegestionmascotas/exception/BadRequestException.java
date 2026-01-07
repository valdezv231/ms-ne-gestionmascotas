package com.example.msnegestionmascotas.exception;

public class BadRequestException extends RuntimeException {

    private final String codigo;

    public BadRequestException(String codigo, String mensaje)    {
        super(mensaje);
        this.codigo = codigo;
    }

}
