public class Bateria
{
    int bSlow; 
    int bMedium; 
    int bFast;  
    public Bateria(int bSlow, int bMedium, int bFast){
        this.bFast = bFast;
        this.bSlow = bSlow;
        this.bMedium = bMedium;

    }

    public String toStringg(){
        return (bSlow + " " + bMedium + " " + bFast);
    }
    
    public int getBslow(){
        return bSlow;
    }
    public int getBmedium(){
        return bMedium;
    }
    public int getBfast(){
        return bFast;
    }
}
