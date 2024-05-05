package es.upm.dit.isst.mascotmercio21.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import es.upm.dit.isst.mascotmercio21.model.Usuario;
import es.upm.dit.isst.mascotmercio21.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    
    @GetMapping("/api/usuario/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable("id") long id) {
        System.out.println("id --" + id);
        Optional<Usuario> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @PostMapping("/api/usuario")
    public String crearUsuario(@RequestBody Usuario user) {
        try {
            List<Usuario> existList = userRepository.findByEmail(user.getEmail());
            if (existList.size() == 0) {
                userRepository.save(new Usuario(user.getNombre(), user.getApellidos(), user.getfechanacimiento(),
                        user.getEmail(), user.getcontraseña(), user.getRolUsuario()));
                return "REGISTER_SUCCESS";
            } else {
                return "EXIST";
            }

        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR.toString();
        }
    }

    
    @PostMapping("/api/usuario/login")
    public String loginUsuario(@RequestParam String email, @RequestParam String contraseña) {
        try {
            List<Usuario> existList = userRepository.findByEmail(email);
            if (existList.size() != 0) {
                if (existList.get(0).getcontraseña().equals(contraseña)) {
                    String member = !existList.get(0).getRolUsuario() ? "Cliente" : "Propietario";
                    long userId = existList.get(0).getId();
                    return "LOGIN_SUCCESS&" + member + "&" + userId;
                } else {
                    return "CONTRASEÑA_INCORRECTA";
                }
                
            } else {
                return "NOT_EXIST";
            }
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR.toString();
        }
    }

    @PutMapping("/api/usuario/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable("id") long id, @RequestBody Usuario user) {
        Optional<Usuario> userData = userRepository.findById(id);

        if (userData.isPresent()) {
          Usuario _user = userData.get();
          _user.setNombre(user.getNombre());
          _user.setApellidos(user.getApellidos());
          _user.setfechanacimiento(user.getfechanacimiento());
          _user.setEmail(user.getEmail());
          _user.setcontraseña(user.getcontraseña());
          _user.setRolUsuario(user.getRolUsuario());
          return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
