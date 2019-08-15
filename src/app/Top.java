package app;

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
    
    public static void historial(String ganador, int puntos1, int aciertos1, int fallos1, 
    String perdedor, int puntos2,int aciertos2, int fallos2, String tablero[][]) {
        System.out.println("GANADOR: " + ganador.toUpperCase() + " / PERDEDOR: " + perdedor.toUpperCase());
        System.out.println("TAMAÑO DEL TABLERO: " + tablero.length + " x " + tablero.length);
        System.out.println(
                "PUNTOS, ACIERTOS Y FALLOS DE " + ganador.toUpperCase() + ": " + puntos1 +", "+ aciertos1 +", "+ fallos1);
        System.out.println(
                "PUNTOS, ACIERTOS Y FALLOS DE " + perdedor.toUpperCase() + ": " + puntos2 +", "+ aciertos2 +", "+ fallos2);

    }
}