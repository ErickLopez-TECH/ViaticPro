/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author triamus
 */
public class Estructuras {

    //ArrayLists para almacenamiento
    static ArrayList<ObjEmpleado> listaEmpleados = new ArrayList<>();
    // (Aquí cada compañero agrega su lista, por ejemplo: listaUsuarios)

    //Constructor
    public Estructuras() {
    }

    //------------------------------------------Métodos de Trabajo (CRUD)------------------------------------------//
    //-----------------Para Empleados-----------------
    //Insertar
    public void agregarEmpleado(ObjEmpleado miEmpleado) {
        listaEmpleados.add(miEmpleado);
    }

    //Modificar
    public void editarEmpleado(int indice, ObjEmpleado miEmpleado) {
        listaEmpleados.set(indice, miEmpleado);
    }

    //Borrar
    public void quitarEmpleado(int indice) {
        listaEmpleados.remove(indice);
    }

    //Mostrar (la lista)
    public ArrayList<ObjEmpleado> listarEmpleados() {
        return new ArrayList<>(listaEmpleados);
    }

    public DefaultTableModel mostrarEmpleados() {
        String[] titulos = {"ID", "Cédula", "Nombre", "Apellido 1", "Apellido 2", "Teléfono", "Dirección", "Estado"};

        DefaultTableModel modelo = new DefaultTableModel(titulos, 0);

        for (int i = 0; i < listaEmpleados.size(); i++) {
            String estado = "Inactivo";
            if (listaEmpleados.get(i).getEstado() == 1) {
                estado = "Activo";
            }

            String[] fila = {
                String.valueOf(listaEmpleados.get(i).getId()),
                listaEmpleados.get(i).getCedula(),
                listaEmpleados.get(i).getNombre(),
                listaEmpleados.get(i).getApellido1(),
                listaEmpleados.get(i).getApellido2(),
                listaEmpleados.get(i).getTelefono(),
                listaEmpleados.get(i).getDireccion(),
                estado
            };
            modelo.addRow(fila);
        }
        return modelo;
    }

    
}