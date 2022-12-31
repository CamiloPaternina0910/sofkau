package com.example.sofkau.dao;

import com.example.sofkau.entidades.Nave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NaveDao extends JpaRepository<Nave, Long> {
    public List<Nave> findByNombreLike(String nombre);
}
