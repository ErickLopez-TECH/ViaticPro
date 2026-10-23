/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Logica;

import Datos.ObjUsuario;
import Presentacion.FrmHome;

/**
 *
 * @author triamus
 */
public class ViaticPro {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        // PRUEBA TEMPORAL (abre el menú sin pasar por el login)
        ObjUsuario prueba = new ObjUsuario();
        prueba.setNomUsuario("dreyes");
        prueba.setRol(0); // 0 = admin, se puede cambiar a 1 para probar la restricción

        FrmHome home = new FrmHome(prueba);
        home.setLocationRelativeTo(null);
        home.setVisible(true);
    }
    
}
