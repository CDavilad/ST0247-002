public class Coordenadas
{
    int idNode; //Id del nodo
    String nNode; //Nombre del nodo
    double x; //Coordenadas en X
    double y; //Coordenadas en Y
    String tNode; //Tipo de nodo
    int tStation; //Tipo de estación

    public Coordenadas(){
    }
    public Coordenadas(int idNode, String nNode, double x, double y, String tNode, int tStation){
        this.idNode = idNode; 
        this.nNode = nNode;   
        this.x = x;  
        this.y = y;  
        this.tNode = tNode;  
        this.tStation = tStation; 
    }

    public String toStringg(){
        return (idNode + " " + nNode + " " + x + " " + y + " " + tNode + " " + tStation);
    }

    public int getIdNode(){
      return idNode;
    }

    public String getNnode(){
      return nNode;
    }

    public double getX(){
      return x;
    }

    public double getY(){
      return y;
    }
    
    public String getTnode(){
      return tNode;
    }

    public int getTstation(){
      return tStation;
    }
}
