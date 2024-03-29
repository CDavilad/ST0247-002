import java.util.ArrayList;
import javafx.util.Pair;
/**
 * Write a description of class dijkstra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dijkstra
{

    public static int[] distanciasInicializadas(Digraph g){
        int[] d = new int[g.size()];
        for(int i = 0; i < g.size(); i++){
            d[i] = Integer.MAX_VALUE;
        }
        d[0] = 0;
        return d;
    }

    public static int elegirNodoActual(Digraph g, int[] distancias, boolean[] visitados){
        int nodo = 0;
        int menor = Integer.MAX_VALUE;

        for(int i = 0; i < distancias.length; i++){
            if(!(visitados[i]) && (distancias[i] < menor)){
                menor = distancias[i];
                nodo = i;
            }
        }

        return nodo;
    }

    public static void actualizarDistancias(Digraph g, int[] distancias, int actual, int[]nodosAnterior){
        ArrayList<Integer> sucesores = g.getSuccessors(actual);
        int peso = 0;
        if(sucesores == null){
            
        }else{
            for(int i = 0; i < sucesores.size(); i++){
                peso = g.getWeight(actual, sucesores.get(i)) + distancias[actual];
                if(peso < distancias[sucesores.get(i)]){
                    distancias[sucesores.get(i)] = peso;
                    nodosAnterior[sucesores.get(i)] = actual;
                }
            }
        }
    }

    public static Pair<int[], int[]> dijkstraMetodo(Digraph g, int inicial){   
        int[] distancias = distanciasInicializadas(g);  
        int[] nodosAnterior = new int[g.size()];
        boolean[] losVisitados = new boolean[g.size()];

        for(int i = 1; i <= g.size(); i++){
            int actual = elegirNodoActual(g, distancias, losVisitados);
            actualizarDistancias(g, distancias, actual, nodosAnterior);
            losVisitados[actual] = true;
        }
        Pair<int[], int[]> pareja = new Pair<>(distancias, nodosAnterior);
        return pareja;
    } 
