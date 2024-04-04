package es.upm.dit.istt.mascotmercio21.repository;

import es.upm.dit.istt.mascotmercio21.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findAll();
    Cliente findById(Integer id);
}

