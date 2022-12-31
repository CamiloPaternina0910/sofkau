package com.example.sofkau.entidades;

import com.example.sofkau.enumeraciones.TiposNaves;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Entity
@Table(name = "naves")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public abstract class Nave  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre de la nave es requerido")
    private String nombre;

    @NotNull(message = "El tipo de la nave debe ser especificado")
    private TiposNaves tipo;

    @NotNull(message = "Las toneladas de peso de la nave son requeridos")
    private float toneladasPeso;

    @NotNull(message = "La altura de la nave es requerida")
    private float altura;

    public Nave(String nombre, TiposNaves tipo, float toneladasPeso, float altura){
        this.nombre = nombre;
        this.tipo = tipo;
        this.toneladasPeso = toneladasPeso;
        this.altura = altura;
    }

    public abstract String despegar();

    public abstract String orbitar();

}
