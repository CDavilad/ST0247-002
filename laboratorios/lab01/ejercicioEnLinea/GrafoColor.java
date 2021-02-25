import java.util.*;
public class GrafoColor
{
    
    public static String descomponerGarras(Graph g){
        int [] coloreado = new int[g.size()+1];
        coloreado[1] = 1;
        return verificarBipartitoBFS(g, 1, coloreado, 2) ? "YES" : "NO";  
    }

    private static boolean verificarBipartitoBFS(Graph g, int source, int[] coloreado, int colorActual){
        ArrayList<Integer> next = g.getSuccessors(source);
        if(next.size() == 0){
            return true;
        }
        Queue<Integer> cola = new LinkedList<Integer>();
        boolean answer = true;      
        for(int neighbor: next){
            if(coloreado[neighbor] == 0){
                cola.add(neighbor);
                coloreado[neighbor] = colorActual;
            }
            else if(coloreado[neighbor] != colorActual){
                return false;
            }
        }
        colorActual = colorActual == 1 ? 2:1;
        while (cola.size() != 0){         
            int sig = (int)cola.poll();            
            answer =  answer && verificarBipartitoBFS(g, sig, coloreado, colorActual); //O(n^2)
            if(!answer){
                break;
            }
        }
        return answer;
    }

    public static void main(){        
        ArrayList<Graph> lg = Lector.leerDataset();
        for(Graph g : lg){
            System.out.println(descomponerGarras(g));
        }
    }
}
