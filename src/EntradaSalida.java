import javax.swing.*;
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
     * String del usuario
     */
    public static String STRING_USUARIO;
    /**
     * int del usuario
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
     * TODO método para obtener distintos tipos de datos por consola
     * @param comentario Mensaje a mostrar
     * @return String del usuario
     */
    public static String entrada(String comentario){
        try {
            System.out.println(comentario);
            STRING_USUARIO = guardar.next();
        } catch (InputMismatchException exception) {
            System.out.println("Tipo de dato erroneo, introduzca un String");
        }
        return STRING_USUARIO;
    }

    /**
     * Método que devuelve el entero que introduce el usuario
     * @param comentarioInt Mensaje a mostrar
     * @return Entero del usuario
     */
    public static int salida(String comentarioInt) {
        try {
            System.out.println(comentarioInt);
            INT_USUARIO = guardar.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Tipo de dato erroneo, introduzca un int");
        }
        return INT_USUARIO;
    }
}