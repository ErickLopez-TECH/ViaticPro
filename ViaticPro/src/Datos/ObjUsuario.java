/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author alvar
 */
public class ObjUsuario {

    private int id;
    private String identificacion;
    private String nombreCompleto;
    private String nomUsuario;
    private String clave;
    private int rol;    //--0 Administrador, 1 Normal
    private int estado; //-- 0 Inactivo 1 Activo

    public ObjUsuario() {
    }

    public ObjUsuario(int id, String identificacion, String nombreCompleto,
            String nomUsuario, String clave, int rol, int estado) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombreCompleto = nombreCompleto;
        this.nomUsuario = nomUsuario;
        this.clave = clave;
        this.rol = rol;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
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
