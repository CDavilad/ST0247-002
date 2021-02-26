public class Vertice {
    int codigo;
    double coordenadaX;
    double coordenadaY;
    String nombre;

    public Vertice()
    {
        codigo=0;
        coordenadaX=0;
        coordenadaY=0;
        nombre=null;
    }
    public Vertice(int codigo, double coordenadaX, double coordenadaY, String nombre)
    {
        this.codigo=codigo;
        this.coordenadaX=coordenadaX;
        this.coordenadaY=coordenadaY;
        this.nombre= nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }
    
    public double getCoordenadaY() {
        return coordenadaY;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }
    
    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
