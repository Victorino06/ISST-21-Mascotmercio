package es.upm.dit.istt.mascotmercio21.repository;

import es.upm.dit.istt.mascotmercio21.models.Propietario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PropietarioRepository extends CrudRepository<Propietario, Integer> {
    List<Propietario> findAll();
   Optional <Integer> findById(Integer id);
}
