import java.util.ArrayList;
import java.util.*;
import javafx.util.Pair;

public class Camino{
    LinkedList<Pair<Integer,Integer>> lista[];
    int tamano;
    public Camino(int tamano) {
        this.tamano = tamano;
        this.lista = new LinkedList[tamano];
    }

    public ArrayList<Integer> getSuccessors(int vertice) {
        ArrayList<Integer> sucesores = null;
        LinkedList<Pair<Integer, Integer>> filaSucesores = this.lista[vertice];
        if (filaSucesores != null){
            for(Pair p: filaSucesores){
                if(sucesores == null){
                    sucesores = new ArrayList<Integer>();
                }
                sucesores.add((Integer)p.getKey());  
            }            
        }        
        return sucesores;
    }
    
    public int getPeso(int init, int destino) {
        LinkedList<Pair<Integer,Integer>> listica = this.lista[init];
        int weigth = 0;
        for(Pair p : listica)
            if((int)p.getKey() == destino){
                weigth = (int)p.getValue();
            }
        return weigth;
    }
    
    public Pair<Integer,ArrayList> MejorCamino(int init, int destino, ArrayList camino){
        if(init==destino){
            ArrayList<Integer> copiaLista = (ArrayList<Integer>) camino.clone();
            return new Pair(distanciaCamino(camino), copiaLista);
        }
        ArrayList<Integer> sucesor = getSuccessors(init);
        int mejorDistancia = Integer.MAX_VALUE;
        ArrayList<Integer> mejorCamino = new ArrayList<>();
        for(Integer a : sucesor){
            if(camino.contains(a)){
                continue;
            }
            camino.add(a);  
            Pair<Integer,ArrayList> aux = MejorCamino((int)a, destino, camino);
            camino.remove(a);
            if(aux.getKey() < mejorDistancia){
                mejorDistancia = aux.getKey();
                mejorCamino = aux.getValue();
            }
        }
        return new Pair(mejorDistancia, mejorCamino);
    }

    public int distanciaCamino(ArrayList camino){
        int distancia = 0;
        if( camino.size() == 0){
            return 0;
        }
        for(int i = 0 ; i<camino.size()-1 ;i++){
            distancia += getPeso((int)camino.get(i), (int)camino.get(i+1));
        }
        return distancia;
    }

    public void addArc(int init, int destino, int peso) {
        if(lista[init]==null){
            lista[init] = new LinkedList();
        } 
        lista[init].add(new Pair(destino,peso));
    }
}