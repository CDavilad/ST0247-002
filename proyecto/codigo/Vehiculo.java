public class Vehiculo
{
    int n; //Número total de nodos
    int m; //Número total de clientes
    int u; //Número total de estaciones de carga
    int breaks; //Número de puntos de soporte de la función de la carga de la batería
    double r; //Tasa de cosumo Watts/Km
    double speed; //Velocidad Km/h
    double Tmax; //Tiempo máximo de duración del vehículo en horas
    double Smax; //Tiempo máximo de carga en horas en la estación más lenta  
    double st_customer; //Tiempo en horas que se demora visitando un cliente
    double Q; //Capacidad de la bateria Watts/Hora

    
    public Vehiculo(int n, int m, int u, int breaks, double r, double speed, double Tmax, double Smax, double st_customer, double Q){
        this.n = n;
        this.m = m;
        this.u = u;
        this.breaks = breaks;
        this.r = r;
        this.speed = speed;
        this.Tmax = Tmax;
        this.Smax = Smax;
        this.st_customer = st_customer;
        this.Q = Q;
    }

    public int getN(){
        return n;
    }
    
    public int getM(){
        return m;
    }
    
    public int getU(){
        return u;
    }
    
    public int getBreaks(){
        return breaks;
    }
    
    public double getR(){
        return r;
    }
    
    public double getSpeed(){
        return speed;
    }
    
    public double getTmax(){
        return Tmax;
    }
    
    public double getSmax(){
        return Smax;
    }

    public double getSt_customer(){
        return st_customer;
    }
    
    public double getQ(){
        return Q;
    }
    
    public String toStringg(){
        return (n + " " + m + " " + u + " " + breaks + " " + r + " " + speed + " " + Tmax + " " + Smax + " " + st_customer + " " + Q);
    }
}
