package app;

import java.util.Scanner;

class Opcion {
    private static Scanner entrada = new Scanner(System.in);

    public static int opciones() {
        int eleccion = 0;
        System.out.println("\nBatalla Naval v1.0");
        System.out.println("1. Empezar Nueva Partida");
        System.out.println("2. Mostrar Historial De Partidas");
        System.out.println("3. Mostrar Puntuaciones Mas Altas");
        System.out.println("4. Mostrar Jugadores Con Mayor Cantidad De Fallos");
        System.out.println("5. Mostrar Jugadores Con Mayor Cantidad De Aciertos");
        System.out.println("6. Mostrar TOP 3 jugadores");
        System.out.println("7. Mostrar Informacion Del Estudiante");
        System.out.println("8. Salir");
        while (true) {
            System.out.print("\n¿Que deseas hacer?: ");
            while (!entrada.hasNextInt()) {
                System.out.println("Solo puedes ingresar un numero de opcion");
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
        Tablero.establecer(tablero);
        Tablero.establecer(tablero2);
        Tablero.establecer(turno);
        Tablero.establecer(turno2);
        System.out.print("\n¿NOMBRE DEL JUGADOR 1?: ");
        String j1 = entrada.next();
        System.out.print("\n¿NOMBRE DEL JUGADOR 2?: ");
        String j2 = entrada.next();
        Tablero.dibujar(tablero, tablero2);
        Barcos(j1, turno, tablero2);
        System.out.println("\n"+j2.toUpperCase()+", presiona tecla ENTER para poner tus barcos\n");
        entrada.nextLine();
        for (int i = 0; i < 20; i++) {System.out.println("\n");}
        Tablero.dibujar(tablero, tablero2);
        Barcos(j2, turno2, tablero);
        int barcos1 = Top.cantidadB(turno);
        int barcos2 = Top.cantidadB(turno2);
        System.out.println("\n---presiona tecla ENTER para empezar el juego---\n");
        entrada.nextLine();
        for (int i = 0; i < 20; i++) {System.out.println("\n");}
        double quien = Math.random();
        int numero = 1;
        boolean realizado = false;
        boolean realizado2 = false;
        boolean terminar = false;
        int puntos1 = 200;
        int puntos2 = 200;        
        while (!terminar){
            if (quien >= 0.0 && quien <=0.5){
                Tablero.dibujar(turno, tablero2);
                System.out.println("\n***TURNO #"+numero+", " + j1.toUpperCase() + " , "+puntos1+" PUNTOS RESTANTES***\n");
                puntos1 = puntos1 + Barco.tiro(turno2, tablero2);
                Tablero.dibujar(turno, tablero2);
                System.out.println("\n---" + j2.toUpperCase() + ", Presiona tecla ENTER---\n");
                entrada.nextLine();
                for (int i=0;i<20;i++){System.out.println("\n");}
                quien = 2;
                realizado = true;
            }else {
                Tablero.dibujar(tablero, turno2);
                System.out.println("\n***TURNO #"+numero+", " + j2.toUpperCase() + " , "+puntos2+" PUNTOS RESTANTES***\n");
                puntos2 = puntos2 + Barco.tiro(turno, tablero);
                Tablero.dibujar(tablero, turno2);
                System.out.println("\n---" + j1.toUpperCase() + ", Presiona tecla ENTER---\n");
                entrada.nextLine();
                for (int i=0;i<20;i++){System.out.println("\n");}
                quien = 1;
                realizado2 = true;
            }
            if (realizado == true && realizado2 == true ){
                barcos1 = Top.cantidadB(turno);
                barcos2 = Top.cantidadB(turno2);
                numero++;
                realizado = false;
                realizado2 = false;
            }
            if (puntos1 <= 0 || barcos1 == 0){
                System.out.println("***¡"+j1.toUpperCase()+" PIERDE, FELICIDADES "+j2.toUpperCase()+"!***");
                System.out.println("***¡GANASTE LA PARTIDA CON "+puntos2+" PUNTOS!***");
                terminar = true;
            } else if (puntos2 <= 0 || barcos2 == 0){
                System.out.println("***¡"+j2.toUpperCase()+" PIERDE, FELICIDADES "+j1.toUpperCase()+"!***");
                System.out.println("***¡GANASTE LA PARTIDA CON "+puntos1+" PUNTOS!***");
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
            System.out.println("Barco #" + b);
            Barco.barco3(matriz1);
            Tablero.dibujar(matriz1, matriz2);
        }
        System.out.println("\n" + j.toUpperCase() + ", INGRESA 3 BARCOS DE 2 CASILLAS");
        for (int b = 1; b <= 3; b++) {
            System.out.println("Barco #" + b);
            Barco.barco2(matriz1);
            Tablero.dibujar(matriz1, matriz2);
        }
        System.out.println("\n" + j.toUpperCase() + ", INGRESA 4 BARCOS DE 1 CASILLA");
        for (int b = 1; b <= 4; b++) {
            System.out.println("Barco #" + b);
            Barco.barco1(matriz1);
            Tablero.dibujar(matriz1, matriz2);
        }
    }
}