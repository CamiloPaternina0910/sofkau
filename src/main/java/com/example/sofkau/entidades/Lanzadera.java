package com.example.sofkau.entidades;

import com.example.sofkau.entidades.Nave;
import com.example.sofkau.enumeraciones.TiposNaves;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@NoArgsConstructor
public class Lanzadera extends Nave {

    public Lanzadera(String nombre, TiposNaves tiposNaves, float toneladaPeso, float altura){
        super(nombre, tiposNaves, toneladaPeso, altura);
    }

    @Override
    public String despegar() {
        return "Las naves lanzaderas despegan gracias a sus propulsores que tienen gran potencia para ganarle a la gravedad de la tierra y salir del planeta";
    }

    @Override
    public String orbitar() {
        return "Gracias a sus propulsores se mueve por el espacio";
    }

}
