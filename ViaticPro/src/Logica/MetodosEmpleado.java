/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.Estructuras;
import Datos.ObjEmpleado;
import java.util.ArrayList;

/**
 *
 * @author jdavi
 */
public class MetodosEmpleado {
    Estructuras almacen = new Estructuras();

    //funcion para obtener el id del empleado de manera automatica
    public int siguienteEmpleado(){
        int resultado = 0;
        ArrayList<ObjEmpleado> misEmpleados = almacen.listarEmpleados();
        for (int i = 0; i < misEmpleados.size(); i++){
            resultado = misEmpleados.get(i).getId();
        }
        return resultado + 1;
    }

    //busca por id, devuelve la posición en la lista (o -1 si no existe)
    public int buscarEmpleado(int buscar){
        int resultado = -1;
        ArrayList<ObjEmpleado> misEmpleados = almacen.listarEmpleados();
        for (int i = 0; i < misEmpleados.size(); i++){
            if (misEmpleados.get(i).getId() == buscar){
                resultado = i;
            }
        }
        return resultado;
    }

    //revisa si la cédula ya la tiene OTRO empleado (idActual es el que se está guardando)
    public boolean cedulaDuplicada(String cedula, int idActual){
        boolean resultado = false;
        ArrayList<ObjEmpleado> misEmpleados = almacen.listarEmpleados();
        for (int i = 0; i < misEmpleados.size(); i++){
            if (misEmpleados.get(i).getCedula().equals(cedula) && misEmpleados.get(i).getId() != idActual){
                resultado = true;
            }
        }
        return resultado;
    }

    //busca por cédula, devuelve la posición en la lista (o -1 si no existe)
    public int buscarCedula(String cedula){
        int resultado = -1;
        ArrayList<ObjEmpleado> misEmpleados = almacen.listarEmpleados();
        for (int i = 0; i < misEmpleados.size(); i++){
            if (misEmpleados.get(i).getCedula().equals(cedula)){
                resultado = i;
            }
        }
        return resultado;
    }

    //valida los datos del empleado. Devuelve el mensaje de error, o "" si todo está bien
    public String validarEmpleado(String cedula, String nombre, String apellido1, String apellido2, String telefono, String direccion){
        String resultado = "";
        if (cedula.equals("") || nombre.equals("") || apellido1.equals("") || apellido2.equals("") || telefono.equals("") || direccion.equals("")){
            resultado = "Todos los campos son obligatorios";
        }
        return resultado;
    }

    //lista solo los empleados activos (para usar en la liquidación)
    public ArrayList<ObjEmpleado> listarActivos(){
        ArrayList<ObjEmpleado> activos = new ArrayList<>();
        ArrayList<ObjEmpleado> misEmpleados = almacen.listarEmpleados();
        for (int i = 0; i < misEmpleados.size(); i++){
            if (misEmpleados.get(i).getEstado() == 1){
                activos.add(misEmpleados.get(i));
            }
        }
        return activos;
    }
}
