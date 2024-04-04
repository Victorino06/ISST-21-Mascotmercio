package es.upm.dit.istt.mascotmercio21.respository

import es.upm.dit.istt.mascotmercio21.models.Establecimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Integer> {
    // Puedes agregar métodos personalizados de consulta si es necesario
}

