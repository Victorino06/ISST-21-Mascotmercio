package es.upm.dit.istt.mascotmercio21.repository;

import es.upm.dit.istt.mascotmercio21.models.Establecimiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablecimientoRepository extends CrudRepository<Establecimiento, Integer> {
    // Puedes agregar métodos personalizados de consulta si es necesario
}
