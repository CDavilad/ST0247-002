import java.util.*;
import java.io.*;

public class Principal
{
    static GrafoAM grafo;
    static boolean[] visitados;
    static boolean[] visitados1;
    static ArrayList<Integer> ruta = new ArrayList<>();
    static double nCarros = 0;
    static List<LinkedList<Integer>> rutasCarros = new ArrayList<LinkedList<Integer>>();
    static List<LinkedList<Double>> tCarros = new ArrayList<LinkedList<Double>>();
    static double tiempo = 0;
    static String name;
    public static void main(String[] args) throws IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        Scanner scan  = new Scanner(System.in); 
        System.out.println("Por favor, ingrese un archivo con las coordenadas");
        String archivo = scan.nextLine();
        Lector l1 = new Lector();
        ArrayList<Pair<Double, Double>> pNodo[];
        leerDatos(l1, archivo+".txt");
        ArrayList<Coordenadas> datos = l1.getC();
        Vehiculo v1 = l1.v;
        grafo = new GrafoAM(datos.size());
        visitados = new boolean[grafo.size];
        visitados1 = new boolean[grafo.size];
        visitados[0] = true;
        visitados1[0] = true;
        ruta.add(0);
        grafoDistanciaTiempo(datos, v1);
        getRuta(datos, v1);
        tiempo = calcularTiempo(datos, v1, ruta);
        generarCarros(v1.m);
        asignarRutas(ruta, ItoD(nCarros));
        boolean salir = false;
        while(!salir){
            try{
                int opcion = scan.nextInt();
                switch(opcion){
                    case 1:
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    imprimirRutas(ruta);
                    System.out.println("");
                    System.out.println("");
                    break;
                    case 2:
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    imprimirTiempo(tiempo);
                    System.out.println("");
                    System.out.println("");
                    break;
                    case 3:
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    imprimirCarros((ItoD(nCarros)));
                    System.out.println("");
                    System.out.println("");
                    break;
                    case 4:
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    imprimirRG(rutasCarros);
                    System.out.println("");
                    System.out.println("");
                    break;
                    case 5:
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    grafo.imprimir();
                    System.out.println("");
                    System.out.println("");
                    break;
                    case 6:
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    guardarArchivoCSV(datos);
                    System.out.println("");
                    System.out.println("");
                    break;
                    case 0:
                    salir = true;
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    
                    System.out.println("Fin de programa");
                    break;
                    default: 
                    System.out.println("Valor incorrecto");
                }
            }catch(InputMismatchException e){
                System.out.println("Valor Incorrecto");
                scan.next();
            }
        }
        //
        //imprimirTiempo();
        //imprimirCarros();
        //imprimirRG();

