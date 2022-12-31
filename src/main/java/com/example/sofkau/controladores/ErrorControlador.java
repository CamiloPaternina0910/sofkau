package com.example.sofkau.controladores;

import com.example.sofkau.respuestas.Respuesta;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorControlador {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Respuesta> handleMethodArgumentNotValid(ConstraintViolationException ex) {
        List errorsMessages = ex.getConstraintViolations()
                .stream()
                .map(constraintViolation -> constraintViolation.getMessage())
                .collect(Collectors.toList());
        return new ResponseEntity(new Respuesta(HttpStatus.BAD_REQUEST.value(), errorsMessages, true, LocalDate.now()),
                HttpStatus.BAD_REQUEST);
    }

}
