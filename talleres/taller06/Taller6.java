public class Taller6 {

	/**
	* Metodo que dado un entero n y un conjunto de denominciones de dinero
	* busque la manera optima de dar el cambio
	* @param n cantidad a devolver
	* @param denominaciones conjunto de denominaciones de dinero (monedas, billetes)
	* @return un conjunto de unidades por denominacion
	*/
	public static int[] cambioGreedy(int n, int[] denominaciones) {
        int solucion = 0;
        int[] res = new int[denominaciones.length]; 
        int i = 0;
        while (i <= denominaciones.length-1)
        {
            if (solucion == n) return res;
            else if (denominaciones[i] <= (n-solucion)) {
                solucion += denominaciones[i];
                res[i]++;
            } else {
                i++;
            }
        }
		return solucion == n? res : null;
	    }
	    public static int recorrido(Digraph g) {
		boolean[] visitados = new boolean[g.size()];
		int costo = 0;
		return recorrido(0, g, visitados, costo);
	    }


	    public static int recorrido(int v, Digraph g, boolean[] visitados, int costo){
		if(ok(visitados)){
		    return costo + g.getWeight(v,0);
		}
		ArrayList<Integer> sucesores = g.getSuccessors(v);
		int nodo = nodoPesoMinimo(sucesores, g, v, visitados);
		costo = costo + g.getWeight(v, nodo);
		visitados[v] = true;

		return recorrido(nodo, g, visitados, costo);
	    }


	    private static boolean ok(boolean[] szs){ 
		for(int i = 0; i<szs.length; i++){
		    if(!szs[i])return false;
		}
		return true;
	    }


	    public static int nodoPesoMinimo(ArrayList<Integer> sucesores, Digraph g, int v, boolean[] visitados){
		int pesominimo = Integer.MAX_VALUE;
		int nodo = 0;
		for(int i = 0; i < sucesores.size(); i++){
		    if(visitados[sucesores.get(i)] == false){
			if(pesominimo > g.getWeight(v, sucesores.get(i))){
			    pesominimo = g.getWeight(v, sucesores.get(i));
			    nodo = sucesores.get(i);
			}
		    }
		}
		return nodo;
	    }

}
