/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controlador.dao.VentaDao;
import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.exception.PosicionException;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.RoundingMode;
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
public class FacturaController<T> {

    /**
     * variable tipo cliente para almacenamiento de la informacion del cliente
     * obtenida de la base de datos
     */
    private Cliente cliente;

    /**
     * variable tipo ventas para almacenamiento de la informacion de las listas
     * obtenida de la base de datos
     */
    private ListaEnlazada<Venta> ventas;

    /**
     * una lista tipo T
     */
    private ListaEnlazada<T> lista = new ListaEnlazada();

    /**
     * variable tipo factura para almacenamiento de la informacion de la factura
     * obtenida de la base de datos
     */
    private Factura factura;

    /**
     * Una lista de facturas
     */
    private ListaEnlazada<Factura> facturas = new ListaEnlazada();

    private void consultaCliente(Integer id) {
//        ClienteSoporteDao vent = new ClienteSoporteDao();
//        cliente = vent.obtener(id);
    }

    private void consultaVenta(Integer id) throws Exception {
        VentaDao vent = new VentaDao();
        ventas.insertarCabecera(vent.obtener(id));
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
            encabezado.setFamily(Font.FontFamily.COURIER.toString());
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
            datosEmp.setFamily(Font.FontFamily.COURIER.toString());
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
            datosC.setFamily(Font.FontFamily.COURIER.toString());
            datosC.setSize(11);
            String datosCl = "         Cliente: " + cliente.getRazonSocial() + "\n         C.I/RUC: " + cliente.getIdentificacion()
                    + "\n" + "         Dirección: " + cliente.getDireccion() + "\n         Celular: " + cliente.getCelular()
                    + "\n         Forma de Pago: Efectivo" + "\n\n";
            Paragraph datosCliente = new Paragraph(datosCl, datosC);
            datosCliente.setAlignment(Paragraph.ALIGN_LEFT);

            Font compraF = new Font();
            compraF.setColor(BaseColor.BLACK);
            compraF.setFamily(Font.FontFamily.COURIER.toString());
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
            encabezadoTabla.setFamily(Font.FontFamily.COURIER.toString());
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
            productos.setFamily(Font.FontFamily.COURIER.toString());
            productos.setSize(11);

            double SubTotal = 0;
            double IVA = 0;
            double TotalIVA = 0;
            DecimalFormat df = new DecimalFormat("#.00");
            for (int i = 0; i < ventas.getSize(); i++) {
                tabla.addCell(new PdfPCell(new Phrase(ventas.consultarDatoPosicion(i).getId_Venta() + "", productos)));
//                tabla.addCell(new PdfPCell(new Phrase(producto.getDescripcion(), productos)));
//                tabla.addCell(new PdfPCell(new Phrase(ventas.consultarDatoPosicion(i).getNroVentas() + "", productos)));
//                tabla.addCell(new PdfPCell(new Phrase(df.format(ventas.consultarDatoPosicion(i).getMonto()), productos)));
//                tabla.addCell(new PdfPCell(new Phrase(df.format(ventas.consultarDatoPosicion(i).getSubTotal() * ventas.consultarDatoPosicion(i).getTotalPagar()), productos)));
//                tabla.addCell(new PdfPCell(new Phrase(df.format(ventas.consultarDatoPosicion(i).getSubTotal() * ventas.consultarDatoPosicion(i).getTotalPagar()), productos)));

            }
            documento.add(tabla);

            for (int i = 0; i < ventas.getSize(); i++) {
//                SubTotal = ventas.obtenerDato(i).getPrecioUnitario() + SubTotal;
//                IVA = ventas.obtenerDato(i).getIva() + IVA;
            }

            TotalIVA = SubTotal + IVA;

            df.setRoundingMode(RoundingMode.FLOOR);

            Font totalF = new Font();
            totalF.setColor(BaseColor.BLACK);
            totalF.setFamily(Font.FontFamily.COURIER.toString());
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
