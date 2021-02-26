
public class Peso {
    int codigoA;
    int codigoB;
    double distancia;

    public Peso()
    {
        codigoA=0;
        codigoB=0;
        distancia=0;
    }

    public Peso(int codigoA, int codigoB,double distancia)
    {
        this.codigoA=codigoA;
        this.codigoB= codigoB;
        this.distancia=distancia;

    }

    public int getCodigoA() {
        return codigoA;
    }

    public int getCodigoB() {
        return codigoB;
    }

    public double getDistancia() {
        return distancia;
    }
    
    public void setCodigoA(int codigoA) {
        this.codigoA = codigoA;
    }
    public void setCodigoB(int codigoB) {
        this.codigoB = codigoB;
    }
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}