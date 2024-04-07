@RestController
@RequestMapping("/")
public class RegistroController {

    @Autowired
    private Logger log;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PropietarioRepository propietarioRepository;

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

    @PostMapping("/api/registro/cliente")
    public ResponseEntity<String> registrarCliente(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return ResponseEntity.ok("Cliente registrado correctamente");
    }

    @PostMapping("/api/registro/propietario")
    public ResponseEntity<String> registrarPropietario(@RequestBody Propietario propietario) {
        propietarioRepository.save(propietario);
        return ResponseEntity.ok("Propietario registrado correctamente");
    }
}

