package app;

import java.util.Scanner;

class Coordenada {
    static Scanner entrada = new Scanner(System.in);

    public static int tamanio() {
        int limite = 0;
        boolean condicion = true;
        System.out.print("¿Limite de la matriz nxn? (10-26): ");
        do {
            while (!entrada.hasNextInt()) {
                System.out.print("\nNo valido, intenta de nuevo: ");
                entrada.nextLine();
            }
            limite = entrada.nextInt();
            if (limite < 10 || limite > 26)
                System.out.print("\nNo valido, intenta de nuevo: ");
            else
                condicion = false;
        } while (condicion);
        return limite;
    }

    public static int fila(int limite, int posicion) {
        String delta = (posicion == 0) ? "inicial" : "final";
        String letra = "";
        int fila = 0;
        boolean condicion = true;
        System.out.println("\nFila " + delta + " (A-" + conversion(limite) + ")");
        do {
            letra = entrada.nextLine();
            switch (letra.toUpperCase()) {
            case "A":
                fila = 0;
                break;
            case "B":
                fila = 1;
                break;
            case "C":
                fila = 2;
                break;
            case "D":
                fila = 3;
                break;
            case "E":
                fila = 4;
                break;
            case "F":
                fila = 5;
                break;
            case "G":
                fila = 6;
                break;
            case "H":
                fila = 7;
                break;
            case "I":
                fila = 8;
                break;
            case "J":
                fila = 9;
                break;
            case "K":
                fila = 10;
                break;
            case "L":
                fila = 11;
                break;
            case "M":
                fila = 12;
                break;
            case "N":
                fila = 13;
                break;
            case "O":
                fila = 14;
                break;
            case "P":
                fila = 15;
                break;
            case "Q":
                fila = 16;
                break;
            case "R":
                fila = 17;
                break;
            case "S":
                fila = 18;
                break;
            case "T":
                fila = 19;
                break;
            case "U":
                fila = 20;
                break;
            case "V":
                fila = 21;
                break;
            case "W":
                fila = 22;
                break;
            case "X":
                fila = 23;
                break;
            case "Y":
                fila = 24;
                break;
            case "Z":
                fila = 25;
                break;

            default:
                fila = 26;
                break;
            }
            if (fila + 1 > limite)
                System.out.print("Ingresa una letra: ");
            else
                condicion = false;
        } while (condicion);
        return fila;
    }

    public static int columna(int limite, int posicion) {
        String delta = (posicion == 0) ? "inicial" : "final";
        int numero = 0;
        int columna = 0;
        boolean condicion = true;
        System.out.println("\nColumna " + delta + " (1-" + limite + ")");
        System.out.print("Ingresa un numero: ");
        while (condicion) {
            while (!entrada.hasNextInt()) {
                System.out.print("Ingresa un numero: ");
                entrada.nextLine();
            }
            numero = entrada.nextInt();
            switch (numero) {
            case 1:
                columna = 0;
                break;
            case 2:
                columna = 1;
                break;
            case 3:
                columna = 2;
                break;
            case 4:
                columna = 3;
                break;
            case 5:
                columna = 4;
                break;
            case 6:
                columna = 5;
                break;
            case 7:
                columna = 6;
                break;
            case 8:
                columna = 7;
                break;
            case 9:
                columna = 8;
                break;
            case 10:
                columna = 9;
                break;
            case 11:
                columna = 10;
                break;
            case 12:
                columna = 11;
                break;
            case 13:
                columna = 12;
                break;
            case 14:
                columna = 13;
                break;
            case 15:
                columna = 14;
                break;
            case 16:
                columna = 15;
                break;
            case 17:
                columna = 16;
                break;
            case 18:
                columna = 17;
                break;
            case 19:
                columna = 18;
                break;
            case 20:
                columna = 19;
                break;
            case 21:
                columna = 20;
                break;
            case 22:
                columna = 21;
                break;
            case 23:
                columna = 22;
                break;
            case 24:
                columna = 23;
                break;
            case 25:
                columna = 24;
                break;
            case 26:
                columna = 25;
                break;

            default:
                columna = 26;
                break;
            }
            if (columna + 1 > limite)
                System.out.print("Ingresa un numero: ");
            else
                condicion = false;
        }
        return columna;
    }

    public static char conversion(int numero) {
        numero = numero + 64;
        char letra = (char) numero;
        return letra;
    }
}