package app;

import java.util.Scanner;

import java.io.*;

class Opcion {
    private static Scanner entrada = new Scanner(System.in);

    public static int opciones() {
        int eleccion = 0;
        System.out.println("\n1. Empezar Nueva Partida");
        System.out.println("2. Mostrar Historial De Partidas");
        System.out.println("3. Mostrar Informacion Del Estudiante");
        System.out.println("4. Salir");
        while (true) {
            System.out.print("\n¿Que deseas hacer?: ");
            while (!entrada.hasNextInt()) {
                System.out.print("\n¿Que deseas hacer?: ");
                entrada.nextLine();
            }
            eleccion = entrada.nextInt();
            break;
        }
        return eleccion;
    }

    public static void partida() {
        int tamanio = Coordenada.tamanio();
        String tablero[][] = new String[tamanio][tamanio];
        String tablero2[][] = new String[tamanio][tamanio];
        String turno[][] = new String[tamanio][tamanio];
        String turno2[][] = new String[tamanio][tamanio];
        String neblina[][] = new String[tamanio][tamanio];
        Tablero.establecer(tablero, ANSI.CELESTE + "." + ANSI.RESET);
        Tablero.establecer(tablero2, ANSI.CELESTE + "." + ANSI.RESET);
        Tablero.establecer(turno, ANSI.CELESTE + "." + ANSI.RESET);
        Tablero.establecer(turno2, ANSI.CELESTE + "." + ANSI.RESET);
        Tablero.establecer(neblina, ANSI.BLANCO + "@" + ANSI.RESET);
        System.out.print("\n¿NOMBRE DEL JUGADOR 1?: ");
        String j1 = entrada.next();
        System.out.print("\n¿NOMBRE DEL JUGADOR 2?: ");
        String j2 = entrada.next();
        Tablero.dibujar(tablero, tablero2);
        Barco.pruebas(turno);
        // Barcos(j1, turno, tablero2);
        for (int i = 0; i < 20; i++) {
            System.out.println("\n");
        }
        Tablero.dibujar(tablero, tablero2);
        Barco.pruebas(turno2);
        // Barcos(j2, turno2, tablero);
        for (int i = 0; i < 20; i++) {
            System.out.println("\n");
        }
        double quien = Math.random();
        int numero = 0;
        int turnosj1 = 0;
        int turnosj2 = 0;
        boolean terminar = false;
        boolean extra = false;
        boolean usado1 = true;
        boolean usado2 = true;
        boolean rendirse1 = false;
        boolean rendirse2 = false;
        double cadena = 1.0;
        int estado1 = 0;
        int estado2 = 0;
        int poderj1 = 0;
        int poderj2 = 0;
        int restante1 = 0;
        int restante2 = 0;
        int puntos1 = 300;
        int puntos2 = 300;
        int aciertos1 = 0;
        int fallos1 = 0;
        int aciertos2 = 0;
        int fallos2 = 0;
        int barcos1 = Top.cantidad(turno, "■");
        int barcos2 = Top.cantidad(turno2, "■");
        entrada.nextLine();// Inicializar el scanner de nuevo
        while (!terminar) {
            if (quien >= 0.0 && quien <= 0.5 && barcos1 != 0 && barcos2 != 0 && !rendirse1 && !rendirse2) {
                Tablero.dibujar(tablero, tablero2);
                if (extra) {
                    System.out.println("\n" + ANSI.VERDE + "---" + j1.toUpperCase()
                            + " ACERTASTE, CONTINUA TU CADENA!---" + ANSI.RESET);
                    extra = false;
                }
                System.out.print("\n\n[ DISPAROS: " + turnosj1 + ", " + j1.toUpperCase() + " , PUNTOS x" + cadena + ": "
                        + puntos1 + " ]");
                if (puntos1 <= 100)
                    System.out.print(ANSI.ROJO + " <= ¡PUNTOS BAJOS!" + ANSI.RESET);
                PCN.vida(barcos1);
                if (restante1 > 1) {
                    PCN.barra(poderj1);
                    System.out.print(ANSI.VERDE + " <= " + restante1 + " T" + ANSI.RESET);
                } else if (restante1 == 1) {
                    PCN.barra(poderj1);
                    System.out.println(ANSI.ROJO + " <= ¡ULTIMA OPORTUNIDAD!" + ANSI.RESET);
                } else {
                    poderj1 = 0;
                    usado1 = true;
                    PCN.barra(poderj1);
                }
                estado1 = Barco.tiro(turno2, tablero2, usado1, poderj1);
                if (estado1 == 5) {
                    puntos1 += 50 * cadena;
                    cadena = (cadena == 2.5) ? cadena + 0.0 : cadena + 0.5;
                    turnosj1++;
                    quien = 0.2;
                    extra = true;
                } else if (estado1 != 6) {
                    if (estado1 > 0 && estado1 <= 4) {
                        poderj1 = estado1;
                        usado1 = false;
                        restante1 = 6;
                    } else if (estado1 >= 7) {
                        usado1 = true;
                        poderj1 = 0;
                    }
                    if (estado1 <= 7) {
                        Tablero.dibujar(tablero, tablero2);
                        puntos1 -= 20;
                        cadena = 1.0;
                        turnosj1++;
                        if (usado1 == false)
                            restante1--;
                        quien = 0.8;
                        System.out.println("\n---" + j2.toUpperCase() + " ES TU TURNO, PRESIONA ENTER---");
                        entrada.nextLine();
                    } else {
                        quien = 0.2;
                    }
                } else
                    rendirse1 = true;
                barcos2 = Top.cantidad(turno2, "■");
                for (int i = 0; i < 20; i++) {
                    System.out.println("\n");
                }
            }
            if (quien > 0.5 && quien <= 1.0 && barcos2 != 0 && barcos1 != 0 && !rendirse1 && !rendirse2) {
                Tablero.dibujar(tablero, tablero2);
                if (extra) {
                    System.out.println("\n" + ANSI.VERDE + "---" + j2.toUpperCase()
                            + " ACERTASTE, CONTINUA TU CADENA!---" + ANSI.RESET);
                    extra = false;
                }
                System.out.print("\n[ DISPAROS: " + turnosj2 + ", " + j2.toUpperCase() + " , PUNTOS x" + cadena + ": "
                        + puntos2 + " ]");
                if (puntos2 <= 100)
                    System.out.print(ANSI.ROJO + " <= ¡PUNTOS BAJOS!" + ANSI.RESET);
                PCN.vida(barcos2);
                if (restante2 > 1) {
                    PCN.barra(poderj2);
                    System.out.print(ANSI.VERDE + " <= " + restante2 + " T" + ANSI.RESET);
                } else if (restante2 == 1) {
                    PCN.barra(poderj2);
                    System.out.println(ANSI.ROJO + " <= ¡ULTIMA OPORTUNIDAD!" + ANSI.RESET);
                } else {
                    poderj2 = 0;
                    usado2 = true;
                    PCN.barra(poderj2);
                }
                estado2 = Barco.tiro(turno, tablero, usado2, poderj2);
                if (estado2 == 5) {
                    puntos2 += 50 * cadena;
                    cadena = (cadena == 2.5) ? cadena + 0.0 : cadena + 0.5;
                    turnosj2++;
                    quien = 0.8;
                    extra = true;
                } else if (estado2 != 6) {
                    if (estado2 > 0 && estado2 <= 4) {
                        poderj2 = estado2;
                        usado2 = false;
                        restante2 = 6;
                    } else if (estado2 >= 7) {
                        usado2 = true;
                        poderj2 = 0;
                    }
                    if (estado2 <= 7) {
                        Tablero.dibujar(tablero, tablero2);
                        puntos2 -= 20;
                        cadena = 1.0;
                        turnosj2++;
                        if (usado2 == false)
                            restante2--;
                        quien = 0.2;
                        System.out.println("\n---" + j1.toUpperCase() + " ES TU TURNO, PRESIONA ENTER---");
                        entrada.nextLine();
                    } else {
                        quien = 0.8;
                    }
                } else
                    rendirse2 = true;
                barcos1 = Top.cantidad(turno, "■");
                for (int i = 0; i < 20; i++) {
                    System.out.println("\n");
                }
            }
            if (puntos1 <= 0 || barcos1 == 0 || rendirse1) {
                System.out.println("***¡" + j1.toUpperCase() + " PIERDE, FELICIDADES " + j2.toUpperCase() + "!***");
                System.out.println("***¡GANASTE LA PARTIDA CON " + puntos2 + " PUNTOS!***");
                aciertos1 = Top.cantidad(tablero2, ANSI.ROJO + "X" + ANSI.RESET + "");
                fallos1 = Top.cantidad(tablero2, ANSI.AZUL + "O" + ANSI.RESET + "");
                aciertos2 = Top.cantidad(tablero, ANSI.ROJO + "X" + ANSI.RESET + "");
                fallos2 = Top.cantidad(tablero, ANSI.AZUL + "O" + ANSI.RESET + "");
                numero = turnosj1 + turnosj2;
                Top.resultados(j2, puntos2, aciertos2, fallos2, j1, puntos1, aciertos1, fallos1, tamanio, numero);
                terminar = true;
            } else if (puntos2 <= 0 || barcos2 == 0 || rendirse2) {
                System.out.println("***¡" + j2.toUpperCase() + " PIERDE, FELICIDADES " + j1.toUpperCase() + "!***");
                System.out.println("***¡GANASTE LA PARTIDA CON " + puntos1 + " PUNTOS!***");
                aciertos1 = Top.cantidad(tablero2, ANSI.ROJO + "X" + ANSI.RESET + "");
                fallos1 = Top.cantidad(tablero2, ANSI.AZUL + "O" + ANSI.RESET + "");
                aciertos2 = Top.cantidad(tablero, ANSI.ROJO + "X" + ANSI.RESET + "");
                fallos2 = Top.cantidad(tablero, ANSI.AZUL + "O" + ANSI.RESET + "");
                numero = turnosj1 + turnosj2;
                Top.resultados(j1, puntos1, aciertos1, fallos1, j2, puntos2, aciertos2, fallos2, tamanio, numero);
                terminar = true;
            }
        }
    }

