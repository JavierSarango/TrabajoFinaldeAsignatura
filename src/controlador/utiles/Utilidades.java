/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.utiles;

import controlador.utiles.enums.TipoCliente;
import controlador.utiles.enums.TipoEquipo;
import controlador.utiles.enums.TipoIdentificacion;
import controlador.utiles.enums.TipoProvincia;
import controlador.utiles.enums.TipoRol;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
//import modelo.enums.TipoBien;

/**
 *
 * @author sebastian
 */
public class Utilidades {

    public static Field getField(String name, Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        Field aux = null;
        for (int i = 0; i < fields.length; i++) {
            if (name.toString().equalsIgnoreCase(fields[i].getName())) {
                aux = fields[i];
                break;
            }
        }
        if (aux != null) {
            return aux;
        }

        fields = clazz.getSuperclass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (name.toString().equalsIgnoreCase(fields[i].getName())) {
                aux = fields[i];
                break;
            }

        }

        return aux;
    }

    public static Method getMethod(String name, Class clazz) {

        Method[] methods = clazz.getDeclaredMethods();
        Method aux = null;

        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
            if (name.toString().equalsIgnoreCase(methods[i].getName())) {
                aux = methods[i];
                break;
            }

        }
        if (aux != null) {
            return aux;
        }
        methods = clazz.getSuperclass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
            if (name.toString().equalsIgnoreCase(methods[i].getName())) {
                aux = methods[i];
                break;
            }

        }
        return aux;
    }

    public static Object cambiarDatos(Object dato, String field, Object a) throws Exception {

        Field fieldA = getField(field, a.getClass());
        char[] arr = field.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        Method method = getMethod("set" + new String(arr), a.getClass());
        try {
            if (fieldA.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
                method.invoke(a, transformarDatoNumber(fieldA.getType(), dato.toString()));
            } else if (fieldA.getType().isEnum()) {
                //LIBRO   //LIBROS
                Enum enume = Enum.valueOf((Class) fieldA.getType(), dato.toString());
                method.invoke(a, enume);
            } else if (fieldA.getType().getSimpleName().equalsIgnoreCase("Boolean")) {

                method.invoke(a, dato.toString().equalsIgnoreCase("true"));
            } else {
                method.invoke(a, dato);//solo para string
            }

        } catch (Exception e) {
            System.out.println(e + "  " + field);
        }
        return a;
        //System.out.println("set"+new String(arr));
    }

    public static Number transformarDatoNumber(Class type, String dato) {
        Number number = null;
        if (type.getSimpleName().equalsIgnoreCase(Integer.class.getSimpleName())) {
            number = Integer.parseInt(dato);
        }
        if (type.getSimpleName().equalsIgnoreCase(Double.class.getSimpleName())) {
            number = Double.parseDouble(dato);
        }
        if (type.getSimpleName().equalsIgnoreCase(Float.class.getSimpleName())) {
            number = Float.parseFloat(dato);
        }
        if (type.getSimpleName().equalsIgnoreCase(Short.class.getSimpleName())) {
            number = Short.parseShort(dato);
        }
        return number;
    }

    public static Boolean isNumber(Class clase) {
        return clase.getSuperclass().getSimpleName().equalsIgnoreCase("Number");
    }

    public static Boolean isString(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("String");
    }

    public static Boolean isCharacter(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Character");
    }

    public static Boolean isBoolean(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Boolean");
    }

    public static Boolean isPrimitivo(Class clase) {
        return clase.isPrimitive();
    }

    public static Boolean isObject(Class clase) {
        return (!isPrimitivo(clase) && !isBoolean(clase) && !isCharacter(clase) && !isString(clase) && !isNumber(clase));
    }

    public static String capitalizar(String field) {
        char[] arr = field.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);//apellido ---> Apellido
        return new String(arr);
    }

    public static String[] tiposI() {
        String[] aux = new String[TipoIdentificacion.values().length];
        int cont = 0;
        for (TipoIdentificacion tipobien : TipoIdentificacion.values()) {
            aux[cont] = tipobien.toString();
            cont++;
        }
        return aux;
    }

    public static String[] tiposR() {
        String[] aux = new String[TipoRol.values().length];
        int cont = 0;
        for (TipoRol tipobien : TipoRol.values()) {
            aux[cont] = tipobien.toString();
            cont++;
        }
        return aux;
    }
    
    public static String[] tiposC() {
        String[] aux = new String[TipoCliente.values().length];
        int cont = 0;
        for (TipoCliente tipobien : TipoCliente.values()) {
            aux[cont] = tipobien.toString();
            cont++;
        }
        return aux;
    }
     public static String[] tiposE() {
        String[] aux = new String[TipoEquipo.values().length];
        int cont = 0;
        for (TipoEquipo tipobien : TipoEquipo.values()) {
            aux[cont] = tipobien.toString();
            cont++;
        }
        return aux;
    }
    
     public static String[] tiposP() {
        String[] aux = new String[TipoProvincia.values().length];
        int cont = 0;
        for (TipoProvincia tipobien : TipoProvincia.values()) {
            aux[cont] = tipobien.toString();
            cont++;
        }
        return aux;
    }

}
