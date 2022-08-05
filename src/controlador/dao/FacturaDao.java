/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controlador.Conexion;

import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.exception.PosicionException;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Factura;
import modelo.Producto;
import modelo.Venta;

/**
 *
 * @author John
 */
public class FacturaDao implements InterfazDao<Factura> {

    /**
     * variable tipo cliente para almacenamiento de la informacion del cliente
     * obtenida de la base de datos
     */
    private Cliente cliente;

    /**
     * variable tipo factura para almacenamiento de la informacion de la factura
     * obtenida de la base de datos
     */
    private Factura factura;

    /**
     * variable tipo factura para almacenamiento de la lista de facturas
     * obtenida de la base de datos
     */
    private ListaEnlazada<Factura> listaFactura;

    /**
     * variable tipo ventas para almacenamiento de la informacion de las listas
     * obtenida de la base de datos
     */
    private ListaEnlazada<Venta> ventas;

    /**
     * variable tipo producto para almacenamiento de la informacion del producto
     * obtenida de la base de datos
     */
    private Producto producto;

    /**
     * Una lista de facturas
     */
    private ListaEnlazada<Factura> facturas = new ListaEnlazada();

    /**
     * una lista tipo T
     */
    private ListaEnlazada<Object> lista = new ListaEnlazada();

    /**
     * variable para establecer la conexion a base de datos
     */
    Conexion c = new Conexion();

    /**
     * variable para establecer la conexion a base de datos
     */
    Statement st;

    /**
     * variable para establecer la conexion a base de datos
     */
    ResultSet rs;

//    public FacturaDao() {
//        super(Factura.class);
//        listado();
//    }
    /**
     * metodo para obtener la factura almacenada en la variables factura
     *
     * @return factura
     */
    public Factura getFactura() {
        if (this.factura == null) {
            this.factura = new Factura();
        }
        return factura;
    }

    /**
     * metodo para setear datos en la variable factura
     *
     * @param factura
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    /**
     * metodo para obtener los datos de la lista tipo Factura
     *
     * @return ListaENlazada<Factura>
     */
    public ListaEnlazada<Factura> getListaFactura() {
        return listaFactura;
    }

