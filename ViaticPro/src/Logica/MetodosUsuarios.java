/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.EstructuraUsuarios;
import Datos.ObjUsuario;
import java.util.ArrayList;

/**
 *
 * @author Dylan
 */
public class MetodosUsuarios {

    EstructuraUsuarios almacen = new EstructuraUsuarios();

    public int siguienteUsuario() {
        int resultado = 0;
        ArrayList<ObjUsuario> misUsuarios = almacen.listarUsuarios();
        for (int i = 0; i < misUsuarios.size(); i++) {
            resultado = misUsuarios.get(i).getId();
        }
        return resultado + 1;
    }

    public int buscarUsuario(int buscar) { //-- Buscar Usuario Opción 1
        int resultado = -1;
        ArrayList<ObjUsuario> misUsuarios = almacen.listarUsuarios();
        for (int i = 0; i < misUsuarios.size(); i++) {
            if (misUsuarios.get(i).getId() == buscar) {
                resultado = i;
            }
        }
        return resultado;
    }

    public ObjUsuario buscarObjUsuario(int buscar) { //--Opciòn 2
        ObjUsuario miUsr = null;

        ArrayList<ObjUsuario> misUsuarios = almacen.listarUsuarios();
        for (int i = 0; i < misUsuarios.size(); i++) {
            if (misUsuarios.get(i).getId() == buscar) {
                miUsr = misUsuarios.get(i);
                break;
            }
        }
        return miUsr;
    }

    public int buscarUsuario(String nomUsr, String clave) { //--Métodos sobrecargados (Overload)
        int resultado = -1; //--Si no encuentra coincidencias

        //--Copia local de la lista de usuarios
        ArrayList<ObjUsuario> misUsuarios = almacen.listarUsuarios();

        //--Recorrer la lista para buscar la coincidencia de datos
        for (int i = 0; i < misUsuarios.size(); i++) {
            if ((misUsuarios.get(i).getNomUsuario().equals(nomUsr))
                    && (misUsuarios.get(i).getClave().equals(clave))) {
                resultado = i;
                break;
            }
        }

        return resultado;
    }
}
