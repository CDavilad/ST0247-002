class Taller07{

	public static void main(String[] args){
        Digraph g = new DigraphAM(8);
        g.addArc(0, 1, 20);
        g.addArc(0, 3, 80);
        g.addArc(0, 6, 90);
        g.addArc(1, 5, 10);
        g.addArc(2, 5, 50);
        g.addArc(2, 7, 20);
        g.addArc(2, 3, 10);
        g.addArc(3, 6, 20);
        g.addArc(4, 1, 50);
        g.addArc(4, 6, 30);
        g.addArc(5, 2, 10);
        g.addArc(5, 3, 40);
        g.addArc(6, 0, 20);
        Pair<int[], int[]> parejas = dijkstraMetodo(g,0);
        int[] d = parejas.getKey();
        int[] n = parejas.getValue();  
        for(int i = 0; i < g.size(); i++){
            System.out.println("la distancia "+ i+ " es " + d[i] + " viene del nodo "+ n[i]);
        }
    }
}
