package com.alurachallenge.foro.infra.errors;

public class ValidacionException extends RuntimeException {
    public ValidacionException(String mensaje) {
        super(mensaje);

    }
}
