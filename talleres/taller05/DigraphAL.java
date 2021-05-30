import javafx.util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;

public class DigraphAL extends Digraph {
    private ArrayList<LinkedList<Pair<Integer,Integer>>> graph;

    public DigraphAL(int size) {
        super(size);
        graph = new ArrayList<>();
        for (int i = 0; i < size+1; i++) {
            graph.add(new LinkedList<>());
        }
    }

    public void addArc(int source, int destination, int weight){
        graph.get(source).add(new Pair<>(destination,weight));
        graph.get(destination).add(new Pair<>(source,weight));//Esta linea genera un arco inverso, por lo que hace que a fin de cuentas el graph no sea dirigido
    }

    public int getWeight(int source, int destination) {
        int peso = 0;
        for (Pair<Integer, Integer> pareja : graph.get(source)) {
            if (pareja.getKey() == destination)
                peso = pareja.getValue();
        }
        return peso;
    }

    public ArrayList<Integer> getSuccessors(int vertice){
        ArrayList<Integer> sucesores = new ArrayList<>();
        graph.get(vertice).forEach(p -> sucesores.add(p.getKey())); //O(n)
        return sucesores;
    }
}
