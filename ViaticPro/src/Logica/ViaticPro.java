/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Logica;

import Datos.EstructuraUsuarios;
import Datos.ObjUsuario;
import Presentacion.FrmHome;
import Presentacion.FrmLogin;

/**
 *
 * @author triamus
 */
public class ViaticPro {

    /**
     * @param args the command line arguments
     */
    static EstructuraUsuarios almacen = new EstructuraUsuarios();
    static MetodosUsuarios misMetodos = new MetodosUsuarios();
     public static void main(String[] args) {
         
         
        ObjUsuario miUsuario2 = new ObjUsuario();
            miUsuario2.setId(1);
            miUsuario2.setIdentificacion("2222");
            miUsuario2.setNombreCompleto("Usuario Normal");
            miUsuario2.setNomUsuario("usuario");
            miUsuario2.setClave("1234");
            miUsuario2.setRol(1);     //-- 1 Normal
            miUsuario2.setEstado(1);  //-- 1 Activo
            almacen.agregarUsuario(miUsuario2);
            
         FrmHome home = new FrmHome(miUsuario2);
        home.setLocationRelativeTo(null);
        home.setVisible(true);

        /*FrmLogin home = new FrmLogin();
        home.setLocationRelativeTo(null);
        home.setVisible(true);*/
    }
    
}
