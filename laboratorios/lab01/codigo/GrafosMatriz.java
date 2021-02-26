import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
public class GrafosMatriz extends Grafo{
    Double[][] mat;
    
    public GrafosMatriz(int size, HashMap<Integer,Vertice> claves) {
        super(size, claves);
        mat = new Double[size+1][size+1];
        for(int i=1; i<=size; i++){

            mat[i][0] = (double)claves.get(i).getCodigo();
            mat[0][i] = (double)claves.get(i).getCodigo();
        }
    }

    public void addArc(int source, int destination, Peso weight) {

        mat[source][destination] = weight.getDistancia();
    }

    public ArrayList<Integer> getSuccessors(int vertex,HashMap<Integer,Vertice> mapa) {
        ArrayList<Integer> np= new ArrayList<>();
        for(int i=1; i<=size; i++){
            if(mat[vertex][i]!=  (double)0 ){
                np.add(mapa.get(i).getCodigo());
            }
        }	
        return np; 
    }

    public double getWeight(int source, int destination) {
        return mat[source][destination];
    }

    public void imprimirGrafo()
    {
        System.out.println(Arrays.deepToString(mat));
    }
}