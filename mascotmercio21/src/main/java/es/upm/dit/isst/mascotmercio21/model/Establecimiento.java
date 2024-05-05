package es.upm.dit.isst.mascotmercio21.model;
import jakarta.persistence.*;

@Entity
@Table(name = "ESTABLECIMIENTOS")
public class Establecimiento {

    @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
  
    @Column(name = "USERID")
    private String userid;
  
    @Column(name = "NOMBRE")
    private String nombre;
  
    @Column(name = "DESCRIPCION")
    private String descripcion;
  
    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "FOTO")
    private String foto;

    @Column(name = "APERTURA")
    private String apertura;

    @Column(name = "CIERRE")
    private String cierre;

    public Establecimiento() {

  }

  public Establecimiento(String userid, String nombre, String descripcion, String direccion, String foto, String apertura, String cierre) {
      this.userid = userid;
      this.nombre = nombre;
      this.descripcion = descripcion;
      this.direccion = direccion;
      this.foto = foto;
      this.apertura = apertura;
      this.cierre = cierre;
  }
  
  public long getId() {
    return id;
  }
  
  public String getUserId() {
    return userid;
  }

  public void setUserId(String userid) {
      this.userid = userid;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
      this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  
  public String getFoto() {
    return foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }
  
  public String getApertura() {
    return apertura;
  }

  public void setApertura(String apertura) {
    this.apertura = apertura;
  }
  
  public String getCierre() {
    return cierre;
  }

  public void setCierre(String cierre) {
      this.cierre = cierre;
  }
  
}
