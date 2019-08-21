package app;

class PCN {
    public static void barra(int numero) {
        String poderes[] = { "NINGUNO", "KA BOOM", "ESCOGE", "NEBLINA", "ESCUDO" };
        if (numero > 0 && numero < 5) {
            System.out.print(" \u001b[1;31mP \u001b[1;33mO \u001b[32mD \u001b[1;35mE \u001b[36mR\u001B[0m [ "
                    + poderes[numero] + " ]");
        } else
            System.out.print(" PODER [ " + poderes[numero] + " ]");
    }

    public static void vida(int cantidad) {
        String HP[] = { ANSI.ROJO + "■ _ _ _" + ANSI.RESET, ANSI.ROJO + "■ ■ _ _" + ANSI.RESET,
                ANSI.ROJO + "■ ■ ■ _" + ANSI.RESET, ANSI.ROJO + "■ ■ ■ ■" + ANSI.RESET, };
        int p = (cantidad * 100)/20;
        String corazones = null;
        if (cantidad > 15)
            corazones = HP[3];
        else if (cantidad > 10)
            corazones = HP[2];
        else if (cantidad > 5)
            corazones = HP[1];
        else if (cantidad >= 1)
            corazones = HP[0];
        System.out.print("\nHP "+ANSI.AMA+p+"%"+ANSI.RESET+" [ " + corazones + " ]");
    }

    public static void mensaje(int mPCN) {
        String mensaje[] = { "", "¡PERO AHORA PUEDES HACER KA BOOM!", "¡PERO AHORA PUEDES ESCOGER UN PODER!",
                "¡PERO AHORA PUEDES ENVOLVERTE EN NEBLINA!", "¡PERO CONSEGUISTE UN ESCUDO!",
                "¡Y ADEMAS DEBES ESCOGER UN PODER PARA REGALAR A TU RIVAL!", "¡Y ADEMAS PIERDES 120 PUNTOS!",
                "!PERO DESPERTASTE A UN KRAKEN¡\n¡EL KRAKEN ATACA!", "¡PERO UN JUGADOR OBTIENE DADOS TRUCADOS!" };
        System.out.println(mensaje[mPCN]);
    }

    static int usar(int poder) {
        int usado = 0;
        switch (poder) {
        case 1:
            System.out.println("Aqui hariamos KA BOOM");
            usado = 7;
            break;
        case 2:
            System.out.println("Aqui podriamos escoger un poder");
            usado = 8;
            break;
        case 3:
            System.out.println("UNA DENSA NIEBLA CUBRE TU TABLERO...");
            usado = 9;
            break;
        case 4:
            System.out.println("Aquí podriamos usar un escudo");
            usado = 10;
            break;
        default:
            break;
        }
        return usado;
    }
}