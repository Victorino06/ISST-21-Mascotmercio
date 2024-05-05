package es.upm.dit.isst.mascotmercio21.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.upm.dit.isst.mascotmercio21.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByEmail(String email);
    List<Usuario> findByEmailAndContraseña(String email, String contraseña);
  
}
