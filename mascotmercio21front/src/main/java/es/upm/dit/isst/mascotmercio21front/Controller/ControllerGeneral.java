@Controller
@RequestMapping

  public class ControllerGeneral {
    @Autowired
    private Logger log;
    
    public final String PROPIETARIOMANAGER_STRING= "http://localhost:8083/propietarios/";
    public final String CLIENTEMANAGER_STRING= "http://localhost:8083/clientes/";
    public final String ESTABLECIMIENTOMANAGER_STRING= "http://localhost:8083/establecimientos/";
    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String pantallainicial() {
        return "pantallaInicial.html";
    }
  
    @GetMapping("/Registro")
    public String registro() {
        return "Registro.html";
    }
    




  }
