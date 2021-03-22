
public class Reinas{
    public static boolean ponerReina(int[] tablero, int r,int c,int n){
        int x=0;
        for(int i=0;i<c;i++)
        {
            x=c-i;
            if(tablero[i]==r+x||tablero[i]==r-x)
            {
                return false;
            }  
        }
        return true;
    }

    public static  boolean PermutacionSinRepConRecursionAUX(String loQueLlevo, String loQueMeFalta,int n, boolean printed)
    {
        if(loQueMeFalta.length()==0)
        {
            System.out.println(loQueLlevo);
            return true;
        }
        int[] tablero= new int[n];
        for(int i =0;i<loQueMeFalta.length(); i++)
        {   

            for(int j=0;j<loQueLlevo.length();j++)
            {
                String juan = ""+loQueLlevo.charAt(j);
                tablero[j]=Integer.parseInt(juan);
            }

            String reina = loQueMeFalta.substring(i,i+1);
            int r = Integer.parseInt(reina); 
            if(ponerReina(tablero,r,loQueLlevo.length(),n))
            {

                if(PermutacionSinRepConRecursionAUX(loQueLlevo+loQueMeFalta.charAt(i),loQueMeFalta.substring(0,i)+loQueMeFalta.substring(i+1),n,printed ))
                {
                    return true;
                }
            }

        }
        return false;

    }

    public static void nReinas(int c, int n, int tablero[] ){
        String opciones= "";
        for(int i=1 ;i<=n;i++)
        {
            String p= Integer.toString(i);
            opciones= opciones+p;
        }
        PermutacionSinRepConRecursionAUX("", opciones,n,false);
    }

    public static void nReinas(int n){
        int[] tablero= new int[n];
        nReinas(0, n, tablero);
    }

    public static void main(String[] args) {
        nReinas(5);
    }
}
