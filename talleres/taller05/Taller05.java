public class Taller5 {
   
	/**
	* Metodo que dado un grafo y un numero m, se asigna un color
	* a cada nodo, de manera que dos nodos adyacentes no poseean el mismo color
	* @param g grafo dado 
	* @param m numero de colores
	* @return true si es posible, false de lo contrario
	*/
	public static boolean mColoring(Digraph g, int m) {
	    int[] colors;
	    colors = new int[m];
	    for(int i = 0; i<m; i++){
	        colors[i] = 0;
	       }
	       
	    if(!mColoring(g,0,colors,m)){
	        return false;
	    } 
	    return true;
	}

	/**
	* Metodo que dado un grafo y un vertice v, intenta asignar un color
	* al nodo, de manera que dos nodos adyacentes no poseean el mismo color
	* @param g grafo dado 
	* @param m numero de colores
	* @param v vertice 
	* @param colors conjunto de colores
	* @return true si es posible, false de lo contrario
	*/
	private static boolean mColoring(Digraph g, int v, int[] colors, int m) {
	    boolean answer = false;
	    if(v == m){
	        answer = true;
	    }
    	    for(int c = 1; c <=m; c++){
    	        if(isSafe(g, v, colors, c))
    	            colors[v] = c;
    	             if(mColoring(g, v+1, colors, m))
    	              answer = true;
    	            colors[v] = 0;
    	        }
    	    return false; 
	}

	/**
	* Metodo que dado un grafo y un vertice v, intenta asignar un color colors en la 
	* posicion c al nodo v, de manera que dos nodos adyacentes no poseean el mismo color
	* @param g grafo dado 
	* @param c indice de colores
	* @param v vertice 
	* @param colors conjunto de colores
	* @return true si es posible, false de lo contrario
	*/
	private static boolean isSafe(Digraph g, int v, int[] colors, int c) {
	   boolean answer = false;
    	    for(int i = 0; i<c ; i++){
    	        if(g.getWeight(v, i) == 1 && c == colors[i]){
    	            answer = false;
	       }
	       answer = true;
	   }
	   return answer;
        }
}
