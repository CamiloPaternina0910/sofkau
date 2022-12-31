package com.example.sofkau.servicios;

import com.example.sofkau.dao.LanzaderaDao;
import com.example.sofkau.dao.NaveDao;
import com.example.sofkau.dao.NoTripuladaDao;
import com.example.sofkau.dao.TripuladaDao;
import com.example.sofkau.dtos.NaveDto;
import com.example.sofkau.entidades.Lanzadera;
import com.example.sofkau.entidades.Nave;
import com.example.sofkau.entidades.NoTripulada;
import com.example.sofkau.entidades.Tripulada;
import com.example.sofkau.enumeraciones.TiposNaves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class NaveServicioImp implements NaveServicio{

    @Autowired
    private LanzaderaDao lanzaderaDao;

    @Autowired
    private NoTripuladaDao noTripuladaDao;

    @Autowired
    private TripuladaDao tripuladaDao;

    @Autowired
    private NaveDao naveDao;

    @Override
    public List<Nave> buscarPorNombre(String nombre) {
        return naveDao.findByNombreLike(nombre);
    }

    @Override
    public List<Nave> buscarPorTipo(TiposNaves tipo) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Nave> todas() {
        List<Nave> naves = new ArrayList<>();

        // Haciendo uso del polimorfismo añadimos las naves de varios tipos a la lista de tipo Naves
        lanzaderaDao.findAll().stream().map(nave -> naves.add(nave)).collect(Collectors.toList());
        noTripuladaDao.findAll().stream().map(nave -> naves.add(nave)).collect(Collectors.toList());
        tripuladaDao.findAll().stream().map(nave -> naves.add(nave)).collect(Collectors.toList());

        // Desordena la lista de naves
        Collections.shuffle(naves);
        return naves;
    }

    @Override
    @Transactional(readOnly = true)
    public Nave buscarPorId(Long id) {
        return naveDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void guardar(NaveDto nave) {
        switch (nave.getTipo()){

            // Haciendo uso del polimorfismo añadimos las naves de varios tipos a la lista de tipo Naves
            case LANZADERA -> lanzaderaDao.save(new Lanzadera(nave.getNombre(), nave.getTipo(),nave.getToneladasPeso(), nave.getAltura()));
            case TRIPULADAS -> tripuladaDao.save(new Tripulada(nave.getNombre(), nave.getTipo(),nave.getToneladasPeso(), nave.getAltura()));
            case NO_TRIPULADAS -> noTripuladaDao.save(new NoTripulada(nave.getNombre(), nave.getTipo(),nave.getToneladasPeso(), nave.getAltura()));
        }
    }

    @Override
    @Transactional
    public void eliminar(Nave nave) {
        naveDao.delete(nave);
    }
}
