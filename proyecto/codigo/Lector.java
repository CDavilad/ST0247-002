import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Lector{
    private static Scanner scan;
    cVehicle v;
    ArrayList<Coordenadas> c = new ArrayList<>();
    Coordenadas cor;
    ArrayList<Tiempo> time1 = new ArrayList<>();
    Tiempo timeL;
    ArrayList<Bateria> levelWatts1 = new ArrayList<>();
    Bateria LvlW;

    /**
     * El método leerDatos instancia la clase Dato y lee los datos del archivo uno por uno para
     * introducirlos en un array nuevo y lo retorna despues.
     * @return datos (lista de datos)
     */
    public void leer(String ruta){
        File archivo=null;
        try{
            archivo= new File(ruta);
            scan = new Scanner(archivo);
            ArrayList datosVehic = new ArrayList<>();
            ArrayList coordi = new ArrayList<>();
            ArrayList time = new ArrayList<>();
            ArrayList LevelWatts = new ArrayList<>();
            int state = 0;
            while(scan.hasNextLine()){
                String linea = scan.nextLine();
                if(linea == ""){
                    continue;
                }
                String arreglo[] = linea.split(" ");
                switch(state){
                    case 0:
                    if(!arreglo[0].equals("") && !arreglo[0].equals("Coordinates")){
                        datosVehic.add(Double.parseDouble(arreglo[2]));
                    }
                    if(arreglo[0].equals("Coordinates")){
                        this.v = crearVehiculo(datosVehic);
                        //datos.add(v);
                        state = 1;
                    }
                    break;
                    case 1: 
                    while(!linea.equals("") && !linea.equals("l")){
                        for(int i = 0; i<6; i++){
                            if(i == 1){
                                coordi.add(arreglo[i]);
                            } else if(i == 4){
                                coordi.add(arreglo[i]);
                            } else{
                                coordi.add(Double.parseDouble(arreglo[i]));
                            }
                        }
                        cor = asignarC(coordi);
                        coordi.clear();
                        c.add(cor);
                        break;
                    }
                    if(linea.equals("l")){
                        state = 2;
                    }
                    break;
                    case 2:
                    if(!linea.equals("")&&!linea.equals("g")){
                        for(int i = 1; i<4 ;i++){
                            time.add(Double.parseDouble(arreglo[i]));
                        }
                        timeL = asignarL(time);
                        time.clear();
                        time1.add(timeL);
                    }
                    if(linea.equals("g")){
                        state = 3;
                    }
                    break;
                    case 3:
                    if(!linea.equals("")){
                        for(int i = 1; i<4 ;i++){
                            LevelWatts.add(arreglo[i]);
                        }
                        LvlW = asignarBateria(LevelWatts);
                        LevelWatts.clear();
                        levelWatts1.add(LvlW);
                    }
                    break;
                }
            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            
        }
    }

    public static cVehicle crearVehiculo(ArrayList<Double> datosVehic){
        int n =  Integer.parseInt(String.valueOf(datosVehic.get(0)).replace(".0", ""));
        int m = Integer.parseInt(String.valueOf(datosVehic.get(1)).replace(".0", ""));
        int u = Integer.parseInt(String.valueOf(datosVehic.get(2)).replace(".0", ""));
        int breaks = Integer.parseInt(String.valueOf(datosVehic.get(3)).replace(".0", ""));
        double r = datosVehic.get(4);
        double speed = datosVehic.get(5);
        double Tmax = datosVehic.get(6);
        double Smax = datosVehic.get(7);
        double st_customer = datosVehic.get(8);
        double Q = datosVehic.get(9);

        cVehicle cVehiculo = new cVehicle(n, m, u, breaks, r, speed, Tmax, Smax, st_customer, Q);
        return cVehiculo;
    }

    public static Coordenadas asignarC(ArrayList<Integer> coordi){
        int idNode = Integer.parseInt(String.valueOf(coordi.get(0)).replace(".0", ""));
        String nNode = String.valueOf(coordi.get(1));   
        double x = Double.parseDouble(String.valueOf(coordi.get(2))); 
        double y = Double.parseDouble(String.valueOf(coordi.get(3))); 
        String tNode = String.valueOf(coordi.get(4));  
        int tStation = Integer.parseInt(String.valueOf(coordi.get(5)).replace(".0", ""));

        Coordenadas coordenadas = new Coordenadas(idNode, nNode, x, y, tNode, tStation);
        return coordenadas;
    }

    public static Tiempo asignarL(ArrayList<Double> time){
        double tSlow = Double.parseDouble(String.valueOf(time.get(0)));
        double tMedium = Double.parseDouble(String.valueOf(time.get(1)));
        double tFast = Double.parseDouble(String.valueOf(time.get(2)));
        Tiempo Tiempos = new Tiempo(tSlow, tMedium, tFast);
        return Tiempos;
    }

    public static Bateria asignarBateria(ArrayList<Integer> levelWatts){
        int bSlow = Integer.parseInt(String.valueOf(levelWatts.get(0)).replace(".0", ""));
        int bMedium = Integer.parseInt(String.valueOf(levelWatts.get(1)).replace(".0", ""));
        int bFast = Integer.parseInt(String.valueOf(levelWatts.get(2)).replace(".0", ""));
        Bateria Niveles = new Bateria(bSlow, bMedium, bFast);
        return Niveles;
    }

    public ArrayList<Coordenadas> getC(){
        return this.c;
    }
}
