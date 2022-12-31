package com.example.sofkau.dao;

import com.example.sofkau.entidades.Lanzadera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanzaderaDao extends JpaRepository<Lanzadera, Long> {

    public List<Lanzadera> findByNombreLike(String nombre);

}
