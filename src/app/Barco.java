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

    public static int tiro(String atacado[][],String atacante[][]) {
        int puntos = 0;
        boolean condicion = true;
        System.out.println("\nDisparo: ");
        do {
            int posfi = Coordenada.fila(atacado.length, 0);
            int posci = Coordenada.columna(atacado.length, 0);
            if (atacado[posfi][posci] == ANSI.AZUL+"O"+ANSI.RESET+"" || atacado[posfi][posci] == ANSI.ROJO+"X"+ANSI.RESET+"")
                System.out.println("\n"+ANSI.ROJO+"***¡YA DISPARASTE AQUI!***"+ANSI.RESET+"\n");
            else if (atacado[posfi][posci] == "■"){
                atacado[posfi][posci] = ANSI.ROJO+"X"+ANSI.RESET+"";
                atacante[posfi][posci] = ANSI.ROJO+"X"+ANSI.RESET+"";
                System.out.println("\n"+ANSI.VERDE+"***¡LE DISTE!***"+ANSI.RESET+"\n");
                puntos = 50;
                condicion = false;
            }
            else{
                atacado[posfi][posci] = ANSI.AZUL+"O"+ANSI.RESET+"";
                atacante[posfi][posci] = ANSI.AZUL+"O"+ANSI.RESET+"";
                System.out.println("\n"+ANSI.CELESTE+"***¡FALLASTE!***"+ANSI.RESET+"\n");
                puntos = -5;
                condicion = false;
            }
        }while (condicion);
        return puntos;
    }

    public static boolean establecer(String matriz[][], int tamanio, int posfi, int posci, int posff, int poscf) {
        boolean fallo1 = false;
        boolean fallo2 = false;
        boolean terminar = true;
        boolean traslape = false;
        switch (tamanio) {
        case 1:
            if (matriz[posfi][posci] == "■")
                System.out.println("\n"+ANSI.ROJO+"***¡BARCO TRASLAPA!***"+ANSI.RESET+"\n");
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
                                System.out.println("\n"+ANSI.ROJO+"***¡BARCO TRASLAPA!***"+ANSI.RESET+"\n");
                                traslape = true;
                                break;
                            }

                        } else if (matriz[posff + c][posci] == "■") { // abajo arriba
                            System.out.println("\n"+ANSI.ROJO+"***¡BARCO TRASLAPA!***"+ANSI.RESET+"\n");
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
                                System.out.println("\n"+ANSI.ROJO+"***¡BARCO TRASLAPA!***"+ANSI.RESET+"\n");
                                traslape = true;
                                break;
                            }

                        } else if (matriz[posfi][poscf + c] == "■") {
                            System.out.println("\n"+ANSI.ROJO+"***¡BARCO TRASLAPA!***"+ANSI.RESET+"\n");
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
                System.out.println("\n"+ANSI.ROJO+"***TAMANIO INCORRECTO O DIAGONAL***"+ANSI.RESET+"\n");
            break;
        }
        return terminar;
    }
}
