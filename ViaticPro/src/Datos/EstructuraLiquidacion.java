package Datos;

import java.util.ArrayList;


public class EstructuraLiquidacion{

    private ArrayList<ObjLiquidacion> listaLiquidaciones = new ArrayList<>();
    private int ultimoConsecutivo = 0;

    //Siguientye numero
    public int siguienteConsecutivo() {
        return ultimoConsecutivo + 1;
    }

    public void agregar(ObjLiquidacion liq) {
        listaLiquidaciones.add(liq);
        ultimoConsecutivo = liq.getConsecutivo();
    }

    //--Devolver la lista 
    public ArrayList<ObjLiquidacion> listar() {
        return new ArrayList<>(listaLiquidaciones);
    }
}
