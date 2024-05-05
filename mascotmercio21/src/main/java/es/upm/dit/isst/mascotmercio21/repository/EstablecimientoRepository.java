package es.upm.dit.isst.mascotmercio21.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.upm.dit.isst.mascotmercio21.model.Establecimiento;

public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Long> {
    List<Establecimiento> findByUserid(String userid);
    List<Establecimiento> findByNombreContainingIgnoreCase(String nombre);
    
} 