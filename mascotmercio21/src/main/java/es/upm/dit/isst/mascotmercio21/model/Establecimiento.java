package es.upm.dit.isst.mascotmercio21.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import java.time.LocalTime;

@Entity
public class Establecimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String direccion;
    private LocalTime horario; // Representa el horario utilizando LocalTime
    private String descripcion;
    private Double x;
    private Double y; 
    @Lob
    private byte[] foto; // Representa la foto como un arreglo de bytes

    public Establecimiento() {}

    public Establecimiento(int id, String nombre, String direccion, LocalTime horario, String descripcion, byte[] foto, Double x, Double y) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.descripcion = descripcion;
        this.foto = foto;
        this.x = x;
        this.y = y;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
     public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }
    
    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}
