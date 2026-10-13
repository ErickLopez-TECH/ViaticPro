/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author triamus
 */
public class ObjViatico {
    
    private int id;
    private String nombre;
    private double monto;
    private int estado; 

    public ObjViatico() {
    }

    public ObjViatico(int id, String nombre, double monto, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.monto = monto;
        this.estado = estado;
    }

    //getter 

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getMonto() {
        return monto;
    }

    public int getEstado() {
        return estado;
    }
    
    //setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}