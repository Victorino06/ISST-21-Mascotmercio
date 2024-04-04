package es.upm.dit.istt.mascotmercio21.repository;

import es.upm.dit.istt.mascotmercio21.models.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Integer> {
    List<Propietario> findAll();
    Propietario findById(Integer id);
}
