package app;

class Top {
    public static int cantidadB(String matriz[][]){
        int cantidad = 0;
        for (int v = 0;v<matriz.length;v++){
            for(int h = 0;h<matriz.length;h++){
                if (matriz[v][h] == "■")
                    cantidad++;
            }
        }
        return cantidad;
    }
}