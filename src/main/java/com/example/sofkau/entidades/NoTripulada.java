package com.example.sofkau.entidades;

import com.example.sofkau.enumeraciones.TiposNaves;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@NoArgsConstructor
public class NoTripulada extends Nave {

    public NoTripulada(String nombre, TiposNaves tiposNaves, float toneladaPeso, float altura){
        super(nombre, tiposNaves, toneladaPeso, altura);
    }

    @Override
    public String despegar() {
        return "Es llevada al espacio por naves de lanza como un transbordador";
    }

    @Override
    public String orbitar() {
        return "Se mueven gracias a la gravedad del planeta";
    }


}
