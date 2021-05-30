import java.util.ArrayList;
import java.util.Collections;

public class Main{

    /**
     * Metodo que verifica si es posible poner las reinas hasta la columna c
     * 
     * @param  c hasta esta columna revisa
     * @param  tablero el tablero
     * @return true si es posible, false de lo contrario
     */	
    public static void main(String args[]){

     int[] a = nReinas(9);

     imprimirTablero(a);
    

    }


    private static boolean puedoPonerReina(int c, int[] tablero) {
        for(int i = 0; i<c ; i++){
            if(tablero[i]==tablero[c]){
                return false;
            }
            else if(Math.abs(c-i) == Math.abs(tablero[c]-tablero[i])){
                return false;

            }
        }
        return true;
    }

    /**
     * Metodo auxiliar para llamar el metodo posterior
     * 
     * @param  n numero de reinas
     * @return numero de soluciones
     */	
    public static int[] nReinas(int n) {
     int tablero[] = new int[n];

      boolean answer = nReinas(0, n, tablero);
        return tablero;
    }

    /**
     * Metodo devuelve el numero de soluciones que tiene el problema
     * 
     * @param  c columna
     * @param  n numero de reinas
     * @return numero de soluciones
     */	
    private static boolean nReinas(int c, int n, int[] tablero) {
        boolean done=false;
        if(c==n){
            return true;
        }
        else{
            for(int i = 0 ; i<n ; i++){
                tablero[c]=i;
              
                if(puedoPonerReina(c,tablero)){
                    done = done || nReinas(c+1,n,tablero);

                }
                if(done==true){
                  return done;
                }
            }
            return false;
        }
    }


    public static void imprimirTablero(int[] tablero) {
      if(tablero.length==2||tablero.length==3){
        System.out.print("Imposible");
        return;
      }
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i)
            System.out.print(i + " ");
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j)
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }

}
