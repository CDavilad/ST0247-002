
import java.util.List;
import java.util.HashMap;
/**
 * Clase abstracta para la implementacion de grafos dirigidos
 * recordar los usos de clase abstracta 
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html"> Abstract </a>
 *
 * @author Mauricio Toro, Camilo Paez
 */
public abstract class Grafo {
	protected int size;
	
	protected Grafo(int vertices, HashMap claves) {
		size = vertices;
	}

	public abstract void addArc(int source, int destination, Peso weight);

	public abstract List<Integer> getSuccessors(int vertex,HashMap<Integer,Vertice> mapa);

	public abstract double getWeight(int source, int destination);

	public int size() {
		return size;
	}
	
	public abstract void imprimirGrafo();
}