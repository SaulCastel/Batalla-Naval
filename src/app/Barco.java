package app;

import java.util.Scanner;
import java.util.Random;

class Barco {
    public static boolean proseguir = true;

    public static void barco4(String matriz[][]) {
        boolean condicion = true;
        do {
            int posfi = Coordenada.fila(matriz.length, 0);
            int posci = Coordenada.columna(matriz.length, 0);
            int posff = Coordenada.fila(matriz.length, 1);
            int poscf = Coordenada.columna(matriz.length, 1);
            condicion = establecer(matriz, 4, posfi, posci, posff, poscf);
        } while (condicion);
    }

    public static void barco3(String matriz[][]) {
        boolean condicion = true;
        do {
            int posfi = Coordenada.fila(matriz.length, 0);
            int posci = Coordenada.columna(matriz.length, 0);
            int posff = Coordenada.fila(matriz.length, 1);
            int poscf = Coordenada.columna(matriz.length, 1);
            condicion = establecer(matriz, 3, posfi, posci, posff, poscf);
        } while (condicion);
    }

    public static void barco2(String matriz[][]) {
        boolean condicion = true;
        do {
            int posfi = Coordenada.fila(matriz.length, 0);
            int posci = Coordenada.columna(matriz.length, 0);
            int posff = Coordenada.fila(matriz.length, 1);
            int poscf = Coordenada.columna(matriz.length, 1);
            condicion = establecer(matriz, 2, posfi, posci, posff, poscf);
        } while (condicion);
    }

    public static void barco1(String matriz[][]) {
        boolean condicion = true;
        do {
            int posfi = Coordenada.fila(matriz.length, 0);
            int posci = Coordenada.columna(matriz.length, 0);
            condicion = establecer(matriz, 1, posfi, posci, 0, 0);
        } while (condicion);
    }

    public static void pruebas(String matriz[][]) {
        for (int f = 0; f < 2; f++) {
            for (int c = 0; c < 10; c++) {
                matriz[f][c] = "■";
            }
        }
    }

    public static int tiro(String atacado[][], String atacante[][], boolean usado, int poder) {
        Scanner entrada = new Scanner(System.in);
        int eleccion = 0;
        int estado = 0;
        int D1, D2;
        Random dados = new Random();

        double suerte = (usado) ? Math.random() * 10 : 1;
        do {
            System.out.println("\n\nDISPARAR(1) | DADOS(2) | USAR PODER(3) | RENDIRTE(4)");
            System.out.print("QUE DESEAS HACER: ");
            while (!entrada.hasNextInt()) {
                entrada.nextLine();
            }
            eleccion = entrada.nextInt();
            if (eleccion == 1) {

                int posfi = Coordenada.fila(atacado.length, 0);
                int posci = Coordenada.columna(atacado.length, 0);
                estado = disparo(atacado, atacante, posfi, posci, suerte);

            } else if (eleccion == 2) {
                do {
                    D1 = dados.nextInt(atacante.length);
                    D2 = dados.nextInt(atacante.length);
                    if (atacante[D1][D2] != ANSI.CELESTE + "." + ANSI.RESET + "")
                        proseguir = true;
                    else {
                        System.out.println("\nLOS DADOS MUESTRAN: [" + ANSI.VERDE + Coordenada.conversion(D1 + 1)
                                + " - " + (D2 + 1) + ANSI.RESET + "]");
                        System.out.println("PRESIONA ENTER PARA CONTINUAR");
                        entrada.nextLine();
                        entrada.nextLine();
                        estado = disparo(atacado, atacante, D1, D2, suerte);
                        proseguir = false;
                    }
                } while (proseguir);

            } else if (eleccion == 3) {
                if (poder > 0 && poder < 5) {
                    estado = PCN.usar(poder);
                    poder = 0;
                    proseguir = false;
                } else
                    System.out.println(ANSI.ROJO + "\n¡NO TIENES NINGUN PODER! \nENTER PARA CONTINUAR\n" + ANSI.RESET);
                    estado = 11;
                    entrada.nextLine();
                    entrada.nextLine();
                    proseguir = false;
            } else if (eleccion == 4) {
                estado = 6;
                proseguir = false;
            }
        } while (proseguir);
        return estado;
    }

