package es.upm.dit.istt.mascotmercio21.repository;

import es.upm.dit.istt.mascotmercio21.models.Propietario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PropietarioRepository extends CrudRepository<Propietario, Integer> {
    List<Propietario> findAll();
   Optional <Propietario> findById(Propietario id);
}
