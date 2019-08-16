package app;

class Tablero {
    static final String[] Numeros = 
    { "   ", "1  ", "2  ", "3  ", "4  ", "5  ", 
    "6  ", "7  ", "8  ", "9  ", "10 ", "11 ",
    "12 ", "13 ", "14 ", "15 ", "16 ", "17 ", 
    "18 ", "19 ", "20 ", "21 ", "22 ", "23 ", 
    "24 ", "25 ", "26 " };
    static final String[] Letras = 
    { "A", "B", "C", "D", "E", "F", "G", 
    "H", "I", "J", "K", "L", "M", "N", 
    "O", "P", "Q", "R","S", "T", "U", 
    "V", "W", "X", "Y", "Z" };
    
    public static void establecer(String matriz[][]) {
        int _fila = 0;
        int _columna = 0;
        for (int v = 1; v <= matriz.length; v++) {
            for (int h = 1; h <= matriz.length; h++) {
                matriz[_fila][_columna] = ANSI.CELESTE+ "." +ANSI.RESET+"";
                _columna++;
            }
            _columna = 0;
            _fila++;
        }
    }

    public static void dibujar(String matriz1[][], String matriz2[][]) {
        int fila = 0;
        int col1 = 0;
        int col2 = 0;
        System.out.println();
        for (int v = 0; v <= matriz1.length; v++) {
            if (v == 0) {// parametros para dibujar los numeros
                for (int h = 0; h <= (matriz1.length * 2) + 3; h++) {
                    if (h == 0)
                        System.out.print(Numeros[0]);
                    if (h > 0 && h <= matriz1.length) {
                        System.out.print(Numeros[col1 + 1]);
                        col1++;
                    }
                    if (h > matriz1.length && h <= matriz1.length + 3)
                        System.out.print(Numeros[0]);
                    if (h > matriz1.length + 3 && h <= (matriz1.length * 2) + 3) {
                        System.out.print(Numeros[col2 + 1]);
                        col2++;
                    }
                }
                // Reiniciar contadores de columnas
                col1 = 0;
                col2 = 0;
            } else {
                for (int h = 0; h <= (matriz1.length * 2) + 3; h++) {// todas las columnas
                    if (h == 0)
                        System.out.print(Letras[fila] + "  ");// letra de la fila
                    if (h > 0 && h <= matriz1.length) {// columnas primer tablero
                        System.out.print(matriz1[fila][col1] + "  ");
                        col1++;
                    }
                    if (h > matriz1.length && h < matriz1.length + 3)
                        System.out.print("|  ");// columnas division de tableros

                    if (h == matriz1.length + 3)
                        System.out.print(Letras[fila] + "  ");// letra de la fila
                    if (h > matriz1.length + 3 && h <= (matriz1.length * 2) + 3) {// columnas segundo tablero
                        System.out.print(matriz2[fila][col2] + "  ");
                        col2++;
                    }
                }
                // reiniciar contadores de columnas y cambiar la fila para las matrices
                col1 = 0;
                col2 = 0;
                fila++;
            }
            System.out.println();
        }
    }
}