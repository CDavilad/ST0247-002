import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.*;
import java.util.Map.Entry;
public class Main
{
    public static String[][] leerDatos(String archivo) throws IOException 
    {
        Scanner scan = new Scanner(archivo);
        String x = scan.nextLine();
        List<String[]> rowList = new ArrayList<String[]>();
        try (BufferedReader br = new BufferedReader(new FileReader(x))) 
        {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineItems = line.split(";");
                rowList.add(lineItems);
            }
            br.close();
        }
        catch(Exception e){
            // Handle any I/O problems
        }
        String[][] matrix = new String[rowList.size()][];
        for (int i = 0; i < rowList.size(); i++) {
            String[] row = rowList.get(i);
            matrix[i] = row;

        }
        scan.close();
        return matrix;
    }

    public static Grafo makeMap() throws IOException
    {
        System.out.println("Vertices");
        System.out.println("Ingrese el archivo a leer");
        Scanner scan = new Scanner(System.in);
        String vertices= scan.nextLine();
        String[][] matrix =leerDatos(vertices);
        System.out.println("Aristas");
        System.out.println("Ingrese el archivo a leer");
        String aristas= scan.nextLine();
        String[][] matrix2 =leerDatos(aristas);
        HashMap<Integer,Vertice> claves = new HashMap<Integer,Vertice>();
        for (int i=0;i<matrix.length;i++)
        {
            Vertice x=new Vertice();
            for(int j=0;j<matrix[0].length;j++)
            {
                if(j==0)
                {
                    x.setCodigo(Integer.parseInt(matrix[i][j]));
                }
                if(j==1)
                {
                    x.setCoordenadaX(Double.parseDouble(matrix[i][j]));
                }
                if(j==2)
                {
                    x.setCoordenadaY(Double.parseDouble(matrix[i][j]));
                }
                if(j==3)
                {
                    x.setNombre(matrix[i][j]);
                }
            }
            claves.put(i+1,x);

        }
        Grafo mapaCiudad = new GrafosMatriz(matrix.length,claves);
        for(int i=0;i<matrix2.length;i++)
        {
            int source=0;
            int destination=0;
            for (int key: claves.keySet()) {
                if(claves.get(key).getCodigo()== Integer.parseInt(matrix2[i][0]))
                {
                    source = key;
                }
                else if((claves.get(key).getCodigo()== Integer.parseInt(matrix2[i][1])))
                {
                    destination= key;
                }
            }
            mapaCiudad.addArc(source, destination, new Peso(Integer.parseInt(matrix2[i][0]), Integer.parseInt(matrix2[i][1]), Double.parseDouble(matrix2[i][2])));
        }
        return mapaCiudad;
    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Metodo principal del programa
     * @param args un array de argumentos
     */
    public static void main(String[] args) throws IOException
    {
        Grafo mapaCiudad =makeMap();
        mapaCiudad.imprimirGrafo();
    }
}
