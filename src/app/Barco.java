package app;

class Barco {

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

    public static int tiro(String atacado[][], String atacante[][], boolean poder) {
        int estado = 0;
        boolean condicion = true;
        double suerte = (poder) ? Math.random() : 1;
        System.out.print("\nCoordenadas Disparo: ");
        do {
            int posfi = Coordenada.fila(atacado.length, 0);
            int posci = Coordenada.columna(atacado.length, 0);
            if (atacado[posfi][posci] == ANSI.AZUL + "O" + ANSI.RESET + ""
                    || atacado[posfi][posci] == ANSI.ROJO + "X" + ANSI.RESET + "")
                System.out.println("\n" + ANSI.ROJO + "***¡YA DISPARASTE AQUI!***" + ANSI.RESET + "\n");
            else if (atacado[posfi][posci] == "■") {
                atacado[posfi][posci] = ANSI.ROJO + "X" + ANSI.RESET + "";
                atacante[posfi][posci] = ANSI.ROJO + "X" + ANSI.RESET + "";
                estado = 4;
                condicion = false;
            } else {
                atacado[posfi][posci] = ANSI.AZUL + "O" + ANSI.RESET + "";
                atacante[posfi][posci] = ANSI.AZUL + "O" + ANSI.RESET + "";
                System.out.println("\n" + ANSI.CELESTE + "***¡FALLASTE!***" + ANSI.RESET + "\n");

                if (suerte >= 0.0 && suerte <= 0.05) {
                    System.out.println("PERO ENCONTRASTE EL PODER ESPECIAL: DAÑO EN AREA");
                    estado = 1;
                } else if (suerte >= 0.4 && suerte <= 0.45) {
                    System.out.println("PERO ENCONTRASTE EL PODER ESPECIAL: SCANNER");
                    estado = 2;
                } else if (suerte >= 0.9 && suerte <= 0.95) {
                    System.out.println("PERO ENCONTRASTE EL PODER ESPECIAL: OTRO TURNO");
                    estado = 3;
                }
                condicion = false;
            }
        } while (condicion);
        return estado;
    }

    public static void cajita(int numero) {
        String poderes[] = { "", "\u001b[1;31mA\u001b[1;33mR\u001b[32mE\u001b[1;35mA\u001B[0m", // AREA
                "\u001b[1;31mS\u001b[1;33mC\u001b[32mA\u001b[1;35mN\u001B[0m", // SCAN
                "\u001b[1;31mO\u001b[1;33mT\u001b[32mR\u001b[1;35mO\u001B[0m", // OTRO
                "" };
        System.out.print(" PODER [ " + poderes[numero] + " ]\n");
    }

    public static void vida(int cantidad) {
        String HP[] = { ANSI.ROJO + "■" + ANSI.RESET, ANSI.ROJO + "■ ■" + ANSI.RESET, ANSI.ROJO + "■ ■ ■" + ANSI.RESET,
                ANSI.ROJO + "■ ■ ■ ■" + ANSI.RESET, };
        String corazones = null;
        if (cantidad > 15)
            corazones = HP[3];
        else if (cantidad > 10)
            corazones = HP[2];
        else if (cantidad > 5)
            corazones = HP[1];
        else if (cantidad >= 1)
            corazones = HP[0];
        System.out.print("\nHP [ " + corazones + " ]");
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
