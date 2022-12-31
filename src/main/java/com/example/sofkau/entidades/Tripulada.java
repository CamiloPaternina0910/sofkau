package com.example.sofkau.entidades;

import com.example.sofkau.entidades.Nave;
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
public class Tripulada extends Nave{

    public Tripulada(String nombre, TiposNaves tiposNaves, float toneladaPeso, float altura){
        super(nombre, tiposNaves, toneladaPeso, altura);
    }

    @Override
    public String despegar() {
        return "Son llevadas al espacio por naves de lanza";
    }

    @Override
    public String orbitar() {
        return "Se mueven en el espacio gracias a propulsores";
    }

}
