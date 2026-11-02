package Logica;

import Datos.EstructuraLiquidacion;
import Datos.ObjLiquidacion;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Gatherer;


public class MetodosLiquidaciones {

    private EstructuraLiquidacion almacen = new EstructuraLiquidacion();

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

        
        

        
        ArrayList<ObjLiquidacion> listaGeneral = almacen.listar();

        
        for (int i = 0; i < listaGeneral.size(); i++) {
            ObjLiquidacion liq = listaGeneral.get(i);

            
            if (liq.getIdentificacion().trim().equals(identificacion)) {
                resultado.add(liq);
            }
        }

        return resultado;
    }
    
    public int buscarLiquidacion(int id){
        int resultado = -1;
        
        ArrayList<ObjLiquidacion> miLiqui = almacen.listar();
        
        //buscamos entre la lsita(recorrer)
        for (int i = 0; i < miLiqui.size(); i++) {
            //condicionamos la bsuqueda
            if(miLiqui.get(i).getConsecutivo()== id){
                
                resultado = i;
            }
        }
        return resultado;
    }
    
    //validaciones
    public int validarAlimentacion(String hSalida, String hLlegada, String tipoViatico) {
        //1--> desayuno, 2--> almuerzo, 3-->cena, 4--> horaSalida >= llegada,5-->Supera los limites de 24 o 60 minutos
        String[] parteSalida = hSalida.split(":");
        String[] parteLlegada = hLlegada.split(":");

        int horaS = Integer.parseInt(parteSalida[0]);
        int minutosS = Integer.parseInt(parteSalida[1]);
        int horaLl = Integer.parseInt(parteLlegada[0]);
        int minutosLl = Integer.parseInt(parteLlegada[1]);

        
        int totalMinutosSalida = (horaS * 60) + minutosS;
        int totalMinutosLlegada = (horaLl * 60) + minutosLl;

        if (totalMinutosSalida >= totalMinutosLlegada) {
            return 4; 
        }

       
        if (tipoViatico.equalsIgnoreCase("Desayuno")) {
            boolean salidaDesayuno = (horaS < 7) || (horaS == 7 && minutosS == 0);
            boolean llegadaDesayuno = (horaLl > 10) || (horaLl == 10 && minutosLl >= 0);

            if (!(salidaDesayuno && llegadaDesayuno)) {
                return 1; // No cumple desayuno
            }
        } 
        else if (tipoViatico.equalsIgnoreCase("Almuerzo")) {
            boolean salidaAlmuer = (horaS < 10) || (horaS == 10 && minutosS == 0);
            boolean llegadaALmuer = (horaLl > 14) || (horaLl == 14 && minutosLl >= 0);

            if (!(salidaAlmuer && llegadaALmuer)) {
                return 2; // No cumple almuerzo
            }
        } 
        else if (tipoViatico.equalsIgnoreCase("Cena")) {
            boolean salidaCena = (horaS < 16) || (horaS == 16 && minutosS == 0);
            boolean llegadaCena = (horaLl > 20) || (horaLl == 20 && minutosLl >= 0);

            if (!(salidaCena && llegadaCena)) {
                return 3; // No cumple cena
            }
        }
        
        if((horaS > 24 || horaS<0)||(horaLl>24 || horaLl <1 )){
            return 5;
        }
        
        if ((minutosS >60 || minutosS <0)||(minutosLl>60 || minutosLl <0)) {
            return 5;
        }

        return 0; 
    }
}
