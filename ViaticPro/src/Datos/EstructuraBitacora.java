/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author triamus
 */
public class EstructuraBitacora {
    
    static ArrayList<ObjBitacora> listaBitacora = new ArrayList<>();

    public EstructuraBitacora() {
    }
    
    //agregar
    public void agregarBitacora(ObjBitacora miBitacora){
        listaBitacora.add(miBitacora);
    }
    
    
    public static ArrayList<ObjBitacora> listarBitacoras(){
        return new ArrayList<>(listaBitacora);
    }
    
    //mostarr en tablas
    public DefaultTableModel mostrarBitacora(){
        String[] titulo = {"Id", "Nombre","Seccion","Movimiento", "Fecha"};
        
        DefaultTableModel modelo = new DefaultTableModel(titulo,0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        for (int i = 0; i < listaBitacora.size(); i++) {

            String[] fila = {
                String.valueOf(listaBitacora.get(i).getId()),
                listaBitacora.get(i).getNombre(),
                listaBitacora.get(i).getSeccion(),
                listaBitacora.get(i).getMovimiento(),
                sdf.format(listaBitacora.get(i).getFecha())
            };
            modelo.addRow(fila);
        }
        return modelo;
    }
    
    
    public void mostrarBitacoraConsola() {
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    System.out.println("==================================================================================");
    System.out.println("                             BITÁCORA DEL SISTEMA                                 ");
    System.out.println("==================================================================================");
    System.out.printf("%-5s | %-15s | %-15s | %-20s | %-20s%n", "ID", "Nombre", "Sección", "Movimiento", "Fecha");
    System.out.println("----------------------------------------------------------------------------------");
    
    for (int i = 0; i < listaBitacora.size(); i++) {
        var item = listaBitacora.get(i);
        String fechaFormateada = "";
        if (item.getFecha() != null) {
            fechaFormateada = sdf.format(item.getFecha());
        }
        
        System.out.printf("%-5d | %-15s | %-15s | %-20s | %-20s%n",
            item.getId(),
            item.getNombre(),
            item.getSeccion(),
            item.getMovimiento(),
            fechaFormateada
        );
    }
    System.out.println("==================================================================================");
}
}
