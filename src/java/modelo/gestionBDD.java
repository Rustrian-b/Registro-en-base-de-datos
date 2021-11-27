package modelo;

/**
 *
 * @author H4HG
 */
public class gestionBDD 
{
    public static void registroNuevoProducto(int pCodigo, String pNombre, int pCantidad, float pPrecio)
    {
        String vInstruccion="";
        vInstruccion = "insert into productos (codigo, nombre, saldo, precio) values ('" + pCodigo + "','" + pNombre + "','"  + pCantidad +   "','"   +   pPrecio +  "')";
        manejoBDD m = new manejoBDD();
        
        System.out.println(vInstruccion);
        
        m.insertar(vInstruccion);
    }
    
    public static int actualizacionProductos(int pCodigo, int pCantidad)
    {
        int resp = 1;
        String vInstruccion="";
        vInstruccion = "update productos set saldo = "+pCantidad+" where codigo = "+pCodigo+" ";
        manejoBDD m = new manejoBDD();
        
        System.out.println(vInstruccion);
        
        m.update(vInstruccion);
        return resp;
    }
}
