import java.util.ArrayList;
//import javafx.util.Pair;
public class GrafoAM{
    int size;
    Pair<Double, Double>[][] matrix;
  
    public GrafoAM(int size) {
        this.size = size;
        matrix = new Pair[size][size];
        /**for(int i=0; i < size ; i++){
            for(int j=0; j < size; j++){
                matrix[i][j] = 0;
            }            
        }*/
    }

    public void addArc(int source, int destination, double distancia, double tiempo) {
        
        matrix[destination][source] = new Pair(distancia, tiempo);
        matrix[source][destination] = new Pair(distancia, tiempo);

    }

    public ArrayList<Integer> getSuccessors(int vertex) {

        ArrayList<Integer> s = new ArrayList<>();
        for (int i = 0; i < size; ++i)
            if (matrix[vertex][i].getFirst() != 0.)
                s.add(i);
        return s.size() == 0 ? null : s;
    }
    
    public int getSource(int source, int destination){
        return source;
    }
    
    public int getDesti(int source, int destination){
        return destination;
    }

    public double getDistace(int source, int destination) {
        return matrix[source][destination].getFirst();
    }
    
    public double getTime(int source, int destination) {
        return matrix[source][destination].getSecond();
    }

    public void imprimir(){
        for (int x=0; x < matrix.length; x++) {
            System.out.print("|");
            for (int y=0; y < matrix[x].length; y++) {
                System.out.print (matrix[x][y]);
                if (y!=matrix[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }
    }
}