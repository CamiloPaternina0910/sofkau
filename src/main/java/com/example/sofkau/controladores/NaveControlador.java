package com.example.sofkau.controladores;

import com.example.sofkau.dtos.NaveDto;
import com.example.sofkau.entidades.Nave;
import com.example.sofkau.enumeraciones.TiposNaves;
import com.example.sofkau.respuestas.Respuesta;
import com.example.sofkau.servicios.NaveServicio;
import com.example.sofkau.entidades.Lanzadera;
import com.example.sofkau.entidades.NoTripulada;
import com.example.sofkau.entidades.Tripulada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Validated
public class NaveControlador {

    // Inyecta la depencia de la capa de servicios
    @Autowired
    private NaveServicio naveServicio;

    // Retorna el la pagina de inicio
    @GetMapping("/")
    public String obtenerIndex(Model model){
        model.addAttribute("naves", naveServicio.todas());
        String nombre = new String();
        model.addAttribute("nombreBuscar", nombre);
        return "index";
    }

    // Retorna la ruta principal pero el primer elemento será el que se buscó
    @GetMapping("/{nombre}")
    public String obtenerIndex(Model model, @RequestParam(value = "nombre", required = false) String nombre){
        model.addAttribute("naves", naveServicio.buscarPorNombre(nombre));
        return "index";
    }

    // Retorna el formulario para crear una nueva nave
    @GetMapping("/formulario/nave")
    public String obtenerFormulario(Model model, TiposNaves tiposNave, NaveDto nave){
        model.addAttribute("nave", nave);
        model.addAttribute("tiposNave", tiposNave);
        return "crearNave";
    }

    // Retorna la pagina html donde se tiene acceso al formulario para eliminar una nave
    @GetMapping("/eliminar")
    public String obtenerFormularioEliminar(NaveDto nave, Model model){
        model.addAttribute("nave", nave);
        return "eliminarNave";
    }

    // Añade una nueva nave a la base de datos
    @PostMapping("/crear/nave")
    public String crearNave( NaveDto nave){
        naveServicio.guardar(nave);
        return "index";
    }


    // Elimina una nave de la base de la tabla naves
    @PostMapping("/eliminar/nave")
    public String eliminarNave(NaveDto nave){
        naveServicio.eliminar(naveServicio.buscarPorId(nave.getId()));
        return "index";
    }
}
