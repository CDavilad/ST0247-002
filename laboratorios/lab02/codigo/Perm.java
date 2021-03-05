import java.util.*;

public class Perm
{
    public static void PermutacionSinRepConRecursionAUX(String loQueLlevo, String loQueMeFalta, ArrayList<String> list2,String condicion)
    {
        
        if(loQueMeFalta.length()==0)
        {
            list2.add(loQueLlevo+condicion);
            return;
        }
        for(int i =0;i<loQueMeFalta.length(); i++)
        {

            PermutacionSinRepConRecursionAUX(loQueLlevo+loQueMeFalta.charAt(i),loQueMeFalta.substring(0,i)+loQueMeFalta.substring(i+1),list2,condicion);

        } 
    }
    public static void PermutacionSinRepConRecursion(String APermutar, ArrayList<String> list2, String condicion)
    {

        PermutacionSinRepConRecursionAUX(condicion,APermutar,list2,condicion);
    
    }

    public static String TSPSolution(Grafo mapa, String start)
    {
        ArrayList<Integer> vertexes= mapa.getAllVertex();
        String vertexesTogether = "";
        for(int i=0; i<vertexes.size();i++)
        {
            if(!vertexes.get(i).toString().equals(start))
                vertexesTogether+=vertexes.get(i);
        }
        System.out.println(vertexesTogether);
        ArrayList<String> paths= new ArrayList<String>();
        PermutacionSinRepConRecursion(vertexesTogether, paths, start);
        int caminoMenorValor=Integer.MAX_VALUE;
        String caminoMenor=null;
        for(String camino : paths)
        {
            int caminoActual= probarCamino(camino, mapa);
            if(caminoActual<caminoMenorValor)
            {
                caminoMenor=camino;
                caminoMenorValor=caminoActual;
            }
        }
        return caminoMenor+" con valor "+caminoMenorValor;
    }

    public static int probarCamino(String camino, Grafo mapa)
    {
        int respuesta= 0;
        for(int i=0;i<camino.length()-1;i++)
        {
            respuesta+=mapa.getWeight(Character.getNumericValue(camino.charAt(i)),Character.getNumericValue(camino.charAt(i+1)));
        }
        return respuesta;
    }

}

