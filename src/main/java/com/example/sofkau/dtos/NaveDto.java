package com.example.sofkau.dtos;

import com.example.sofkau.enumeraciones.TiposNaves;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NaveDto {

    private Long id;

    @NotEmpty(message = "El nombre de la nave es requerido")
    private String nombre;

    @NotNull(message = "El tipo de la nave debe ser especificado")
    private TiposNaves tipo;


    @NotNull(message = "Las toneladas de peso de la nave son requeridos")
    private float toneladasPeso;

    @NotNull(message = "La altura de la nave es requerida")
    private float altura;

    public NaveDto(String nombre, TiposNaves tipo, float toneladasPeso, float altura) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.toneladasPeso = toneladasPeso;
        this.altura = altura;
    }
}
