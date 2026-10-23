/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dylan
 */
public class EstructuraUsuarios {
    //-- ArrayList de almacenamiento
    static ArrayList<ObjUsuario> listaUsuarios = new ArrayList<>();

    //-- Constructor
    public EstructuraUsuarios() {
    }

    //--- Métodos de Trabajo ---// Insertar, Modificar, Listar, Borrar
    //--Insertar
    public void agregarUsuario(ObjUsuario miUsuario){
        listaUsuarios.add(miUsuario);
    }
    //--Modificar
    public void editarUsuario(int indice, ObjUsuario miUsuario){
        listaUsuarios.set(indice, miUsuario);
    }
    //--Borrar
    public void quitarUsuario(int indice){
        listaUsuarios.remove(indice);
    }
    //--Devolver la lista
    public ArrayList<ObjUsuario> listarUsuarios(){
        return new ArrayList<>(listaUsuarios);
    }

    //--Mostrar en la tabla
    public DefaultTableModel mostrarUsuarios(){
        String[] titulos = {"id", "Nombre usuario", "Nombre", "Identificacion"};
        DefaultTableModel modelo = new DefaultTableModel(titulos, 0);

        for (int i = 0; i < listaUsuarios.size(); i++){
            String[] fila = {
                String.valueOf( listaUsuarios.get(i).getId() ),
                listaUsuarios.get(i).getNomUsuario(),
                listaUsuarios.get(i).getNombreCompleto(),
                listaUsuarios.get(i).getIdentificacion()
            };
            modelo.addRow(fila);
        }
        return modelo;
    }
}