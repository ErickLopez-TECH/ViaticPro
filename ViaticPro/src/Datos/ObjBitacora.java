/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.util.Date;

/**
 *
 * @author triamus
 */
public class ObjBitacora {
    
    private int id;
    private String nombre;
    private String seccion;
    private String movimiento;
    private Date fecha;

    public ObjBitacora() {
    }

    public ObjBitacora(int id, String nombre, String seccion, String movimiento) {
        this.id = id;
        this.nombre = nombre;
        this.seccion = seccion;
        this.movimiento = movimiento;
        this.fecha = new Date();
    }
    
    //setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    
    //getters

    public Date getFecha() {
        return fecha;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public String getSeccion() {
        return seccion;
    }
    
    
}