    private static void Barcos(String j, String matriz1[][], String matriz2[][]) {
        System.out.println("\n" + j.toUpperCase() + ", INGRESA 1 BARCO DE 4 CASILLAS");
        Barco.barco4(matriz1);
        Tablero.dibujar(matriz1, matriz2);
        System.out.println("\n" + j.toUpperCase() + ", INGRESA 2 BARCOS DE 3 CASILLAS");
        for (int b = 1; b <= 2; b++) {
            System.out.println("\no-o BARCO DE 3 CASILLAS #" + b + " o-o");
            Barco.barco3(matriz1);
            Tablero.dibujar(matriz1, matriz2);
        }
        System.out.println("\n" + j.toUpperCase() + ", INGRESA 3 BARCOS DE 2 CASILLAS");
        for (int b = 1; b <= 3; b++) {
            System.out.println("\no-o BARCO DE 2 CASILLAS #" + b + " o-o");
            Barco.barco2(matriz1);
            Tablero.dibujar(matriz1, matriz2);
        }
        System.out.println("\n" + j.toUpperCase() + ", INGRESA 4 BARCOS DE 1 CASILLA");
        for (int b = 1; b <= 4; b++) {
            System.out.println("\no-o BARCO DE 1 CASILLAS #" + b + " o-o");
            Barco.barco1(matriz1);
            Tablero.dibujar(matriz1, matriz2);
        }
    }

    public static void archivo(File texto) {

        String linea = null;

        try {

            FileReader archivo = new FileReader(texto);

            BufferedReader lector = new BufferedReader(archivo);

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            lector.close();
        } catch (FileNotFoundException errorArc) {
            System.out.println("Error al abrir '" + texto + "'");
        } catch (IOException errorLeer) {
            System.out.println("Error al leer '" + texto + "'");
        }
    }
}