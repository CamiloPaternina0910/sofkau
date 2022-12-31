package com.example.sofkau.respuestas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Respuesta {

    private int status;
    private Object mensaje;
    private boolean error;
    private LocalDate fecha;

}
