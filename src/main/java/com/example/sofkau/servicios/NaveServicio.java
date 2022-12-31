package com.example.sofkau.servicios;

import com.example.sofkau.dtos.NaveDto;
import com.example.sofkau.entidades.Nave;
import com.example.sofkau.enumeraciones.TiposNaves;

import java.util.List;

public interface NaveServicio {

    public List<Nave> buscarPorNombre(String nombre);
    public List<Nave> buscarPorTipo(TiposNaves tipo);

    public List<Nave> todas();

    public Nave buscarPorId(Long id);

    public void guardar(NaveDto nave);
    public void eliminar(Nave nave);

}
