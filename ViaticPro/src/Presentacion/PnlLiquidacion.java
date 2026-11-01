package Presentacion;

import Datos.EstructuraBitacora;
import Datos.EstructuraLiquidacion;
import Datos.EstructuraViaticos;
import Datos.ObjBitacora;
import Logica.MetodosLiquidaciones;
import Datos.ObjDetalleViatico;
import Datos.ObjEmpleado;
import Datos.ObjLiquidacion;
import Datos.ObjUsuario;
import Datos.ObjViatico;
import Logica.MetodosBitacora;
import Logica.MetodosEmpleado;
import Logica.MetodosViatico;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class PnlLiquidacion extends javax.swing.JPanel {

    private final EstructuraLiquidacion almacen;
    private final EstructuraViaticos almacenViatico = new EstructuraViaticos();
    private final EstructuraBitacora almacenBitacora = new EstructuraBitacora();
    private final MetodosLiquidaciones misMetodos = new MetodosLiquidaciones();
    private final MetodosViatico metodosViaticos = new MetodosViatico();
    private final MetodosEmpleado metodosEmplea = new MetodosEmpleado();
    private final MetodosLiquidaciones metodosLiqui= new MetodosLiquidaciones();
    private final MetodosBitacora metodosBita = new MetodosBitacora();
    private final ArrayList<ObjDetalleViatico> lineasTemp = new ArrayList<>(); 
    private final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private boolean modificar = false;
    
    
    
    private ObjUsuario usuario;
    private String nombreUser;
    static String seccion = "Liquidacion";
    static String movimiento;
    
    public PnlLiquidacion(ObjUsuario usuarioActual) {
        this(new EstructuraLiquidacion());
        
        this.usuario = usuarioActual;
        this.nombreUser = usuario.getNomUsuario();
        
        spnHoraSal.setMinimum(0);
        spnHoraSal.setMaximum(24);
        
        SpnLlegada.setMinimum(0);
        SpnLlegada.setMaximum(24);
        
        SpnMinutosSali.setMinimum(00);
        SpnMinutosSali.setMaximum(60);
        
        SpnMinutosArri.setMinimum(00);
        SpnMinutosArri.setMaximum(60);
    }

    
    public PnlLiquidacion(EstructuraLiquidacion almacen) {
        this.almacen = almacen;
        initComponents();

        
        tblLiquidaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblLiquidaciones.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                mostrarDetalle();
            }
        });

        refrescarLiquidaciones();
        nuevaLiquidacion();
    }

    //--------------------- Métodos auxiliares ---------------------
    private void nuevaLiquidacion() {
        lineasTemp.clear();
        txtNumero.setText(String.format("LIQ-%04d", almacen.siguienteConsecutivo()));
        txtIdentificacion.setText("");
        dchInicial.setDate(null);
        dchFinal.setDate(null);
        txtJustificacion.setText("");
        limpiarLinea();
        refrescarLineas();
    }

    private void limpiarLinea() {
        txtIdViatico.setText("");
        txtMonto.setText("");
    }

    private void refrescarLineas() {
        DefaultTableModel modelo = (DefaultTableModel) tblLineas.getModel();
        modelo.setRowCount(0);
        double total = 0;
        
        for (int i = 0; i < lineasTemp.size(); i++) {
            ObjDetalleViatico l = lineasTemp.get(i);
            Object[] fila = { l.getTipoViatico(),
            l.getMonto()  
        };
            modelo.addRow(fila);
            total += l.getMonto();
        }
        lblTotal.setText(String.format("%,.2f", total));
    }

    private void refrescarLiquidaciones() {
        DefaultTableModel modelo = (DefaultTableModel) tblLiquidaciones.getModel();
        modelo.setRowCount(0);
        
        ArrayList<ObjLiquidacion> lista = almacen.listar();
        for (int i = 0; i < lista.size(); i++) {
            ObjLiquidacion liqui= lista.get(i);
            
            Object[] fila = {
                liqui.getNumero(), liqui.getIdentificacion(),
                formato.format(liqui.getFechaInicial()), formato.format(liqui.getFechaFinal()),
                liqui.getJustificacion(), liqui.getHoraSalida()+" - "+liqui.getHoraLLegada(),
                        String.format("%,.2f", liqui.getTotal())
            };
            
            modelo.addRow(fila);
        }
        
        mostrarDetalle();
    }

    //--Muestra las líneas de la liquidación seleccionada en la pestaña Consultar
    private void mostrarDetalle() {
        DefaultTableModel modelo = (DefaultTableModel) tblDetalleConsulta.getModel();
        modelo.setRowCount(0);
        
        int fila = tblLiquidaciones.getSelectedRow();
        ArrayList<ObjLiquidacion> lista = almacen.listar();//lista
        
        if (fila == -1 || fila >= lista.size()) {
        lblDetalle.setText("Detalle de la liquidación seleccionada");
        return;
    }
        ObjLiquidacion liqui = lista.get(fila);
        lblDetalle.setText("Detalle de " + liqui.getNumero() + " - " + liqui.getJustificacion());
        
        //lista para obtener del elemento de detalleliqui--> debo de pasar del obj al alamcen
        ArrayList<ObjDetalleViatico> detalles = liqui.getDetalle();
         for (int i = 0; i < detalles.size(); i++) {
            ObjDetalleViatico l = detalles.get(i);
            
            modelo.addRow(new Object[]{
                l.getTipoViatico(),
                String.format("%,.2f", l.getMonto())
            });
        }
        
    }

    private void aviso(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Aviso Importante", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        pnlConsulta = new javax.swing.JPanel();
        lblLista = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLiquidaciones = new javax.swing.JTable();
        lblDetalle = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDetalleConsulta = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        pnlNueva = new javax.swing.JPanel();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblIdent = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        txtNombreE = new javax.swing.JTextField();
        lblInicial = new javax.swing.JLabel();
        dchInicial = new com.toedter.calendar.JDateChooser();
        lblFinal = new javax.swing.JLabel();
        dchFinal = new com.toedter.calendar.JDateChooser();
        lblJust = new javax.swing.JLabel();
        txtJustificacion = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblTipo = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLineas = new javax.swing.JTable();
        btnQuitar = new javax.swing.JButton();
        lblTotalTxt = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtNombreViati = new javax.swing.JTextField();
        spnHoraSal = new com.toedter.components.JSpinField();
        lblHora = new javax.swing.JLabel();
        lblHora2 = new javax.swing.JLabel();
        SpnLlegada = new com.toedter.components.JSpinField();
        txtIdViatico = new javax.swing.JTextField();
        SpnMinutosSali = new com.toedter.components.JSpinField();
        lblMinutos = new javax.swing.JLabel();
        SpnMinutosArri = new com.toedter.components.JSpinField();
        lblMinutos1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(639, 562));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabs.setBackground(new java.awt.Color(204, 255, 204));
        tabs.setForeground(new java.awt.Color(0, 102, 102));

        pnlConsulta.setBackground(new java.awt.Color(204, 255, 229));
        pnlConsulta.setLayout(null);

        lblLista.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLista.setText("Liquidaciones guardadas cli pata ver");
        pnlConsulta.add(lblLista);
        lblLista.setBounds(15, 10, 300, 24);

        tblLiquidaciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblLiquidaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N.º", "Identificación", "F. inicial", "F. final", "Justificación", "Hora", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblLiquidaciones);

        pnlConsulta.add(jScrollPane2);
        jScrollPane2.setBounds(15, 38, 600, 190);

        lblDetalle.setText("Detalle de la liquidación seleccionada");
        pnlConsulta.add(lblDetalle);
        lblDetalle.setBounds(15, 250, 400, 24);

        tblDetalleConsulta.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        tblDetalleConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de viático", "Monto asignado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblDetalleConsulta);

        pnlConsulta.add(jScrollPane3);
        jScrollPane3.setBounds(15, 278, 600, 200);

        btnModificar.setBackground(new java.awt.Color(204, 255, 204));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        pnlConsulta.add(btnModificar);
        btnModificar.setBounds(510, 240, 100, 27);

        btnEliminar.setBackground(new java.awt.Color(255, 153, 153));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton-eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnlConsulta.add(btnEliminar);
        btnEliminar.setBounds(380, 240, 120, 28);

        tabs.addTab("Consultar liquidaciones", pnlConsulta);

        pnlNueva.setBackground(new java.awt.Color(204, 255, 229));
        pnlNueva.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNumero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNumero.setText("N.º liquidación:");
        pnlNueva.add(lblNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 110, 24));

        txtNumero.setEditable(false);
        pnlNueva.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 15, 120, 24));

        lblIdent.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIdent.setText("Identificación:");
        pnlNueva.add(lblIdent, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 15, 110, 24));

        txtIdentificacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdentificacionFocusLost(evt);
            }
        });
        pnlNueva.add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 120, 24));
        pnlNueva.add(txtNombreE, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 110, 24));

        lblInicial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInicial.setText("Fecha inicial:");
        pnlNueva.add(lblInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, 110, 24));
        pnlNueva.add(dchInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 120, 24));

        lblFinal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFinal.setText("Fecha final:");
        pnlNueva.add(lblFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 90, 24));
        pnlNueva.add(dchFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 110, 24));

        lblJust.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblJust.setText("Justificación:");
        pnlNueva.add(lblJust, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 85, 110, 24));
        pnlNueva.add(txtJustificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 85, 485, 24));
        pnlNueva.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 620, 10));

        lblTipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTipo.setText("ID Viatico:");
        pnlNueva.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 110, 24));

        lblMonto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMonto.setText("Monto asignado:");
        pnlNueva.add(lblMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 120, 24));
        pnlNueva.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 120, 24));

        btnAgregar.setBackground(new java.awt.Color(204, 255, 204));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregar.setText("Agregar línea");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        pnlNueva.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 130, -1));

        tblLineas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblLineas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de viático", "Monto asignado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLineas);

        pnlNueva.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 600, 210));

        btnQuitar.setBackground(new java.awt.Color(255, 153, 153));
        btnQuitar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrador.png"))); // NOI18N
        btnQuitar.setText("Quitar línea");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        pnlNueva.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 150, 30));

        lblTotalTxt.setText("TOTAL:");
        lblTotalTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlNueva.add(lblTotalTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 60, 26));

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0.00");
        pnlNueva.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 430, 150, 26));

        btnGuardar.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista-de-verificacion.png"))); // NOI18N
        btnGuardar.setText("Guardar liquidación");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlNueva.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 470, 210, -1));
        pnlNueva.add(txtNombreViati, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 160, -1));
        pnlNueva.add(spnHoraSal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 40, 20));

        lblHora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHora.setText("Hora Inicio:");
        pnlNueva.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 90, -1));

        lblHora2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHora2.setText("Hora llegadal:");
        pnlNueva.add(lblHora2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, -1));
        pnlNueva.add(SpnLlegada, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 40, 20));

        txtIdViatico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdViaticoFocusLost(evt);
            }
        });
        pnlNueva.add(txtIdViatico, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 120, -1));
        pnlNueva.add(SpnMinutosSali, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 50, 20));

        lblMinutos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMinutos.setText("Minutos:");
        pnlNueva.add(lblMinutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));
        pnlNueva.add(SpnMinutosArri, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 50, 20));

        lblMinutos1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMinutos1.setText("Minutos:");
        pnlNueva.add(lblMinutos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, -1, -1));

        tabs.addTab("Nueva liquidación", pnlNueva);

        add(tabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 562));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       
        String name = txtNombreViati.getText() + "-"+txtIdViatico.getText();
        String montoTxt = txtMonto.getText().trim().replace(",", ".");
        String error = misMetodos.validarLinea(name, montoTxt);
        
        int horaSalida = spnHoraSal.getValue();
        int minutosSalida = SpnMinutosSali.getValue();
        
        int horaLlegada = SpnLlegada.getValue();
        int minutosLlegada = SpnMinutosArri.getValue();
        
        //concatenar + int-->String
        String horaSalidaTxt = String.format("%02d:%02d", horaSalida, minutosSalida);
        String horaLlegadaTxt = String.format("%02d:%02d", horaLlegada, minutosLlegada);
        
        int estadoValidacion = misMetodos.validarAlimentacion(horaSalidaTxt,horaLlegadaTxt,txtNombreViati.getText());
        
        

        if (estadoValidacion != 0) {
            // Dependiendo del número que retornó, lanzamos el aviso exacto de una sola vez
            switch (estadoValidacion) {
                case 1:
                    aviso("El viático de Desayuno no cumple con la condición de horario.");
                    break;
                case 2:
                    aviso("El viático de Almuerzo no cumple con la condición de horario.");
                    break;
                case 3:
                    aviso("El viático de Cena no cumple con la condición de horario.");
                    break;
                case 4:
                    aviso("La hora de salida no puede ser mayor o igual a la de llegada.");
                    break;
            }
            return; // Detiene el proceso de guardado
        }

        if (error != null) {
            aviso(error);
            return;
        }
        
        ObjDetalleViatico miDetalle = new ObjDetalleViatico(name,Double.parseDouble(montoTxt));
        lineasTemp.add(miDetalle);
        
        refrescarLineas();
        limpiarLinea();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        int fila = tblLineas.getSelectedRow();
        if (fila == -1) { //--Nada seleccionado
            aviso("Seleccione la línea que desea quitar");
            return;
        }
        lineasTemp.remove(fila);
        refrescarLineas();
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String error = misMetodos.validarCabecera(
                txtIdentificacion.getText(), dchInicial.getDate(), dchFinal.getDate(),
                txtJustificacion.getText());
        if (error != null) {
            aviso(error);
            return;
        }
        if (lineasTemp.isEmpty()) {
            aviso("Debe agregar al menos una línea");
            return;
        }

        int consecutivo = 0;
        
        
        
        if(!modificar){
            consecutivo= almacen.siguienteConsecutivo();
            
        }else{
            String textoNum = txtNumero.getText().trim();
            String soloNumeros = textoNum.replaceAll("[^0-9]", ""); 
            
            consecutivo = Integer.parseInt(soloNumeros);
            
        }
        int horaSalida = spnHoraSal.getValue();
        int minutosSalida = SpnMinutosSali.getValue();
        
        int horaLlegada = SpnLlegada.getValue();
        int minutosLlegada = SpnMinutosArri.getValue();
        
        //concatenar + int-->String
        String horaSalidaTxt = String.format("%02d:%02d", horaSalida, minutosSalida);
        String horaLlegadaTxt = String.format("%02d:%02d", horaLlegada, minutosLlegada);
        
        ObjLiquidacion liq = new ObjLiquidacion(consecutivo,
                txtIdentificacion.getText(), dchInicial.getDate(), dchFinal.getDate(),
                txtJustificacion.getText(),horaSalidaTxt,horaLlegadaTxt);
        
        int indice = metodosLiqui.buscarLiquidacion(consecutivo);
        
        for (int i = 0; i < lineasTemp.size(); i++) {
            ObjDetalleViatico l = lineasTemp.get(i);
            
            liq.agregarLinea(l);
        }
        
        if(!modificar){
            almacen.agregar(liq);
            
            movimiento = "Agrego";
        }else{
            almacen.editarLiquidacion(indice, liq);
            
            movimiento= "Modifico";
            modificar = false;
        }

        int idBitacora = metodosBita.siguienteBitacora();
        
        ObjBitacora miBitacora = new ObjBitacora(idBitacora, nombreUser, seccion, movimiento);
        almacenBitacora.agregarBitacora(miBitacora);
        
        refrescarLiquidaciones();
        JOptionPane.showMessageDialog(null, "Se guardó " + liq.getNumero());
        nuevaLiquidacion(); //--Lista para la siguiente

       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtIdViaticoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdViaticoFocusLost
        // TODO add your handling code here:
        int id;
        
        
        try {
            id = Integer.parseInt(txtIdViatico.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor Digite el id del viatico");
            txtIdViatico.requestFocus();
            return;
        }
        ObjViatico viatico = metodosViaticos.buscarviaticoObj(id);
        
        if(viatico != null){
            if(viatico.getEstado()==1){
                aviso("Este viatico esta inactivo");
                txtIdViatico.setText("");
            }else{
                txtNombreViati.setText(viatico.getNombre());
            }
        }else{
            aviso("Este viatico no esta registrado");
        }
        
        
    }//GEN-LAST:event_txtIdViaticoFocusLost

    private void txtIdentificacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdentificacionFocusLost
        // TODO add your handling code here:
        String cedula = txtIdentificacion.getText();
        ObjEmpleado miEmpleado = metodosEmplea.buscarCedulaObj(cedula);
        
        if(miEmpleado != null){
            
            if(miEmpleado.getEstado() == 0){
                aviso("Este Empleado esta inactivo");
                
                txtIdentificacion.setText("");
            }else{
                txtNombreE.setText(miEmpleado.getNombre() + " " + miEmpleado.getApellido1());
            }
        }else{
            aviso("Este Empleado no esta registrado");
        }
    }//GEN-LAST:event_txtIdentificacionFocusLost

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int fila = tblLiquidaciones.getSelectedRow();
        
        if(fila !=-1){
            almacen.quitarLiquidacion(fila);
            refrescarLiquidaciones();
            
            movimiento = "Elimino";
        }else{
            aviso("Seleccione una fila para poder eliminar");
        }
        
         int idBitacora = metodosBita.siguienteBitacora();
        
        ObjBitacora miBitacora = new ObjBitacora(idBitacora, nombreUser, seccion, movimiento);
        almacenBitacora.agregarBitacora(miBitacora);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int fila = tblLiquidaciones.getSelectedRow();
        
        if(fila != -1){
            
            
            ArrayList<ObjLiquidacion> lista = almacen.listar();
            ObjLiquidacion liq = lista.get(fila);
            
            
            txtNumero.setText(liq.getNumero());
            txtIdentificacion.setText(liq.getIdentificacion());
            dchInicial.setDate(liq.getFechaInicial());
            dchFinal.setDate(liq.getFechaFinal());
            txtJustificacion.setText(liq.getJustificacion());

            
            lineasTemp.clear();
            lineasTemp.addAll(liq.getDetalle());
            refrescarLineas(); 

            modificar = true;
            tabs.setSelectedIndex(1);

        }else{
            aviso("Seleccione una fila para poder modificar");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.components.JSpinField SpnLlegada;
    private com.toedter.components.JSpinField SpnMinutosArri;
    private com.toedter.components.JSpinField SpnMinutosSali;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnQuitar;
    private com.toedter.calendar.JDateChooser dchFinal;
    private com.toedter.calendar.JDateChooser dchInicial;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDetalle;
    private javax.swing.JLabel lblFinal;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblHora2;
    private javax.swing.JLabel lblIdent;
    private javax.swing.JLabel lblInicial;
    private javax.swing.JLabel lblJust;
    private javax.swing.JLabel lblLista;
    private javax.swing.JLabel lblMinutos;
    private javax.swing.JLabel lblMinutos1;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalTxt;
    private javax.swing.JPanel pnlConsulta;
    private javax.swing.JPanel pnlNueva;
    private com.toedter.components.JSpinField spnHoraSal;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblDetalleConsulta;
    private javax.swing.JTable tblLineas;
    private javax.swing.JTable tblLiquidaciones;
    private javax.swing.JTextField txtIdViatico;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtJustificacion;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNombreE;
    private javax.swing.JTextField txtNombreViati;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
