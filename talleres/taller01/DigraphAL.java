import java.util.LinkedList;
import java.util.ArrayList;
public class DigraphAL extends Digraph{
    ArrayList<LinkedList<Pair<Integer,Integer>>> Lista = new ArrayList<LinkedList<Pair<Integer,Integer>>>();
    public DigraphAL(int size) {
        super(size);
        for (int i = 1; i < size + 1; i++) {
            Lista.add(new LinkedList<Pair<Integer,Integer>>());
        }
    }

    public void addArc(int source, int destination, int weight) {
        Lista.get(source).add(new Pair<Integer,Integer>(destination,weight));
    }

    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> np= new ArrayList<>();
        Lista.get(vertex).forEach(i->np.add(i.getElement0()));
        return np;
    }

    public int getWeight(int source, int destination) {
        int result = 0;
        for(int i=0; i<=Lista.get(source).size();i++)
        {
            if(Lista.get(source).get(i).getElement0()==destination)
            {
                result = Lista.get(source).get(i).getElement1();
            }

        }
        return result;

    }

}