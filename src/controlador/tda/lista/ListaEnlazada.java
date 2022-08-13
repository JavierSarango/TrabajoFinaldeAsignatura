/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.tda.lista;

import controlador.tda.lista.exception.PosicionException;
import controlador.utiles.enums.TipoOrdenacion;
import controlador.utiles.Utilidades;
import static controlador.utiles.Utilidades.getMethod;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
//import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jona
 */
//@XmlRootElement
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;

    private Integer size;
    private Class clazz;

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    /**
     * Constructor de la clase se inicializa la lista en null y el tamanio en 0
     */
    public ListaEnlazada() {
        cabecera = null;
        size = 0;
    }

    /**
     * Permite ver si la lista esta vacia
     *
     * @return Boolean true si esta vacia, false si esta llena
     */
    public Boolean estaVacia() {
        return cabecera == null;
    }

    public void insertar(E dato) {
        NodoLista<E> nuevo = new NodoLista<>(dato, null);
        if (estaVacia()) {
            cabecera = nuevo;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        size++;
    }

    public void insertarCabecera(E dato) {
        if (estaVacia()) {
            insertar(dato);
        } else {
            NodoLista<E> nuevo = new NodoLista<>(dato, null);

            nuevo.setSiguiente(cabecera);
            cabecera = nuevo;
            size++;
        }
    }

    public void insertar(E dato, Integer pos) throws PosicionException {
        //lista size = 1
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            NodoLista<E> nuevo = new NodoLista<>(dato, null);
            if (pos == (size - 1)) {
                insertar(dato);

            } else {

                NodoLista<E> aux = cabecera;
                for (int i = 0; i < pos - 1; i++) {
                    aux = aux.getSiguiente();
                }
                NodoLista<E> siguiente = aux.getSiguiente();
                aux.setSiguiente(nuevo);
                nuevo.setSiguiente(siguiente);
                size++;
            }

        } else {
            throw new PosicionException("Error en insertar: No existe la posicion dada");
        }
    }

    public void imprimir() {
        System.out.println("**************************");
        NodoLista<E> aux = cabecera;
        for (int i = 0; i < getSize(); i++) {
            System.out.print(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();
        }
        System.out.println("\n" + "**************************");
    }

    public Integer getSize() {
        return size;
    }

    /**
     * Metodo que permite obtener un dato segun la posicion
     *
     * @param pos posicion en la lista
     * @return Elemento
     */
    public E obtenerDato(Integer pos) throws PosicionException {
        if (!estaVacia()) {
            if (pos >= 0 && pos < size) {
                E dato = null;
                if (pos == 0) {
                    dato = cabecera.getDato();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }

                return dato;
            } else {
                throw new PosicionException("Error en obtener dato: No existe la posicion dada");
            }

        } else {
            throw new PosicionException("Error en obtener dato: La lista esta vacia, por endde no hay esa posicion");
        }
    }

    public E eliminarDato(Integer pos) throws PosicionException {
        E auxDato = null;
        if (!estaVacia()) {
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    auxDato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    size--;
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos - 1; i++) {
                        aux = aux.getSiguiente();
                    }
                    auxDato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    size--;
                }
                return auxDato;
            } else {
                throw new PosicionException("Error en eliminar dato: No existe la posicion dada");
            }

        } else {
            throw new PosicionException("Error en eliminar dato: La lista esta vacia, por ende no hay esa posicion");
        }
    }

    private Field getField(String nombre) {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getName().equalsIgnoreCase(nombre)) {
                field.setAccessible(true);
                return field;
            }
        }
        return null;
    }

    private Object value(E dato, String atributo) throws Exception {
        return getField(atributo).get(dato);
    }

    public E busqBinariaRecurListaPOS(String search, String atributo, int izq, int der) {
        if (izq > der) {
            return null;
        }
        int compResult;
        int iMed = (int) Math.floor((izq + der) / 2);
        try {

            Object datoMed = value(consultarDatoPosicion(iMed), atributo);
            if (datoMed instanceof Number) {
                Number aux = (Number) datoMed;
                Number auxSearch = (Number) Double.parseDouble(search);
                if (auxSearch.doubleValue() == aux.doubleValue()) {
                    return consultarDatoPosicion(iMed);
                }
                if (auxSearch.doubleValue() < aux.doubleValue()) {
                    der = iMed - 1;
                    return busqBinariaRecurListaPOS(search, atributo, izq, der);
                } else {
                    izq = iMed + 1;
                    return busqBinariaRecurListaPOS(search, atributo, izq, der);
                }
            } else {
                compResult = search.compareTo(datoMed.toString());
                if (compResult == 0) {
                    return consultarDatoPosicion(iMed);
                }
                if (compResult < 0) {
                    der = iMed - 1;
                    return busqBinariaRecurListaPOS(search, atributo, izq, der);
                } else {
                    izq = iMed + 1;
                    return busqBinariaRecurListaPOS(search, atributo, izq, der);
                }
            }
        } catch (Exception e) {
        }
        return consultarDatoPosicion(iMed);
    }

    public int tamanio() {
        int cont = 0;
        NodoLista tmp = cabecera;
        while (!estaVacia() && tmp != null) {
            cont++;
            tmp = tmp.getSiguiente();
        }
        return cont;
    }

    public E consultarDatoPosicion(int pos) {
        E dato = null;
        if (!estaVacia() && (pos >= 0 && pos <= tamanio() - 1)) {
            NodoLista tmp = cabecera;
            for (int i = 0; i < pos; i++) {
                tmp = tmp.getSiguiente();
                if (tmp == null) {
                    break;
                }
            }
            if (tmp != null) {
                dato = (E) tmp.getDato();
            }
        }
        return dato;
    }

    public void vaciar() {
        cabecera = null;
        size = 0;
        //en c utilizamos el free
        //malloc
    }

    public void modificarDato(Integer pos, E datoM) throws PosicionException {
        if (!estaVacia()) {
            if (pos >= 0 && pos < size) {
                // E dato = null;
                if (pos == 0) {
                    cabecera.setDato(datoM);
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    aux.setDato(datoM);
                }

            } else {
                throw new PosicionException("Error en obtener dato: No existe la posicion dada");
            }

        } else {
            throw new PosicionException("Error en obtener dato: La lista esta vacia, por endde no hay esa posicion");
        }
    }

