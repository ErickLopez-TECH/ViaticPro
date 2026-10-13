/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.EstructuraViaticos;
import Datos.ObjViatico;
import java.util.ArrayList;

/**
 *
 * @author triamus
 */
public class MetodosViatico {
    
    EstructuraViaticos almacen = new EstructuraViaticos();
    
    public int siguienteViatico(){
        int resultado = 0;
        
        //llenar array
        ArrayList<ObjViatico> misViaticos = almacen.listarViaticos();
        
        for (int i = 0; i < misViaticos.size(); i++) {
            
            //extraiga el ultimo id
            resultado = misViaticos.get(i).getId();
        }
        
        //resu;tado y le suma 1 para el sigueinte
        return resultado + 1;
    }
    
    public int buscarviatico(int id){
        int resultado = -1;
        
        ArrayList<ObjViatico> miviatico = almacen.listarViaticos();
        
        //buscamos entre la lsita(recorrer)
        for (int i = 0; i < miviatico.size(); i++) {
            //condicionamos la bsuqueda
            if(miviatico.get(i).getId() == id){
                
                resultado = i;
            }
        }
        return resultado;
    }
    
}
