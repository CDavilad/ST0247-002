import java.util.ArrayList;
import java.util.Arrays;
public class GrafosM extends Grafo{
    int[][] mat;
    
    public GrafosM(int size) {
        super(size);
        mat = new int[size+1][size+1];
        for(int i=1; i<=size; i++){

            mat[i][0] = i;
            mat[0][i] = i;
        }
    }

    public void addArc(int source, int destination, int weight) {
        mat[source][destination] = weight;
        mat[destination][source]=weight;
    }

    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> np= new ArrayList<>();
        for(int i=1; i<=size; i++){
            if(mat[vertex][i]!=  0 ){
                np.add(mat[0][i]);
            }
        }	
        return np; 
    }

    public int getWeight(int source, int destination) {
        return mat[source][destination];
    }

    public void imprimirGrafo()
    {
        System.out.println(Arrays.deepToString(mat));
    }

    public ArrayList<Integer> getAllVertex()
    {
        ArrayList<Integer> vertexes = new ArrayList<Integer>();
        for(int i=1;i<mat.length;i++)
        {
            vertexes.add(mat[0][i]);
        }
        return vertexes;
    }
}
