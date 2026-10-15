/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.EstructuraBitacora;
import Datos.ObjBitacora;
import java.util.ArrayList;

/**
 *
 * @author triamus
 */
public class MetodosBitacora {
    
    EstructuraBitacora almacen = new EstructuraBitacora();
    
    public int siguienteBitacora(){
        int resultado = 0;
        
        //llenar array
        ArrayList<ObjBitacora> misBitacoras = almacen.listarBitacoras();
        
        for (int i = 0; i < misBitacoras.size(); i++) {
            
            //extraiga el ultimo id
            resultado = misBitacoras.get(i).getId();
        }
        
        //resu;tado y le suma 1 para el sigueinte
        return resultado + 1;
    }
    
}
