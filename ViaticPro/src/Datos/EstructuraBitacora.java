/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
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
    
    public DefaultTableModel filtrarBitacora(String usuarioFiltro, String fechaIni, String fechaFin) {
        String[] columnas = {"Id", "Nombre", "Sección", "Movimiento", "Fecha"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        SimpleDateFormat sdfCompleto = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        SimpleDateFormat sdfFecha = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < listaBitacora.size(); i++) {
            ObjBitacora item = listaBitacora.get(i);

            
            boolean coincideUsuario = (item.getNombre().equalsIgnoreCase(usuarioFiltro));


            boolean dentroDeRango = true;

            
            String fechaObjeto = sdfFecha.format(item.getFecha());
            dentroDeRango = (fechaObjeto.compareTo(fechaIni) >= 0 && fechaObjeto.compareTo(fechaFin) <= 0);
            

            
            if (coincideUsuario && dentroDeRango) {
                modelo.addRow(new Object[]{
                    item.getId(),
                    item.getNombre(),
                    item.getSeccion(),
                    item.getMovimiento(),
                    sdfCompleto.format(item.getFecha())
                });
            }
        }
        return modelo;
}
    
    public DefaultComboBoxModel<String> inicializarComboUser(){
        DefaultComboBoxModel<String> modeloCmb = new DefaultComboBoxModel();
        modeloCmb.addElement("");
        
        
        
        for (int i = 0; i < listaBitacora.size(); i++) {
            
            String nombre = listaBitacora.get(i).getNombre();
            
            int existe = 0;
            
            //evitar duplicados
            for (int j = 0; j < modeloCmb.getSize(); j++) {
                if (modeloCmb.getElementAt(j).equalsIgnoreCase(nombre)) {
                    existe = 1;
                    break;
                }
            }
                if (existe !=1 ) {
                    modeloCmb.addElement(nombre);
                }
            
        }
        return modeloCmb;
        
    }
    
    
    public DefaultComboBoxModel<String> filtrarNombresParaCombo(String textoBusqueda) {
    DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<>();
    modeloCombo.addElement("");
    
    for (int i = 0; i < listaBitacora.size(); i++) {
        String nombre = listaBitacora.get(i).getNombre();
        
        //ignorando mayúsculas/minúsculas
        boolean coincide = ( nombre.toLowerCase().contains(textoBusqueda.toLowerCase()));
        
        if (coincide) {
            
            boolean existe = false;
            for (int j = 0; j < modeloCombo.getSize(); j++) {
                if (modeloCombo.getElementAt(j).equalsIgnoreCase(nombre)) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                modeloCombo.addElement(nombre);
            }
        }
    }
    return modeloCombo;
}
    
    
}
