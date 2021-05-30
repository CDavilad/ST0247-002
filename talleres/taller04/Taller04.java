import java.util.ArrayList;

public class Taller4 {

    /**
     * Metodo auxiliar para llamar el metodo hayCaminoDFS posterior
     * @param g grafo dado 
     * @param v vertices 
     * @param w vertice
     * @return true si hay camino, false de lo contrario
     */
    public static boolean hayCaminoDFS(Digraph g, int v, int w) {
        boolean[] visitados = new boolean[g.size()];
        return hayCaminoDFS(g, v, w, visitados);
    }

    /**
     * Metodo que recorre el grafo por medio de dfs 
     * @param g grafo dado 
     * @param v vertices 
     * @param w vertice
     * @param visitados ayuda a tener un conteo acerca de que nodos han sido
     * o no visitados
     * @return true si hay camino, false de lo contrario
     */
    private static boolean hayCaminoDFS(Digraph g, int v, int w, boolean[] visitados) {
       ArrayList<Integer> siguiente = g.getSuccessors(v);
        visitados[v] = true;
        if(siguiente==null){
            return false;
        }
        if(w == v){
            return true;
        }
        
        if(siguiente.contains(w)){
            return true;}
        
        for(int i = 0; i<siguiente.size(); i++){
            if(!(visitados[siguiente.get(i)] == true)){
                if(hayCaminoDFS(g, siguiente.get(i), w, visitados)){
                    return true;
                }
            }

        }

        return false;
    }

    /*** Metodo que recorre el grafo por medio de dfs teniendo en cuenta que
     * se quiere encontrar el de menor costo
     * @param g grafo dado 
     * @param inicio nodo desde el cual empieza el recorrido 
     * @param fin nodo donde termina el recorrido
     * @return cual es el costo que tiene ir desde inicio a fin
     */
    public static ArrayList lowCostPathDFS(Graph g, int source, int destination){
        boolean [] checked = new boolean[g.size()+1];
        ArrayList<ArrayList<Integer>> ruta = new ArrayList();
        return lowCostPathAux(g, source, destination, checked, ruta);
    }

    private static ArrayList lowCostPathAux(Graph g, int source, int destination, boolean[] checked, ArrayList ruta){

                        ArrayList<Integer> next = g.getSuccessors(source);
        next.remove((Integer)source);
        
        checked[source] = true;
        boolean answer = false;

        
        if(destination == source){
            answer = true;
        }
        

        for(int neighbor: next){
            if(checked[neighbor] == false){
                Pair<ArrayList<Integer>, Integer> rutas = new Pair<source,destination>();
                ruta.set(1, ruta.get(1) + g.getWeight(source, neighbor));            
                rutas[0].append(source);
                answer =  lowCostPathAux(g, neighbor, destination, checked, ruta);               
            }
            if (answer == true){
              break;
            }
        }
        return answer;
    }
}
