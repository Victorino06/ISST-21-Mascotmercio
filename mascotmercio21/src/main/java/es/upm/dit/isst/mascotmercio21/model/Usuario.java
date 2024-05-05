package es.upm.dit.isst.mascotmercio21.model;

import jakarta.persistence.*;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "NOMBRE")
  private String nombre;

  @Column(name = "APELLIDOS")
  private String apellidos;

  @Column(name = "FECHANACIMIENTO")
  private String fechanacimiento;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "CONTRASEÑA")
  private String contraseña;

  @Column(name = "ROL_USUARIO")
  private boolean rol_usuario; // FALSE: Cliente , TRUE: Propietario

  public Usuario() {

  }

  public Usuario(String nombre, String apellidos, String fechanacimiento, String email, String contraseña, boolean rol_usuario) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.fechanacimiento = fechanacimiento;
    this.email = email;
    this.contraseña = contraseña;
    this.rol_usuario = rol_usuario;
  }

  public long getId() {
      return id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
      this.nombre = nombre;
  }
  
  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
      this.apellidos = apellidos;
  }
  
  public String getfechanacimiento() {
    return fechanacimiento;
  }

  public void setfechanacimiento(String fechanacimiento) {
      this.fechanacimiento = fechanacimiento;
  }
  
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
      this.email = email;
  }

  public String getcontraseña() {
    return contraseña;
  }

  public void setcontraseña(String contraseña) {
      this.contraseña = contraseña;
  }
  
  public boolean getRolUsuario() {
    return rol_usuario;
  }

  public void setRolUsuario(boolean rol_usuario) {
      this.rol_usuario = rol_usuario;
  }



}
