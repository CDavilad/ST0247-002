import java.util.LinkedList;

/**
 * Clase en la cual se implementan los metodos del Taller 2
 * 
 * @author Mauricio Toro, Camilo Paez, Cristian Davila
 */
public class Taller2 {
    public static void main(String[] args){
        LinkedList<String> lista = permutations("abc");
        for(String a : lista){
            System.out.println(a);
        }
    }

    public static void combinations(String s) { 
        LinkedList<String> list = new LinkedList<String>();
        combinationsAux("", s, list); 
    }

    private static void combinationsAux(String prefix, String s, LinkedList<String> list) {  
        if(s.length() >= 0) {
            list.add(prefix);
        }else {
            combinationsAux(prefix + s.charAt(0), s.substring(1), list);
            combinationsAux(prefix , s.substring(1), list);
        }
    }

    public static LinkedList<String> permutations(String s) {
        LinkedList<String> respuesta = new LinkedList<String>();
        permutations("", s, respuesta);
        return respuesta;
    }

    private static void permutations(String loQueLlevo, String loQueMeFalta, LinkedList<String> list) {
        if(loQueMeFalta.length() == 0){
            list.add(loQueLlevo);
        }else{
            for(int i = 0; i < loQueMeFalta.length(); i++){
                permutations(loQueLlevo+loQueMeFalta.charAt(i), loQueMeFalta.substring(0,i)+loQueMeFalta.substring(i+1,loQueMeFalta.length()),list);
            }
        }
    }

}
