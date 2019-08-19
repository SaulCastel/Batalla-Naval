package app;

import java.io.*;

public class Menu {
    static File historial = new File("historial.txt");
    static File logo = new File("logo.txt");
    static File dibujo = new File("salir.txt");
    static boolean salir = false;
    static int opcion = 0;

    public static void main(String[] args) {
        Opcion.archivo(logo);
        System.out.println("\nBatalla Naval v1.0 ULTRA\n");
        while (!salir) {
            opcion = Opcion.opciones();
            switch (opcion) {
            case 1:
                Opcion.partida();
                break;
            case 2:
                Opcion.archivo(historial);
                break;
            case 3:
                System.out.print("\nSAUL ESTEBAN CASTELLANOS UBEDA\n");
                System.out.print("\nREGISTRO ESTUDIANTIL 201801178\n");
                System.out.print("\n********* SECCION C **********\n");
                break;
            case 4:
                Opcion.archivo(dibujo);
                salir = true;
                break;
            default:
                System.out.println("\nESCOGE UNA OPCION VALIDA\n");
                break;
            }
        }
    }
}
