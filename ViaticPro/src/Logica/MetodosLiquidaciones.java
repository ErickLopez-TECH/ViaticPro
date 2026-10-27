package Logica;

import Datos.EstructuraLiquidacion;
import Datos.ObjLiquidacion;
import java.util.ArrayList;
import java.util.Date;


public class MetodosLiquidaciones {

    private EstructuraLiquidacion almacen;

    public MetodosLiquidaciones() {
    }

    public MetodosLiquidaciones(EstructuraLiquidacion almacen) {
        this.almacen = almacen;
    }

    //--Cabecera
    public String validarCabecera(String identificacion, Date inicial, Date fin, String justificacion) {
        if (identificacion == null || identificacion.trim().isEmpty()) {
            return "Debe indicar la identificación";
        }
        if (inicial == null) {
            return "Debe indicar la fecha inicial";
        }
        if (fin == null) {
            return "Debe indicar la fecha final";
        }
        if (fin.before(inicial)) {
            return "La fecha final no puede ser anterior a la inicial";
        }
        if (justificacion.trim().isEmpty()) {
            return "La justificación es obligatoria";
        }
        return null;
    }

    //--Cada línea del detalle 
    public String validarLinea(String tipo, String montoTxt) {
        if (tipo.trim().isEmpty()) {
            return "Seleccione el tipo de viático";
        }
        if (montoTxt.trim().isEmpty()) {
            return "Debe indicar el monto asignado";
        }
        try {
            if (Double.parseDouble(montoTxt.trim()) <= 0) {
                return "El monto debe ser mayor que cero";
            }
        } catch (NumberFormatException e) {
            return "El monto debe ser un número válido";
        }
        return null;
    }

    //--Devuelve la posición en la lista, o -1 si no existe 
    public int buscarLiquidacion(String numero) {
        int resultado = -1;
        if (almacen == null) {
            return resultado;
        }
        ArrayList<ObjLiquidacion> misLiquidaciones = almacen.listar();
        for (int i = 0; i < misLiquidaciones.size(); i++) {
            if (misLiquidaciones.get(i).getNumero().equalsIgnoreCase(numero)) {
                resultado = i;
                break;
            }
        }
        return resultado;
    }

    //--Liquidaciones de un empleado
    public ArrayList<ObjLiquidacion> filtrarPorIdentificacion(String identificacion) {
        ArrayList<ObjLiquidacion> resultado = new ArrayList<>();
        if (almacen == null) {
            return resultado;
        }
        for (ObjLiquidacion liq : almacen.listar()) {
            if (liq.getIdentificacion().equals(identificacion)) {
                resultado.add(liq);
            }
        }
        return resultado;
    }
}
