package com.example.sofkau.dao;

import com.example.sofkau.entidades.Tripulada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripuladaDao extends JpaRepository<Tripulada, Long> {

    public List<Tripulada> findByNombreLike(String nombre);

}