    /**
     * metodo para setear datos en la ListaEnlazada de tipo Factura
     *
     * @param listaFactura
     */
    public void setListaFactura(ListaEnlazada<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    /**
     * Permite obtener la lista tipo factura
     *
     * @return lista factura
     */
    public ListaEnlazada<Factura> getFacturas() {
        return facturas;
    }

    /**
     * Permite ingresar los datos de la lista de facturas
     *
     * @param facturas
     */
    public void setFacturas(ListaEnlazada<Factura> facturas) {
        this.facturas = facturas;
    }

//    public Boolean guardar() {
//        try {
//            getFactura().setId(listaFactura.getSize() + 1);
//            guardar(getFactura());
//            return true;
//        } catch (Exception e) {
//            System.out.println("Error en guardar" + e);
//        }
//        return false;
//    }
//
//    public Boolean modificar(Integer pos) {
//        try {
//            modificaree(getFactura());
//            return true;
//        } catch (Exception e) {
//            System.out.println("Error en modificar" + e);
//        }
//        return false;
//    }
//
//    public ListaEnlazada<Factura> listado() {
//        setListaFactura(listar());
//        return listaFactura;
//    }
    /**
     * metodo para almacenar los datos en base de datos
     *
     * @param dato
     * @throws Exception
     */
    @Override
    public void guardar(Factura dato) throws Exception {
//        Connection con = c.conectar();
//        String sql = "INSERT INTO factura(id_factura,cliente,cedula, direccion, telefono, fecha_emision, cantidad, descripcion, precio_unitario, total) VALUE(?,?,?,?,?,?,?,?,?,?)";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String formattedDate = simpleDateFormat.format(factura.getFechaEmision());
//        java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);
//        try {
//            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
//            ps.setInt(1, factura.getId());
//            ps.setString(2, factura.getNombreCliente());
//            ps.setString(3, factura.getCedula());
//            ps.setString(4, factura.getDireccion());
//            ps.setString(5, factura.getTelefono());
//            ps.setDate(6, date1);
//            ps.setString(7, String.valueOf(factura.getCantidad()));
//            ps.setString(8, factura.getDescripcionProducto());
//            ps.setString(9, String.valueOf(factura.getPrecioUnitario()));
//            ps.setString(10, String.valueOf(factura.getTotal()));
//            ps.executeUpdate();
//            ps.close();
//            return true;
//        } catch (SQLException ex) {
//            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
    }

    /**
     * metodo para modificar los datos en base de datos
     *
     * @param dato
     * @throws Exception
     */
    @Override
    public void modificaree(Factura dato) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * metodo para eliminar los datos en base de datos
     *
     * @param dato
     * @throws Exception
     */
    @Override
    public void eliminar(Factura dato) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * metodo para obtener los datos en base de datos
     *
     * @return
     */
    @Override
    public ListaEnlazada<Factura> listar() {
//        st = null;
//        rs = null;
//        lista = new ListaEnlazada<>();
//        try {
//            Connection con = c.conectar();
//            st = (Statement) con.createStatement();
//            rs = st.executeQuery("SELECT * FROM factura");
//            while (rs.next()) {
//                Factura factura = new Factura();
//                factura.setId(rs.getInt("id_factura"));
//                factura.setNombreCliente(rs.getString("cliente"));
//                factura.setDireccionEmpresa(rs.getString("direccion"));
//                factura.setCedula(rs.getString("cedula"));
//                factura.setTelefonoE(rs.getString("telefono"));
//                factura.setFechaEmision(rs.getDate("fecha_emision"));
//                factura.setCantidad(Integer.valueOf(rs.getString("cantidad")));
//                factura.setDescripcionProducto(rs.getString("descripcion"));
//                factura.setPrecioUnitario(Double.valueOf(rs.getString("precio_unitario")));
//                factura.setTotal(Double.valueOf(rs.getString("total")));
//                lista.insertarNodo((T) factura);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return lista;
        return null;
    }

    @Override
    public Factura obtener(Integer id) throws Exception {
//        Lista<Factura> lista = new Lista();
//        Lista<Factura> aux = (Lista<Factura>) listar();
//        for (int i = 0; i < listar().tamanio(); i++) {
//            Factura f = aux.consultarDatoPosicion(i);
//            if (f.getNombreCliente().toLowerCase().contains(dato.toLowerCase())) {
//                lista.insertarNodo(f);
//            }
//        }
//        return lista;
        return null;
    }

    /**
     * Crea un pdf de la factura o proforma en una lista El achivo es guardado
     * en la carpeta del proyecto
     *
     * @param aprobada ayuda a diferenciar a las facturas de las proformas
     */
    public void imprimirDatosFactura(Boolean aprobada) throws PosicionException {
        com.itextpdf.text.Document documento = new com.itextpdf.text.Document();

        try {
            String numeroFactura = "";
            try {
                numeroFactura = String.valueOf(factura.getCodigoFactura());

                PdfWriter.getInstance(documento, new FileOutputStream(numeroFactura + ".pdf"));
            } catch (Exception e) {

                PdfWriter.getInstance(documento, new FileOutputStream("Proforma " + factura.getId() + ".pdf"));
            }

            Image header = Image.getInstance("src/imagenes/encabezado1.jpeg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Font encabezado = new Font();
            encabezado.setColor(BaseColor.BLACK);
            encabezado.setStyle(Font.BOLD);
            encabezado.setFamily(FontFamily.COURIER.toString());
            encabezado.setSize(21);
            Paragraph encabezadoP;
            if (aprobada) {
                encabezadoP = new Paragraph("\nFACTURA Nro: " + numeroFactura + "\n\n", encabezado);
                encabezadoP.setAlignment(Paragraph.ALIGN_CENTER);
            } else {
                encabezadoP = new Paragraph("\nPROFORMA \n\n", encabezado);
                encabezadoP.setAlignment(Paragraph.ALIGN_CENTER);
            }
            //
            Font datosEmp = new Font();
            datosEmp.setColor(BaseColor.BLACK);
            datosEmp.setFamily(FontFamily.COURIER.toString());
            datosEmp.setSize(11);
            datosEmp.setStyle(1);
            String datosEmpresa = "         Empresa: " + factura.getNombreEmpresa() + "\n" + "         Dirección: " + factura.getDireccionEmpresa()
                    + "\n         Correo: " + factura.getEmailE() + "\n         Celular 1: " + factura.getTelefonoE()
                    + "\n         Autoriración SRI: " + factura.getCodigoAutorizacion() + "\n\n";
            Paragraph datosEmpress = new Paragraph(datosEmpresa, datosEmp);
            datosEmpress.setAlignment(Paragraph.ALIGN_LEFT);

            //datos del comprador
            Font datosC = new Font();
            datosC.setColor(BaseColor.BLACK);
            datosC.setFamily(FontFamily.COURIER.toString());
            datosC.setSize(11);
            String datosCl = "         Cliente: " + cliente.getRazonSocial() + "\n         C.I/RUC: " + cliente.getIdentificacion()
                    + "\n" + "         Dirección: " + cliente.getDireccion() + "\n         Celular: " + cliente.getCelular()
                    + "\n         Forma de Pago: Efectivo" + "\n\n";
            Paragraph datosCliente = new Paragraph(datosCl, datosC);
            datosCliente.setAlignment(Paragraph.ALIGN_LEFT);

            Font compraF = new Font();
            compraF.setColor(BaseColor.BLACK);
            compraF.setFamily(FontFamily.COURIER.toString());
            compraF.setSize(14);
            Paragraph compra = new Paragraph("COMPRA:\n\n", compraF);
            compra.setAlignment(Paragraph.ALIGN_CENTER);

            documento.open();
            documento.add(header);
            documento.add(encabezadoP);
            documento.add(datosEmpress);
            documento.add(datosCliente);
            documento.add(compra);

            PdfPTable tabla = new PdfPTable(6);

            Font encabezadoTabla = new Font();
            encabezadoTabla.setColor(BaseColor.WHITE);
            encabezadoTabla.setFamily(FontFamily.COURIER.toString());
            encabezadoTabla.setSize(14);

            PdfPCell codigo = new PdfPCell(new Phrase("CÓDIGO", encabezadoTabla));
            codigo.setBackgroundColor(BaseColor.DARK_GRAY);
            tabla.addCell(codigo);

            PdfPCell concepto = new PdfPCell(new Phrase("CONCEPTO", encabezadoTabla));
            concepto.setBackgroundColor(BaseColor.DARK_GRAY);
            tabla.addCell(concepto);

            PdfPCell unidades = new PdfPCell(new Phrase("UNIDADES", encabezadoTabla));
            unidades.setBackgroundColor(BaseColor.DARK_GRAY);
            tabla.addCell(unidades);

            PdfPCell precio = new PdfPCell(new Phrase("VALOR UNIT.", encabezadoTabla));
            precio.setBackgroundColor(BaseColor.DARK_GRAY);
            tabla.addCell(precio);

            PdfPCell subTotal = new PdfPCell(new Phrase("COSTO NETO", encabezadoTabla));
            subTotal.setBackgroundColor(BaseColor.DARK_GRAY);
            tabla.addCell(subTotal);

            PdfPCell ivaTotal = new PdfPCell(new Phrase("COSTO IVA", encabezadoTabla));
            ivaTotal.setBackgroundColor(BaseColor.DARK_GRAY);
            tabla.addCell(ivaTotal);

            Font productos = new Font();
            productos.setColor(BaseColor.BLACK);
            productos.setFamily(FontFamily.COURIER.toString());
            productos.setSize(11);

            double SubTotal = 0;
            double IVA = 0;
            double TotalIVA = 0;
            DecimalFormat df = new DecimalFormat("#.00");
            for (int i = 0; i < ventas.getSize(); i++) {
                tabla.addCell(new PdfPCell(new Phrase(ventas.consultarDatoPosicion(i).getId_Venta() + "", productos)));
                tabla.addCell(new PdfPCell(new Phrase(producto.getDescripcion(), productos)));
                tabla.addCell(new PdfPCell(new Phrase(ventas.consultarDatoPosicion(i).getCantidad() + "", productos)));
                tabla.addCell(new PdfPCell(new Phrase(df.format(ventas.consultarDatoPosicion(i).getPrecioUnitario()), productos)));
                tabla.addCell(new PdfPCell(new Phrase(df.format(ventas.consultarDatoPosicion(i).getSubTotal() * ventas.consultarDatoPosicion(i).getTotalPagar()), productos)));
                tabla.addCell(new PdfPCell(new Phrase(df.format(ventas.consultarDatoPosicion(i).getSubTotal() * ventas.consultarDatoPosicion(i).getTotalPagar()), productos)));

            }
            documento.add(tabla);

            for (int i = 0; i < ventas.getSize(); i++) {
                SubTotal = ventas.obtenerDato(i).getPrecioUnitario() + SubTotal;
                IVA = ventas.obtenerDato(i).getIva() + IVA;
            }

            TotalIVA = SubTotal + IVA;

            df.setRoundingMode(RoundingMode.FLOOR);

            Font totalF = new Font();
            totalF.setColor(BaseColor.BLACK);
            totalF.setFamily(FontFamily.COURIER.toString());
            totalF.setSize(14);
            String totalM = "\nSubtotal: " + df.format(SubTotal) + "       \n" + "IVA (12%): " + df.format(IVA) + "       \n" + "Total: " + df.format(TotalIVA) + "       \n";
            Paragraph total = new Paragraph(totalM, totalF);

            total.setAlignment(Paragraph.ALIGN_RIGHT);

            documento.add(total);
            documento.close();
            if (aprobada) {
                JOptionPane.showMessageDialog(null, "Factura creada");
            } else {
                JOptionPane.showMessageDialog(null, "Proforma creada");
            }

        } catch (DocumentException | FileNotFoundException e) {
            System.out.println("Error en PDF " + e);
        } catch (IOException e) {
            System.out.println("Error en la imagen " + e);
        }

        try {
            File ruta = new File("C:/Documentos/ProyectoFinal_JAVA/" + String.valueOf(factura.getCodigoFactura()) + ".pdf");
            Desktop.getDesktop().open(ruta);
        } catch (Exception e) {
        }
    }

}
