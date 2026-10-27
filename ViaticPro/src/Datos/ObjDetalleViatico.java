package Datos;


public class ObjDetalleViatico {

    private String tipoViatico;
    private double monto;

    public ObjDetalleViatico(String tipoViatico, double monto) {
        this.tipoViatico = tipoViatico;
        this.monto = monto;
    }

    public String getTipoViatico() {
        return tipoViatico;
    }

    public void setTipoViatico(String tipoViatico) {
        this.tipoViatico = tipoViatico;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
}
