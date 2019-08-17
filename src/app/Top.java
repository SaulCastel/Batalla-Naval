package app;

import java.io.*;

class Top {

    public static int cantidad(String matriz[][], String elemento) {
        int cantidad = 0;
        for (int v = 0; v < matriz.length; v++) {
            for (int h = 0; h < matriz.length; h++) {
                if (matriz[v][h] == elemento)
                    cantidad++;
            }
        }
        return cantidad;
    }

    public static void resultados(String ganador, int puntos1, int aciertos1, int fallos1, String perdedor, int puntos2,
            int aciertos2, int fallos2, int tablero) {

        try {
            FileWriter archivo = new FileWriter(Menu.historial, true);
            BufferedWriter actualizar = new BufferedWriter(archivo);
            PrintWriter escribir = new PrintWriter(actualizar);
            escribir.println("\noooooooooooooooooooooooooooooooooooooooooooooooooo");
            escribir.println("\nGANADOR: " + ganador.toUpperCase() + " / PERDEDOR: " + perdedor.toUpperCase());
            escribir.println("TAMANIO DEL TABLERO: " + tablero + " x " + tablero);
            escribir.println("PUNTOS, ACIERTOS Y FALLOS DE " + ganador.toUpperCase() + ": " + puntos1 + ", " + aciertos1
                    + ", " + fallos1);
            escribir.println("PUNTOS, ACIERTOS Y FALLOS DE " + perdedor.toUpperCase() + ": " + puntos2 + ", "
                    + aciertos2 + ", " + fallos2);
            escribir.println("\noooooooooooooooooooooooooooooooooooooooooooooooooo");
            escribir.close();
            actualizar.close();
        } catch (IOException errorAct) {
            System.out.println("No se pudo actualizar el historial de partidas");
        }
    }
}