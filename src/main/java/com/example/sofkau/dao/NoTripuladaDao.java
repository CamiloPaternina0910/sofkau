package com.example.sofkau.dao;

import com.example.sofkau.entidades.NoTripulada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoTripuladaDao extends JpaRepository<NoTripulada, Long> {

    public List<NoTripulada> findByNombreLike(String nombre);

}
