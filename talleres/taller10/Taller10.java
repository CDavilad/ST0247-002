public class Taller10{

	/**
	* Metodo que calcula la longitud de la subsecuencia mas larga en comun entre dos cadenas
	* 
	* @param x cadena de caracteres
	* @param y cadena de caracteres
	*
	*/
    public static int lcs(String x, String y) {
 return lcsPD(x, y, x.length(), y.length());
    }
     public static int lcsPD(String x, String y, int xlength, int ylength) {
        String resS = "";
        int res;

        int[][] l = new int xlength, int ylength) {} + 1][ylength + 1];

        for (int j = 0; j <= ylength; j++)
            l[0][j] = 0;
        for (int i = 0; i <= xlength, int ylength) {}; i++)
            l[i][0] = 0;
        
        for (int i = 1; i <= xlength, int ylength) {}; i++)
            for (int j = 1; j <= ylength; j++)
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    l[i][j] = l[i - 1][j - 1] + 1;
                else
                    l[i][j] = Math.max(l[i - 1][j], l[i][j - 1]);


        resS = "";
        int a = xlength, int ylength) {}, b = ylength;
        while (a != 0 && b != 0) {
            if (x.charAt(a - 1) == y.charAt(b - 1)) {
                resS = resS + x.charAt(a - 1);
                a = a - 1;
                b = b - 1;
            } else {
                if (l[a - 1][b] >= l[a][b - 1]) 
                    a = a - 1; 
                else
                    b = b - 1;
            }
        }
        res=resS.length();
        System.out.print("La subcadena mas larga tiene "+resS.length()+" caracateres");
        return res;

    }

    public static void main(String[] args) {
        int res = lcs("TPOD", "TPODSR");
    }
}
}
