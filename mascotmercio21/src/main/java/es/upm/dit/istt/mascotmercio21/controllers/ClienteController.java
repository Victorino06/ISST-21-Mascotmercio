package es.upm.dit.istt.mascotmercio21.controllers;

import es.upm.dit.istt.mascotmercio21.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable Integer id) {
        Cliente cliente = clienteService.obtenerClientePorId(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.agregarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Cliente clienteExistente = clienteService.obtenerClientePorId(id);
        if (clienteExistente != null) {
            cliente.setId(id);
            clienteService.actualizarCliente(cliente);
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Integer id) {
        Cliente clienteExistente = clienteService.obtenerClientePorId(id);
        if (clienteExistente != null) {
            clienteService.eliminarCliente(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
