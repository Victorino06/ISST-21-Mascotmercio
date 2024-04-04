package es.upm.dit.istt.mascotmercio21.repository;

import es.upm.dit.istt.mascotmercio21.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    List<Cliente> findAll();
    Optional <Integer> findById(Integer id);
}


