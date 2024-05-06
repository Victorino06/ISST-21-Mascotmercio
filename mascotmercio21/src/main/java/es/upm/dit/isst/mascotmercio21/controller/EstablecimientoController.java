package es.upm.dit.isst.mascotmercio21.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import es.upm.dit.isst.mascotmercio21.model.Establecimiento;
import es.upm.dit.isst.mascotmercio21.repository.EstablecimientoRepository;
import es.upm.dit.isst.mascotmercio21.services.MapboxService;


@RestController
public class EstablecimientoController {

    @Autowired
    EstablecimientoRepository estRepository;

    @Autowired
    private MapboxService mapboxService;

 
    @PostMapping("/api/establecimiento")
    public String createEstablishment(@RequestBody Establecimiento establecimiento) {
        try {
            estRepository.save(new Establecimiento(establecimiento.getUser(), establecimiento.getNombre(),
                    establecimiento.getDescripcion(), establecimiento.getDireccion(), establecimiento.getFoto(),
                    establecimiento.getApertura(), establecimiento.getCierre()));
            return "REGISTER_SUCCESS";

        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR.toString();
        }
    }
    
    @PutMapping("/api/establecimiento/{estId}")
    public String updateEstablishment(@PathVariable("estId") long id, @RequestBody Establecimiento establecimiento) {
        Optional<Establecimiento> estData = estRepository.findById(id);

        try {
            Establecimiento _est = estData.get();

            _est.setNombre(establecimiento.getNombre());
            _est.setDescripcion(establecimiento.getDescripcion());
            _est.setDireccion(establecimiento.getDireccion());
            _est.setApertura(establecimiento.getApertura());
            _est.setCierre(establecimiento.getCierre());

            estRepository.save(_est);

            return "REGISTER_SUCCESS";

        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR.toString();
        }
    }
    
 
    @GetMapping("/api/establecimiento/{id}")
    public ResponseEntity<Establecimiento> getEstablecimientoById(@PathVariable("id") long id) {
        Optional<Establecimiento> estData = estRepository.findById(id);
        if (estData.isPresent()) {
            return new ResponseEntity<>(estData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

     
    @GetMapping("/api/establecimiento/{key}")
    public ResponseEntity<Establecimiento> getEstablecimientoByKey(@PathVariable("key") String query) {
        System.out.println("- --------- " + query);
        List<Establecimiento> ests = estRepository.findByNombreContainingIgnoreCase(query);
        System.out.println(ests.get(0).getId());
        if (ests.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(ests.get(0), HttpStatus.OK);
        }
    }

    
    @GetMapping("/api/applied_establishments/{user}")
    public ResponseEntity<List<Establecimiento>> getAppliedEstablishmentByUser(@PathVariable("user") String user) {
        List<Establecimiento> estData = estRepository.findByUserid((user));

        if (estData.size() != 0) {
            return new ResponseEntity<>(estData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/establecimiento/{id}")
    public String deleteEstablecimiento(@PathVariable("id") long id) {
        try {
            estRepository.deleteById(id);
            return "DELETE_SUCCESS";
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR).toString();
        }
    }



}
