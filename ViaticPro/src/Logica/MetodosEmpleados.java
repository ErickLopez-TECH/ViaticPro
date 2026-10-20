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
public class MetodosEmpleados {
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

    //revisa que el texto sean solo dígitos (para id, cédula y teléfono)
    public boolean esNumero(String texto){
        if (texto.equals("")){
            return false;
        }
        for (int i = 0; i < texto.length(); i++){
            if (!Character.isDigit(texto.charAt(i))){
                return false;
            }
        }
        return true;
    }

    //valida los datos del empleado. Devuelve el mensaje de error, o "" si todo está bien
    public String validarEmpleado(String cedula, String nombre, String apellido1, String apellido2, String telefono, String direccion){
        if (cedula.equals("") || nombre.equals("") || apellido1.equals("") || apellido2.equals("") || telefono.equals("") || direccion.equals("")){
            return "Todos los campos son obligatorios";
        }
        if (!esNumero(cedula)){
            return "La cédula solo debe contener números";
        }
        if (!esNumero(telefono)){
            return "El teléfono solo debe contener números";
        }
        return "";
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
