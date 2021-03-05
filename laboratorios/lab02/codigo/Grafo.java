import java.util.ArrayList;
public abstract class Grafo {
	protected int size;
	
	public Grafo(int vertices) {
		size = vertices;
	}

	public abstract void addArc(int source, int destination, int weight);

	public abstract ArrayList<Integer> getSuccessors(int vertex);
	
	public abstract int getWeight(int source, int destination);

	public abstract ArrayList<Integer> getAllVertex();

	public int size() {
		return size;
	}
}