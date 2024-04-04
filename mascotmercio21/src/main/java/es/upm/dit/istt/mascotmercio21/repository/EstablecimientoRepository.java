package es.upm.dit.istt.mascotmercio21.repository;

import es.upm.dit.istt.mascotmercio21.models.Establecimiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EstablecimientoRepository extends CrudRepository<Establecimiento, Integer> {
    List<Establecimiento> findAll();
    Establecimiento findById(Establecimiento id);
}
