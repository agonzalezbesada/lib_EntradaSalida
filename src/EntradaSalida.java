import javax.swing.*;
import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Libreria para sacar por dispositivos un mensaje y
 * pedir por consola distintos tipos de datos
 * @version 0.1
 * @author Damian Nogueiras
 */
public class EntradaSalida {
    /**
     * opción de uso de la consola para imprimir un mensaje
     */
    public static final int SALIDA_CONSOLA = 1;
    /**
     * opción de uso de utilizar una ventana en el escritorio para sacar un mensaje
     */
    public static final int SALIDA_WINDOW = 2;
    /**
     * String del usuario y comprobacion
     */
    public static String[] ARRAY_STRING = new String[2];
    /**
     * int del usuario y comprobacion
     */
    public static  int INT_USUARIO;
    /**
     * Scanner que guarda los imputs del usuario
     */
    static Scanner guardar = new Scanner(System.in);

    private void EntradaSalida(){};

    /**
     * Salida por ventana o consala de un mensaje
     * @param msj cadena que queremos imprimir
     * @param device dispositivo de salida<br>consola: SALIDA_CONSOLA<br>ventana:SALIDA_VENTANA
     * @return si es true: correcto si no false
     */
    public static boolean salida(String msj, int device) {
        switch (device) {
            case SALIDA_CONSOLA:
                try {
                    System.out.println("Consola: " + msj);
                    return true;
                } catch (Exception e) {
                    return false;
                }

            case SALIDA_WINDOW:
                try {
                    JOptionPane.showMessageDialog(null,"Sale por un ventana " + msj);
                    return true;
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            default:
                return false;
        }
    }

    /**
     * Método que devuelve el String que introduce el usuario y un booleano de confirmación
     * @param comentario Mensaje a mostrar
     * @return Array con el String y la confirmación
     */
    public static String[] entradaString(String comentario){
        try {
            System.out.println(comentario);
            ARRAY_STRING[0] = guardar.next();
        } catch (InputMismatchException exception) {
            ARRAY_STRING[1] = "False";
            System.out.println("Tipo de dato erroneo, introduzca un String");
        }
        ARRAY_STRING[1] = "True";
        return ARRAY_STRING;
    }

    /**
     * Método que devuelve el entero que introduce el usuario y una confirmación
     * @param comentarioInt Mensaje a mostrar
     * @return int del usuario
     */
    public static int entradaInt(String comentarioInt) {
        try {
            System.out.println(comentarioInt);
            INT_USUARIO = guardar.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Tipo de dato erroneo, introduzca un int");
        }
        return INT_USUARIO;
    }
}