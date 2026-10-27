package Datos;

import java.util.ArrayList;
import java.util.Date;

/**
 * Cabecera (maestro) de la liquidación. Contiene la lista de líneas (detalle).
 */
public class ObjLiquidacion {

    private int consecutivo;
    private String identificacion;
    private Date fechaInicial;
    private Date fechaFinal;
    private String justificacion; //--Una por liquidación
    private ArrayList<ObjDetalleViatico> detalle = new ArrayList<>(); //--Las líneas del maestro

    public ObjLiquidacion(int consecutivo, String identificacion,
            Date fechaInicial, Date fechaFinal, String justificacion) {
        this.consecutivo = consecutivo;
        this.identificacion = identificacion;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.justificacion = justificacion;
    }

    //--Identificador 
    
    public String getNumero() {
        return String.format("LIQ-%04d", consecutivo);
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    //--Manejo del detalle
    public void agregarLinea(ObjDetalleViatico linea) {
        detalle.add(linea);
    }

    public void quitarLinea(int posicion) {
        if (posicion >= 0 && posicion < detalle.size()) {
            detalle.remove(posicion);
        }
    }

    //--Copia de la lista
    public ArrayList<ObjDetalleViatico> getDetalle() {
        return new ArrayList<>(detalle);
    }

    
    public double getTotal() {
        double total = 0;
        for (ObjDetalleViatico l : detalle) {
            total += l.getMonto();
        }
        return total;
    }
}
