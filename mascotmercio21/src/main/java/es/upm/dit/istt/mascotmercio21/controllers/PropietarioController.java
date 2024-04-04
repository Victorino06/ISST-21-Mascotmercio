package es.upm.dit.istt.mascotmercio21.controllers;

import es.upm.dit.istt.mascotmercio21.models.Propietario;
import es.upm.dit.istt.mascotmercio21.repository.PropietarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/propietarios")
public class PropietarioController {

    @Autowired
    private PropietarioRepository propietarioRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Propietario> obtenerPropietario(@PathVariable Integer id) {
        Propietario propietario = propietarioRepository.findById(id).orElse(null);
        if (propietario != null) {
            return ResponseEntity.ok(propietario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Propietario> agregarPropietario(@RequestBody Propietario propietario) {
        Propietario nuevoPropietario = propietarioRepository.save(propietario);
        return ResponseEntity.ok(nuevoPropietario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Propietario> actualizarPropietario(@PathVariable Integer id, @RequestBody Propietario propietario) {
        Propietario propietarioExistente = propietarioRepository.findById(id).orElse(null);
        if (propietarioExistente != null) {
            propietario.setId(id);
            Propietario propietarioActualizado = propietarioRepository.save(propietario);
            return ResponseEntity.ok(propietarioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPropietario(@PathVariable Integer id) {
        Propietario propietarioExistente = propietarioRepository.findById(id).orElse(null);
        if (propietarioExistente != null) {
            propietarioRepository.delete(propietarioExistente);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