//     public ListaEnlazada<E> quisortLista(String atributo, int primero, int ultimo, TipoOrdenacion tipoOrdenacion) throws Exception {
//          Integer i, j, central;
//          Class<E> clazz = null;
//          E[] matriz = null;
//          central = (primero + ultimo) / 2;
//          i = primero;
//          j = ultimo;
//          if (size > 0) {
//               clazz = (Class<E>) getCabecera().getDato().getClass();//primitivo, Dato envolvente, Object
//               Field field = Utilidades.getField(atributo, clazz);
//               Method method = getMethod("get" + Utilidades.capitalizar(atributo), obtenerDato(i).getClass());
//               Method method1 = getMethod("get" + Utilidades.capitalizar(atributo), obtenerDato(j).getClass());
////               System.out.println(method);
////               System.out.println(method1);
//               try {
//                    matriz = toArray();
////                    Boolean isObject = Utilidades.isObject(clazz);//si es objeto
//                    if (field.getType().getSimpleName().toString().equalsIgnoreCase("Number")) {
//                         do {
//                              if (tipoOrdenacion.toString().equals(TipoOrdenacion.ASCENDENTE)) {
//                                   while (((Number) evaluarCampoDato(obtenerDato(i), atributo, clazz)).doubleValue() < ((Number) evaluarCampoDato(obtenerDato(central), atributo, clazz)).doubleValue()) {
////                                   while (((Number) evaluaCambiarDato(clazz, t, t, method, method1, tipoOrdenacion, j, matriz) < ((Number) matriz[central].doubleValue())) {
//                                        i++;
//                                   }
//                                   while (((Number) evaluarCampoDato(obtenerDato(j), atributo, clazz)).doubleValue() > ((Number) evaluarCampoDato(obtenerDato(central), atributo, clazz)).doubleValue()) {
//                                        j--;
//                                   }
//                              } else {
//                                   while (((Number) evaluarCampoDato(obtenerDato(i), atributo, clazz)).doubleValue() > ((Number) evaluarCampoDato(obtenerDato(central), atributo, clazz)).doubleValue()) {
//                                        i++;
//                                   }
//                                   while (((Number) evaluarCampoDato(obtenerDato(j), atributo, clazz)).doubleValue() < ((Number) evaluarCampoDato(obtenerDato(central), atributo, clazz)).doubleValue()) {
//                                        j--;
//                                   }
//                              }
//
//                              if (i <= j) {
//                                   E aux = obtenerDato(i);
//                                   modificarDato(i, obtenerDato(j));
//                                   modificarDato(j, (E) aux);
//                                   i++;
//                                   j--;
//                              }
//                         } while (i <= j);
//
//                    } else {
//                         do {
//                              if (tipoOrdenacion.toString().equals(TipoOrdenacion.ASCENDENTE)) {
////                                 
//                                   while (evaluarCampoDato(matriz[central], atributo, clazz).toString().
//                                           compareTo(evaluarCampoDato(matriz[i], atributo, clazz).toString()) > 0 && i < j) {
//                                        i++;
//                                   }
////                            
//                                   while (evaluarCampoDato(matriz[j], atributo, clazz).toString().
//                                           compareTo(evaluarCampoDato(matriz[central], atributo, clazz).toString()) > 0) {
//                                        System.out.println("pasa por aqui nose 4");
//                                        j--;
//                                   }
//                              } else {
////                                
//                                   while (evaluarCampoDato(matriz[central], atributo, clazz).toString().
//                                           compareTo(evaluarCampoDato(matriz[i], atributo, clazz).toString()) > 0 && i < j) {
//                                        System.out.println("pasa por aqui nose 5");
////                                      System.out.print(Value(obtenerDato(central), atributo).toString().compareTo(Value(obtenerDato(i), atributo).toString()) + "               ");
//                                        System.out.println("");
//                                        i++;
//                                   }
////                               
//                                   while (evaluarCampoDato(matriz[j], atributo, clazz).toString().
//                                           compareTo(evaluarCampoDato(matriz[central], atributo, clazz).toString()) > 0) {
////                                      while (matriz[j].toString().compareTo(matriz[central].toString()) > 0) {
//                                        System.out.println("pasa por aqui nose 6");
//                                        System.out.println("");
//                                        j--;
//                                   }
//                              }
//                              if (i <= j) { //borre el igual
//                                   Object aux = matriz[j];
//                                   matriz[i] = matriz[j - 1];
//                                   matriz[j] = (E) aux;
//                                   i++; //i
//                                   j--;
//                              }
//                         } while (i <= j);
//                    }
//                    if (primero < j) {
//                         quisortLista(atributo, primero, j, tipoOrdenacion);
//                    }
//                    if (i < ultimo) {
//                         quisortLista(atributo, i, ultimo, tipoOrdenacion);
//                    }
//
//               } catch (Exception e) {
//                    e.printStackTrace();
//               }
//
//          }
//          if (matriz != null) {
//               toList(matriz);
//          }
//          return this;
//     }
    public E[] toArray() {
        E[] matriz = (E[]) (new Object[this.size]);
        NodoLista<E> aux = cabecera;
        for (int i = 0; i < this.size; i++) {
            matriz[i] = aux.getDato();
            //System.out.print(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();
        }
        return matriz;
    }

    public ListaEnlazada<E> shellListaEnlazada(String atributo, TipoOrdenacion tipoOrdenacion) throws Exception {
        Class<E> clazz = null;
        E[] matriz = null;
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            matriz = toArray();
            int a, salto;
            boolean cambiar;
            for (salto = matriz.length / 2; salto != 0; salto /= 2) {
                cambiar = true;
                while (cambiar) {
                    cambiar = false;
                    for (a = salto; a < matriz.length; a++) {
                        if (isObject) {
                            Field field = Utilidades.getField(atributo, clazz);
                            Method method = getMethod("get" + Utilidades.capitalizar(atributo), matriz[a - salto].getClass());
                            Method method1 = getMethod("get" + Utilidades.capitalizar(atributo), matriz[a].getClass());
                            Object[] aux = evaluaCambiarDato(field.getType(), matriz[a - salto], matriz[a], method, method1, tipoOrdenacion, a - salto);
                            if (aux[0] != null) {
                                E temp = matriz[a];
                                matriz[a] = matriz[a - salto];
                                matriz[a - salto] = temp;
                                cambiar = true;
                            }
                        } else {
                            Object[] aux = evaluaCambiarDatoNoObjeto(clazz, matriz[a - salto], matriz[a], tipoOrdenacion, a - salto);
                            if (aux[0] != null) {
                                E temp = matriz[a];
                                matriz[a] = matriz[a - salto];
                                matriz[a - salto] = temp;
                                cambiar = true;
                            }

                        }
                    }
                }
            }

        }
        toList(matriz);

        return this;

    }

    private Object[] evaluaCambiarDato(Class clazz, E auxJ, E auxJ1, Method method, Method method1, TipoOrdenacion tipoOrdenacion, int j) throws Exception {
        Object aux[] = new Object[2];
        if (clazz.getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
            Number datoJ = (Number) method.invoke(auxJ);
            Number datoJ1 = (Number) method1.invoke(auxJ1);
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if ((datoJ.doubleValue() > datoJ1.doubleValue())) {
                    // cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            } else {
                if ((datoJ.doubleValue() < datoJ1.doubleValue())) {
                    //    cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            }
        } else if (Utilidades.isString(clazz)) {
            String datoJ = (String) method.invoke(auxJ);
            String datoJ1 = (String) method1.invoke(auxJ1);
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if ((datoJ.toLowerCase().compareTo(datoJ1.toLowerCase()) > 0)) {
                    //   cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            } else {
                if ((datoJ.toLowerCase().compareTo(datoJ1.toLowerCase()) < 0)) {
                    //  cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            }

        } else if (Utilidades.isCharacter(clazz)) {
            Character datoJ = (Character) method.invoke(auxJ);
            Character datoJ1 = (Character) method1.invoke(auxJ1);
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if (datoJ > datoJ1) {
                    // cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            } else {
                if (datoJ < datoJ1) {
                    //  cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
//                         aux[1] = j;
                }
            }

        }
        return aux;
    }

    private Object[] evaluaCambiarDatoNoObjeto(Class clazz, E auxJ, E auxJ1, TipoOrdenacion tipoOrdenacion, int j) throws Exception {
        Object aux[] = new Object[2];//aux[0];--->null
        if (clazz.getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
            // Number datoJ = (Number) auxJ;
            // Number datoJ1 = (Number) auxJ1;
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if ((((Number) auxJ).doubleValue() > ((Number) auxJ1).doubleValue())) {
                    aux[0] = auxJ1;
                    aux[1] = j;
                    //  cambioBurbuja(j, matriz);
                }
            } else {
                if ((((Number) auxJ).doubleValue() < ((Number) auxJ1).doubleValue())) {
                    // cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            }
        } else if (Utilidades.isString(clazz)) {
            String datoJ = (String) auxJ;
            String datoJ1 = (String) auxJ1;
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if ((datoJ.toLowerCase().compareTo(datoJ1.toLowerCase()) > 0)) {
                    //cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            } else {
                if ((datoJ.toLowerCase().compareTo(datoJ1.toLowerCase()) < 0)) {
                    //cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            }

        } else if (Utilidades.isCharacter(clazz)) {
            Character datoJ = (Character) auxJ;
            Character datoJ1 = (Character) auxJ1;
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if (datoJ > datoJ1) {
                    //cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            } else {
                if (datoJ < datoJ1) {
                    //cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            }

        }
        return aux;
    }

    public ListaEnlazada<E> toList(E[] matriz) {
        //E[] matriz = (E[]) (new Object[this.size]);
        this.vaciar();
        for (int i = 0; i < matriz.length; i++) {
            this.insertar(matriz[i]);
        }
        return this;
    }

//    public static void main(String[] args) {
//        ListaEnlazada<Double> lista = new ListaEnlazada<>();
//        lista.insertar(67.3);
//        lista.insertar(6.6);
//        lista.insertar(16.0);
//        try {
//            lista.insertar(90.0, 2);
//            System.out.println("La ongitud de la lista es " + lista.getSize());
//            lista.imprimir();
//            System.out.println("El elemento de la lista en la pisicion 1 es: " + lista.obtenerDato(3));
//            lista.eliminarDato(lista.getSize() - 1);
//            System.out.println("La ongitud de la lista es " + lista.getSize());
//            lista.modificarDato(1, 13.0);
//            lista.imprimir();
//            lista.vaciar();
//            System.out.println("La ongitud de la lista es " + lista.getSize());
//            lista.imprimir();
//            
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//    }
    public ListaEnlazada<E> buscarDatoPosicionObjetoBinaria(String atributo, Object dato) throws Exception {
        Class<E> clazz = null;
        E[] matriz = null;
        ListaEnlazada<E> resultado = new ListaEnlazada<>();
        E aux = null;
        if (size > 0) {
            matriz = toArray();
            clazz = (Class<E>) cabecera.getDato().getClass();//primitivo, Dato envolvente, Object
            Boolean isObject = Utilidades.isObject(clazz);//si es objeto
            if (isObject) {
                Field field = Utilidades.getField(atributo, clazz);
                for (int i = 0; i < matriz.length; i++) {
                    Method method1 = getMethod("get" + Utilidades.capitalizar(atributo), matriz[i].getClass());
                    if (field.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")
                            && dato.getClass().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
                        int inicio = 0;
                        int fin = matriz.length - 1;
                        int medio;
                        Number datoJ = (Number) dato;
                        Number datoJ1 = (Number) method1.invoke(matriz[i]);
                        while (inicio <= fin) {
                            medio = (inicio + fin) / 2;
                            if (datoJ.doubleValue() == datoJ1.doubleValue()) {
                                aux = (E) matriz[i];
                                if (aux != null) {
                                    resultado.insertar(aux);
                                }
                                break;
                            } else {
                                if (datoJ1.doubleValue() < datoJ.doubleValue()) {
                                    inicio = medio + 1;
                                } else {
                                    fin = medio - 1;
                                }
                            }
                        }
                    } else if (Utilidades.isString(field.getType()) && Utilidades.isString(dato.getClass())) {
                        String datoJ = (String) dato;
                        String datoJ1 = (String) method1.invoke(matriz[i]);
                        int inicio = 0;
                        int fin = matriz.length - 1;
                        int medio = 0;
                        while (inicio <= fin) {
                            medio = (inicio + fin) / 2;
                            if (datoJ1.toLowerCase().startsWith(datoJ.toLowerCase())
                                    || datoJ1.toLowerCase().endsWith(datoJ.toLowerCase())
                                    || datoJ1.toLowerCase().equalsIgnoreCase(datoJ.toLowerCase())) {
                                aux = (E) matriz[i];
                                if (aux != null) {
                                    resultado.insertar(aux);
                                }
                                break;
                            } else {
                                if (datoJ1.toLowerCase().equalsIgnoreCase(datoJ.toLowerCase())) {
                                    inicio = medio + 1;
                                } else {
                                    fin = medio - 1;
                                }
                            }

                        }

                    } else if (Utilidades.isCharacter(field.getType()) && Utilidades.isCharacter(dato.getClass())) {
                        Character datoJ = (Character) dato;
                        Character datoJ1 = (Character) method1.invoke(matriz[i]);
                        int inicio = 0;
                        int fin = matriz.length - 1;
                        int medio = 0;
                        while (inicio <= fin) {
                            medio = (inicio + fin) / 2;
                            if (datoJ.charValue() == datoJ1.charValue()) {
                                aux = (E) matriz[i];
                                if (aux != null) {
                                    resultado.insertar(aux);
                                }
                                break;
                            } else {
                                if (datoJ1.charValue() < datoJ.charValue()) {
                                    inicio = medio + 1;
                                } else {
                                    fin = medio - 1;
                                }

                            }

                        }

                    }

                }

            }
        }

        return resultado;
    }

    public ListaEnlazada<E> BusquedaBinariaClase(Object elemento, String atributo) {
        try {
            ListaEnlazada auxiliar = new ListaEnlazada();
            int centro, primero, ultimo;
            primero = 0;
            ultimo = getSize() - 1;
            while (primero <= ultimo) {
                if (obtenerDato(0) instanceof Number) {
                    centro = (primero + ultimo) / 2;
                    if (((Number) evaluarDato((E) elemento, atributo)).intValue() == ((Number) evaluarDato(obtenerDato(centro), atributo)).intValue()) {
                        E po = obtenerDato(centro);
                        auxiliar.insertar(po);
                        return auxiliar;
                    } else if (((Number) evaluarDato((E) elemento, atributo)).intValue() < ((Number) evaluarDato(obtenerDato(centro), atributo)).intValue()) {
                        ultimo = centro - 1;
                    } else {
                        primero = centro + 1;
                    }
                } else {
                    centro = (primero + ultimo) / 2;
                    if (evaluarDato(obtenerDato(centro), atributo).toString().toLowerCase().contains(elemento.toString().toLowerCase())) {
                        auxiliar.insertar(obtenerDato(centro));
                        return auxiliar;
                    } else if (evaluarDato(obtenerDato(centro), atributo).toString().toLowerCase().compareTo(elemento.toString().toLowerCase()) > 0) {
                        ultimo = centro - 1;
                    } else {
                        primero = centro + 1;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Hay un error en busqueda: " + e);
        }
        return null;
    }

    private Object evaluarDato(E dato, String atributo) throws Exception {
        Class<E> clazz = (Class<E>) cabecera.getDato().getClass();
//       Class clazz= dato.getClass();
//        return getField(atributo).get(dato);
        return getField(atributo, clazz).get(dato);
    }

    private Field getField(String nombre, Class clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getName().equalsIgnoreCase(nombre)) {
                field.setAccessible(true);
                return field;
            }
        }
        return null;
    }
}
