package es.upm.dit.istt.mascotmercio21.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/establecimientos")
public class EstablecimientoController {

    @Autowired
    private EstablecimientoRepository establecimientoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Establecimiento> obtenerEstablecimiento(@PathVariable Integer id) {
        Establecimiento establecimiento = establecimientoRepository.findById(id).orElse(null);
        if (establecimiento != null) {
            return ResponseEntity.ok(establecimiento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Establecimiento> agregarEstablecimiento(@RequestBody Establecimiento establecimiento) {
        Establecimiento nuevoEstablecimiento = establecimientoRepository.save(establecimiento);
        return ResponseEntity.ok(nuevoEstablecimiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Establecimiento> actualizarEstablecimiento(@PathVariable Integer id, @RequestBody Establecimiento establecimiento) {
        Establecimiento establecimientoExistente = establecimientoRepository.findById(id).orElse(null);
        if (establecimientoExistente != null) {
            establecimiento.setId(id);
            Establecimiento establecimientoActualizado = establecimientoRepository.save(establecimiento);
            return ResponseEntity.ok(establecimientoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstablecimiento(@PathVariable Integer id) {
        Establecimiento establecimientoExistente = establecimientoRepository.findById(id).orElse(null);
        if (establecimientoExistente != null) {
            establecimientoRepository.delete(establecimientoExistente);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

