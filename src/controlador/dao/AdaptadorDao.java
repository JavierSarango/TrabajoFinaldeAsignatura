/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.ListaEnlazadaServices;
import controlador.utiles.Utilidades;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Nathaly
 */
public class AdaptadorDao<T> implements InterfazDao<T> {

    private Class<T> clazz;
    private  String URL = "datos" + File.separatorChar;

    public AdaptadorDao(Class<T> clazz) {
        this.clazz = clazz;
        URL += this.clazz.getSimpleName() + ".xml";
    }

    @Override
    public void guardar(T dato) throws Exception {
        ListaEnlazada<T> lista = listar().getLista();
        if(lista.getSize() != 0) {
            lista.insertar(dato, lista.getSize() - 1);
        } else {
            lista.insertar(dato, 0);
        }
        
        FileOutputStream file = new FileOutputStream(URL);
        JAXBContext jAXBContext = JAXBContext.newInstance(new Class[]{ListaEnlazada.class, this.clazz});
        Marshaller marshaller = jAXBContext.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(lista, file);
    }

    @Override
    public void modificar(T dato, Integer pos) throws Exception {
        ListaEnlazada<T> lista = listar().getLista();
        lista.modificarDato(pos, dato);
        FileOutputStream file = new FileOutputStream(URL);
        JAXBContext jAXBContext = JAXBContext.newInstance(new Class[]{ListaEnlazada.class, this.clazz});
        Marshaller marshaller = jAXBContext.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(lista, file);
    }

    @Override
    public ListaEnlazadaServices<T> listar() {
        ListaEnlazada<T> lista = new ListaEnlazada<>();
        try {
            //DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();//valido para jdk 1.8
            DocumentBuilder db = dbf.newDocumentBuilder();
           // FileInputStream xmlFile = new FileInputStream(URL);   
            
                    
            //ByteArrayInputStream bis = new ByteArrayInputStream(xmlFile.readAllBytes());
            //Document doc = db.parse(bis);
            Document doc = db.parse(new File(URL));//valido para jdk 1.8
            NodeList datos = doc.getElementsByTagName(this.clazz.getSimpleName().toLowerCase());
            for (int i = 0; i < datos.getLength(); i++) {
                Node n1 = datos.item(i);

                NodeList aux = n1.getChildNodes();
                T objeto = this.clazz.newInstance();
                
                for (int j = 0; j < aux.getLength(); j++) {
                    Node dato = aux.item(j);

                    if (dato.getNodeName() != null && !dato.getNodeName().equals("")
                            && dato.getTextContent() != null && !dato.getTextContent().equals("") && !dato.getNodeName().equals("#text")) {
                        
                        objeto = (T) Utilidades.cambiarDatos(dato.getTextContent(), dato.getNodeName(), objeto);
                        
                    }

                }
                lista.insertar(objeto, lista.getSize() - 1);

            }
            lista.imprimir();
        } catch (Exception e) {
            System.out.println("NO SE PUEDE CARGAR "+e);
            //e.printStackTrace();
        }
        ListaEnlazadaServices<T> listado = new ListaEnlazadaServices<>();
        listado.setLista(lista);
        System.out.println("Hola listado");
        return listado;
    }
    
    public boolean eliminarDatos(int pos) throws Exception {
        ListaEnlazadaServices<T> aux = listar();
        try {
            for (int i = 0; i < aux.getSize(); i++) {
                if (pos == i) {
                    aux.eliminarPosicion(i);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }

}
}
