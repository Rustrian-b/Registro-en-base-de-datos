package modelo;

/**
 *
 * @author H4HG
 */
public class clsProducto 
{
    int vCodigo = 0;
    String vNombre;
    int vCantidad = 0;
    float vPrecio = 0;

    public clsProducto() 
    {
    }
    
    public String getvNombre() {
        return vNombre;
    }

    public void setvNombre(String vNombre) {
        this.vNombre = vNombre;
    }

    public int getvCantidad() {
        return vCantidad;
    }

    public void setvCantidad(int vCantidad) {
        this.vCantidad = vCantidad;
    }

    public float getvPrecio() {
        return vPrecio;
    }

    public void setvPrecio(float vPrecio) {
        this.vPrecio = vPrecio;
    }

    public int getvCodigo() {
        return vCodigo;
    }

    public void setvCodigo(int vCodigo) {
        this.vCodigo = vCodigo;
    }
    
    
}