    static int disparo(String atacado[][], String atacante[][], int posfi, int posci, double suerte) {
        int entregar = 0;

        if (atacado[posfi][posci] == ANSI.AZUL + "O" + ANSI.RESET + ""
                || atacado[posfi][posci] == ANSI.ROJO + "X" + ANSI.RESET + "") {
            System.out.println("\n" + ANSI.ROJO + "***¡YA DISPARASTE AQUI!***" + ANSI.RESET + "\n");
            proseguir = true;
        } else if (atacado[posfi][posci] == "■") {
            atacado[posfi][posci] = ANSI.ROJO + "X" + ANSI.RESET + "";
            atacante[posfi][posci] = ANSI.ROJO + "X" + ANSI.RESET + "";
            entregar = 5;
            proseguir = false;
        } else {
            atacado[posfi][posci] = ANSI.AZUL + "O" + ANSI.RESET + "";
            atacante[posfi][posci] = ANSI.AZUL + "O" + ANSI.RESET + "";
            System.out.println("\n" + ANSI.CELESTE + "***¡FALLASTE!***" + ANSI.RESET + "\n");

            if (suerte >= 0.0 && suerte < 0.2) { // entregar Ka boom 2%
                PCN.mensaje(1);
                entregar = 1;
            } else if (suerte >= 1.25 && suerte < 1.45) { // entregar escoger 2%
                PCN.mensaje(2);
                entregar = 2;
            } else if (suerte >= 2.5 && suerte < 3.0) { // entregar neblina 5%
                PCN.mensaje(3);
                entregar = 3;
            } else if (suerte >= 3.75 && suerte < 4.25) { // Entregar escudo 5%
                PCN.mensaje(4);
                entregar = 4;
            } else if (suerte >= 5 && suerte < 5.2) { // Escoger negado 2%
                PCN.mensaje(5);
            } else if (suerte >= 6.25 && suerte < 6.75) { // perder 120 puntos 2%
                PCN.mensaje(6);
            } else if (suerte >= 7.5 && suerte < 8.0) { // Kraken 5%
                PCN.mensaje(7);
            } else if (suerte >= 8.75 && suerte < 9.25) { // dados trucados 5%
                PCN.mensaje(8);
            }
            proseguir = false;
        }
        return entregar;
    }

    public static boolean establecer(String matriz[][], int tamanio, int posfi, int posci, int posff, int poscf) {
        boolean fallo1 = false;
        boolean fallo2 = false;
        boolean terminar = true;
        boolean traslape = false;
        switch (tamanio) {
        case 1:
            if (matriz[posfi][posci] == "■")
                System.out.println("\n" + ANSI.ROJO + "***¡BARCO TRASLAPA!***" + ANSI.RESET + "\n");
            else {
                matriz[posfi][posci] = "■";
                terminar = false;
            }
            break;

        default:
            // establecer vertical
            if (posff == posfi + (tamanio - 1) || posff == posfi - (tamanio - 1)) {
                if (poscf == posci) {
                    for (int c = 0; c < tamanio; c++) {
                        if (posff == posfi + (tamanio - 1)) { // arriba abajo
                            if (matriz[posfi + c][posci] == "■") {
                                System.out.println("\n" + ANSI.ROJO + "***¡BARCO TRASLAPA!***" + ANSI.RESET + "\n");
                                traslape = true;
                                break;
                            }

                        } else if (matriz[posff + c][posci] == "■") { // abajo arriba
                            System.out.println("\n" + ANSI.ROJO + "***¡BARCO TRASLAPA!***" + ANSI.RESET + "\n");
                            traslape = true;
                            break;
                        }
                    }
                    if (traslape)
                        break;
                    else if (posff == posfi + (tamanio - 1)) {
                        for (int c = 0; c < tamanio; c++) {
                            matriz[posfi + c][posci] = "■";
                            terminar = false;
                        }
                    } else {
                        for (int c = 0; c < tamanio; c++) {
                            matriz[posff + c][posci] = "■";
                            terminar = false;
                        }
                    }
                } else
                    fallo1 = true;
            } else
                fallo1 = true;
            // establecer horizontal
            if (poscf == posci + (tamanio - 1) || poscf == posci - (tamanio - 1)) {
                if (posff == posfi) {
                    for (int c = 0; c < tamanio; c++) {
                        if (poscf == posci + (tamanio - 1)) {
                            if (matriz[posfi][posci + c] == "■") {
                                System.out.println("\n" + ANSI.ROJO + "***¡BARCO TRASLAPA!***" + ANSI.RESET + "\n");
                                traslape = true;
                                break;
                            }

                        } else if (matriz[posfi][poscf + c] == "■") {
                            System.out.println("\n" + ANSI.ROJO + "***¡BARCO TRASLAPA!***" + ANSI.RESET + "\n");
                            traslape = true;
                            break;

                        }
                    }
                    if (traslape)
                        break;
                    else if (poscf == posci + (tamanio - 1)) {
                        for (int c = 0; c < tamanio; c++) {
                            matriz[posfi][posci + c] = "■";
                            terminar = false;
                        }
                    } else {
                        for (int c = 0; c < tamanio; c++) {
                            matriz[posfi][poscf + c] = "■";
                            terminar = false;
                        }
                    }
                } else
                    fallo2 = true;
            } else
                fallo2 = true;
            if (fallo1 == true && fallo2 == true)
                System.out.println("\n" + ANSI.ROJO + "***TAMANIO INCORRECTO O DIAGONAL***" + ANSI.RESET + "\n");
            break;
        }
        return terminar;
    }
}
