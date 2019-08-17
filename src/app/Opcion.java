package app;

import java.util.Scanner;

class Opcion {
    private static Scanner entrada = new Scanner(System.in);

    public static int opciones() {
        int eleccion = 0;
        System.out.println("\nBatalla Naval v2.0");
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
        System.out.println("\n"+j2.toUpperCase()+", Presiona la tecla ENTER para poner tus barcos\n");
        entrada.nextLine();
        for (int i = 0; i < 20; i++) {System.out.println("\n");}
        Tablero.dibujar(tablero, tablero2);
        Barcos(j2, turno2, tablero);
        System.out.println("\n---Presiona tecla ENTER para empezar el juego---\n");
        entrada.nextLine();
        for (int i = 0; i < 20; i++) {System.out.println("\n");}
        double quien = Math.random();
        int numero = 1;
        boolean realizado = false;
        boolean realizado2 = false;
        boolean terminar = false;
        int puntos1 = 200;
        int puntos2 = 200;
        int aciertos1 = 0;
        int fallos1 = 0;
        int aciertos2 = 0;
        int fallos2 = 0;        
        int barcos1 = Top.cantidad(turno, "■");
        int barcos2 = Top.cantidad(turno2, "■");
        while (!terminar){
            if (quien >= 0.0 && quien <=0.5 && barcos1 != 0){
                Tablero.dibujar(turno, tablero2);
                System.out.println("\n***TURNO #"+numero+", " + j1.toUpperCase() + " , "+puntos1+" PUNTOS RESTANTES***\n");
                puntos1 = puntos1 + Barco.tiro(turno2, tablero2);
                Tablero.dibujar(turno, tablero2);
                System.out.println("\n---" + j2.toUpperCase() + ", Presiona tecla ENTER---\n");
                entrada.nextLine();
                for (int i=0;i<20;i++){System.out.println("\n");}
                barcos2 = Top.cantidad(turno2, "■");
                quien = 0.8;
                realizado = true;
            }
            if (quien > 0.5 && quien <= 1.0 && barcos2 != 0) {
                Tablero.dibujar(tablero, turno2);
                System.out.println("\n***TURNO #"+numero+", " + j2.toUpperCase() + " , "+puntos2+" PUNTOS RESTANTES***\n");
                puntos2 = puntos2 + Barco.tiro(turno, tablero);
                Tablero.dibujar(tablero, turno2);
                System.out.println("\n---" + j1.toUpperCase() + ", Presiona tecla ENTER---\n");
                entrada.nextLine();
                for (int i=0;i<20;i++){System.out.println("\n");}
                barcos1 = Top.cantidad(turno, "■");
                quien = 0.2;
                realizado2 = true;
            }
            if (realizado == true && realizado2 == true ){
                numero++;
                realizado = false;
                realizado2 = false;
            }
            if (puntos1 <= 0 || barcos1 == 0){
                System.out.println("***¡"+j1.toUpperCase()+" PIERDE, FELICIDADES "+j2.toUpperCase()+"!***");
                System.out.println("***¡GANASTE LA PARTIDA CON "+puntos2+" PUNTOS!***");
                aciertos1 = Top.cantidad( tablero2, ANSI.ROJO+"X"+ANSI.RESET+"");
                fallos1 = Top.cantidad( tablero2, ANSI.AZUL+"O"+ANSI.RESET+"");
                aciertos2 = Top.cantidad( tablero, ANSI.ROJO+"X"+ANSI.RESET+"");
                fallos2 = Top.cantidad( tablero, ANSI.AZUL+"O"+ANSI.RESET+"");
                Top.resultados(j2, puntos2, aciertos2 , fallos2, j1, puntos1, aciertos1, fallos1, tamanio);
                terminar = true;
            } else if (puntos2 <= 0 || barcos2 == 0){
                System.out.println("***¡"+j2.toUpperCase()+" PIERDE, FELICIDADES "+j1.toUpperCase()+"!***");
                System.out.println("***¡GANASTE LA PARTIDA CON "+puntos1+" PUNTOS!***");
                aciertos1 = Top.cantidad( tablero2, ANSI.ROJO+"X"+ANSI.RESET+"");
                fallos1 = Top.cantidad( tablero2, ANSI.AZUL+"O"+ANSI.RESET+"");
                aciertos2 = Top.cantidad( tablero, ANSI.ROJO+"X"+ANSI.RESET+"");
                fallos2 = Top.cantidad( tablero, ANSI.AZUL+"O"+ANSI.RESET+"");
                Top.resultados(j1, puntos1, aciertos1 , fallos1, j2, puntos2, aciertos2, fallos2, tamanio);
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
            System.out.println("--→Barco #" + b+"←--");
            Barco.barco3(matriz1);
            Tablero.dibujar(matriz1, matriz2);
        }
        System.out.println("\n" + j.toUpperCase() + ", INGRESA 3 BARCOS DE 2 CASILLAS");
        for (int b = 1; b <= 3; b++) {
            System.out.println("--→Barco #" + b+"←--");
            Barco.barco2(matriz1);
            Tablero.dibujar(matriz1, matriz2);
        }
        System.out.println("\n" + j.toUpperCase() + ", INGRESA 4 BARCOS DE 1 CASILLA");
        for (int b = 1; b <= 4; b++) {
            System.out.println("--→Barco #" + b+"←--");
            Barco.barco1(matriz1);
            Tablero.dibujar(matriz1, matriz2);
        }
    }
}