package es.upm.dit.isst.mascotmercio21front.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import java.util.logging.Logger;




@Controller
@RequestMapping

  public class ControllerGeneral {
   // private Logger log;
   @Autowired
   private String propietarioManagerString;

   @Autowired
   private String clienteManagerString;

   @Autowired
   private String establecimientoManagerString;
    
  
    // private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String pantallainicial() {
        return "pantallaInicial.html";
    }
  
    @GetMapping("/registro")
    public String registro() {
        return "Registro.html";
    }
    @GetMapping("/cliente")
    public String pantallaCliente() {
        return "Cliente/VistaPrincipalCliente.html";
    }
    @GetMapping("/cliente/perfil")
    public String pantallaperfilCliente() {
        return "Cliente/ModificarPerfil.html";
    }




  }
