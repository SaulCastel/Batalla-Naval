package app;

public class Menu {

    static boolean salir = false;
    static int opcion = 0;
    public static void main(String[] args) {
        while(!salir){
            opcion = Opcion.opciones();
            switch (opcion) {
                case 1:
                    Opcion.partida();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.print("\nSAUL ESTEBAN CASTELLANOS UBEDA\n");
                    System.out.print("\nREGISTRO ESTUDIANTIL: 201801178\n");
                    System.out.print("\nSECCION C\n");
                    break;
                case 8:
                    System.out.print("\n¡Hasta pronto!\n");
                    salir = true;
                    break;
                default:
                    salir = true;
                    break;
            }
        }
    }
}
