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
public class EstructuraViaticos {
    
    //array viaticos
    static ArrayList<ObjViatico> listaViaticos = new ArrayList<>();;

    //cosntructor de entrada
    public EstructuraViaticos() {
    }
    
    //Agregar 
    public void agregarViatico(ObjViatico miViatico){
        listaViaticos.add(miViatico);
    }
    
    //editar
    public void editarViatico(int indice, ObjViatico miViatico){
        listaViaticos.set(indice, miViatico);
    }
    
    //eliminar
    public void eliminarViatico(int indice){
        listaViaticos.remove(indice);
    }
    
    //devolver lista
    public static ArrayList<ObjViatico> listarViaticos(){
        return new ArrayList<>(listaViaticos);
    }
    
    
    //mostarr en tablas
    public DefaultTableModel mostrarViaticos(){
        String[] titulo = {"Proceso", "Nombre","Monto","Estado"};
        
        DefaultTableModel modelo = new DefaultTableModel(titulo,0);
        for (int i = 0; i < listaViaticos.size(); i++) {

            String estado;
            if(listaViaticos.get(i).getEstado() == 0){
                estado = "Activo";
            }else{
                estado = "Inactivo";
            }
            
            String[] fila = {
                String.valueOf(listaViaticos.get(i).getId()),
                listaViaticos.get(i).getNombre(),
                String.valueOf(listaViaticos.get(i).getMonto()),
                estado
            };
            modelo.addRow(fila);
        }
        return modelo;
    }
}