        //grafo.imprimir();
    }

    public static void guardarArchivoCSV(ArrayList<Coordenadas> datos)throws IOException{
        Scanner scan = new Scanner(System.in);
        File archivo=null;
        System.out.println("Inserte el nombre con el que guardara el archivo: ");
        String name=scan.next();
        int n = 0;
        try{
            archivo = new File(name+".csv");
            PrintStream guardado = new PrintStream(archivo);
            for(Coordenadas v: datos){
                guardado.print(v.getX() +  ";" + v.getY()+ ";"+ v.getTnode());
                guardado.println();
                n++;
            }
            System.out.println(n + " Coordenadas guardadas exitosamente.");
            guardado.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    } 

    public static int ItoD (double n){
        return Integer.parseInt(String.valueOf(n).replace(".0", ""));
    }

    public static Lector leerDatos(Lector l1, String rutaA){
        l1.leer("C:\\Users\\Cazadormas\\Downloads\\" + rutaA);
        return l1;
    }

    public static GrafoAM grafoDistanciaTiempo(ArrayList<Coordenadas> datos, Vehiculo v1){
        for(Coordenadas o: datos){
            for(Coordenadas m: datos){
                if(o == m){
                    continue;
                } else {
                    double distancia = Math.hypot((o.getX()-m.getX()),(o.getY()-m.getY()));
                    double time = distancia/v1.getSpeed();
                    grafo.addArc(o.getIdNode(),m.getIdNode(), distancia, time);
                }
            }
        } 
        return grafo;
    }

    public static ArrayList<Integer> getRuta(ArrayList<Coordenadas> datos, Vehiculo v1){
        int pivote = datos.get(0).getIdNode();
        for(int i = 0; i<v1.m;i++){
            int res = bestClient(pivote, datos);
            ruta.add(res);
            pivote = res;
        }   
        return ruta;
    }

    public static void imprimirTiempo(double tiempo){
        if(tiempo>24){
            double dias = tiempo/24;
            if(dias>30.28767){
                double meses = dias/30.28767;
                System.out.println("El tiempo estimado para esta ruta es: "+meses + " Meses");
            } else {
                System.out.println("El tiempo estimado para esta ruta es: "+dias + " Días");
            }
        } else {
            System.out.println("El tiempo estimado para esta ruta es: "+tiempo + " Horas");
        }
    }

    public static double calcularTiempo(ArrayList<Coordenadas> datos, Vehiculo v1, ArrayList<Integer> ruta){
        int pivote1= datos.get(0).getIdNode();
        double tiem = 0;
        double timp = 0;
        double tiempo0 = 0;
        for(int i = 0; i<v1.m;i++){
            tiem = generarTiempoTotal(pivote1, datos);
            pivote1 = ruta.get(i+1);
            tiempo0 = grafo.getTime(pivote1, 0);
            timp+=tiem;
        }         
        double tiempoTotal= timp+tiempo0;
        return tiempoTotal;
    }

    public static void imprimirRutas(ArrayList<Integer> rutas){
        String buffer = "{"; 
        for(Integer id: rutas){
            buffer = buffer + id + " -> ";
        }
        buffer = buffer + "0" + "}";
        System.out.println("La mejor ruta es: "+buffer);
    }

    public static double generarTiempoTotal(int idNodoInicial, ArrayList<Coordenadas> datos){
        double tiempoTotal = 0;
        int auxId = 0;
        for(Coordenadas o: datos){
            if(o.getIdNode() == idNodoInicial){
                continue;
            } else if((!visitados1[o.getIdNode()]) && (o.getTnode().equals("c"))){
                tiempoTotal += grafo.getTime(idNodoInicial, o.getIdNode()) + 0.5;
                auxId = o.getIdNode();
                break;
            }
        }
        visitados1[auxId]=true;
        return tiempoTotal;
    }

    public static int generarCarros(int numeroClientes){
        if(numeroClientes%2 == 0){
            if(numeroClientes<4){nCarros = 1;} 
            else { nCarros = Math.ceil(numeroClientes/4);}
        }else {nCarros = Math.ceil(numeroClientes/4);}
        return ItoD(nCarros);
    }

    public static void imprimirCarros(int n){
        System.out.println("El número de carros que usaremos para las entregas es: "+n);
    }

    public static int bestClient(int idNodoInicial, ArrayList<Coordenadas> datos){
        double auxTime = Integer.MAX_VALUE;
        int auxId = 0;
        for(Coordenadas o: datos){
            if(idNodoInicial == o.getIdNode()){
                continue;
            }else if(!visitados[o.getIdNode()] && (grafo.getTime(idNodoInicial, o.getIdNode())<auxTime) && o.getTnode().equals("c")){
                auxTime = grafo.getTime(idNodoInicial, o.getIdNode());
                auxId = o.getIdNode();

            }
        }        
        visitados[auxId]=true;
        return auxId;
    }

    public static double calcularTC(int source, int destination){
        double t = grafo.getTime(source, destination)+0.5;
        return t;
    }

    public static double Devuelvase(int source){
        double t = grafo.getTime(source, 0);
        return t;
    }

    public static double Comience(int destination){
        double t = grafo.getTime(0, destination)+0.5;
        return t;
    }

    public static List<LinkedList<Integer>> asignarRutas(ArrayList<Integer> rutas, int nCarros){
        int max = rutas.size()-1;
        int maxx = max+1;
        int k = 0;
        int j = 1; //Ruta
        double demora = 0;
        for(int i = 0; i<nCarros; i++){
            rutasCarros.add(new LinkedList<Integer>());
            tCarros.add(new LinkedList<Double>());
            demora = Comience(j);
            k = 0;
            while(k<4){
                if(max<4){
                    if(j == maxx){
                        break;
                    }
                    if(k<1){
                        demora += calcularTC(j, j+1);
                    } else {
                        demora += Devuelvase(j);
                    }
                    if(demora<10){
                        rutasCarros.get(i).add(rutas.get(j));
                    }
                    j++;
                    k++;
                } else if(max%2 == 0){
                    if(j == maxx){
                        break;
                    }
                    if(k<3){
                        demora+=calcularTC(j, j+1);
                    } else {
                        demora+= Devuelvase(j);
                    }
                    if(demora<10){
                        rutasCarros.get(i).add(rutas.get(j));}
                    k++;
                    j++;
                }

            }
            tCarros.get(i).add(demora);
            demora = 0;
        }
        return rutasCarros;
    }

    public static void imprimirRG(List<LinkedList<Integer>> rutasCarros){
        String buffer = "{Deposito -> "; 
        int nR = ruta.size()-1;
        for(int i = 0; i<nCarros;i++){
            if(nR <4){
                for(int j = 0; j<nR; j++){
                    buffer = buffer +rutasCarros.get(i).get(j) + " -> ";
                }
                int x = i+1;
                buffer = buffer + "Deposito" + "} " + "y su tiempo es: " + tCarros.get(i) + " Horas" ;
                System.out.println("La mejor ruta para el carro " + x + " es: " +buffer);
                buffer = "{Deposito -> ";  
            } else {
                for(int j = 0; j<4; j++){
                    buffer = buffer + rutasCarros.get(i).get(j) + " -> ";
                }
                int x = i+1;
                buffer = buffer + "Deposito" + "} " + "y su tiempo es: " + tCarros.get(i) + " Horas";
                System.out.println("La mejor ruta para el carro " + x + " es: " +buffer);
                buffer = "{Deposito -> "; }
        }
    }
}
