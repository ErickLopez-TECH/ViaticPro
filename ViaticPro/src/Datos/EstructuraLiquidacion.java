package Datos;

import java.util.ArrayList;


public class EstructuraLiquidacion{

    private  static ArrayList<ObjLiquidacion> listaLiquidaciones = new ArrayList<>();
    private static int ultimoConsecutivo = 0;

    //Siguientye numero
    public int siguienteConsecutivo() {
        return ultimoConsecutivo + 1;
    }

    public void agregar(ObjLiquidacion liq) {
        listaLiquidaciones.add(liq);
        ultimoConsecutivo = liq.getConsecutivo();
    }
    
    public void editarLiquidacion(int indice, ObjLiquidacion miLiqui){
        listaLiquidaciones.set(indice, miLiqui);
    }
    
    public void quitarLiquidacion(int indice){
        listaLiquidaciones.remove(indice);
    }

    //--Devolver la lista 
    public ArrayList<ObjLiquidacion> listar() {
        return new ArrayList<>(listaLiquidaciones);
    }
}
