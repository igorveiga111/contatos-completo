package com.exemplo.contatos.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<String> handle(RecursoNaoEncontradoException ex){
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
