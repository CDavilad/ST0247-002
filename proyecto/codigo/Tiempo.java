/**
 * Write a description of class l here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tiempo
{
    double tFast;
    double tMedium;
    double tSlow;

    public Tiempo(double tSlow, double tMedium, double tFast){
        this.tSlow = tSlow;
        this.tMedium = tMedium;
        this.tFast = tFast;
    }

    public String toStringg(){
        return (tSlow + " " + tMedium + " " + tFast);
    }

    public double getTfast(){
      return tFast;
    }

    public double getTmedium(){
      return tMedium;
    }

    public double getTslow(){
      return tSlow;
    }
}
