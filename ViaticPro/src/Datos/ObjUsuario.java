/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author jdavi
 */
public class ObjUsuario {
    private int id;
    private String cedula;
    private String nombre;
    private String aprellidos;
    private String direccion;
    private String telefono;
    private String correo;
    private String nomUsuario;
    private String clave;
    private int rol; // 0:Admin | 1:Mesero | 2:Cocina | 3:Otro
    private int estado; // 0:Inactivo | 1:Activo

    //---------------------------Constructores---------------------------//
    public ObjUsuario() {
    }

    public ObjUsuario(int id, String cedula, String nombre, String aprellidos, String direccion, String telefono, String correo, String nomUsuario, String clave, int rol, int estado) {
        this.id = id;
        this.cedula     = cedula;
        this.nombre     = nombre;
        this.aprellidos = aprellidos;
        this.direccion  = direccion;
        this.telefono   = telefono;
        this.correo     = correo;
        this.nomUsuario = nomUsuario;
        this.clave      = clave;
        this.rol        = rol;
        this.estado     = estado;
    }

    //---------------------------Getters y Setters---------------------------//
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAprellidos() {
        return aprellidos;
    }

    public void setAprellidos(String aprellidos) {
        this.aprellidos = aprellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
