package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author H4HG
 */
public class manejoBDD 
{
    static Connection c;
    static Statement s;
    static ResultSet r;
    
    public static void conectar()
    {
        String user = "USR_EXAMENFINAL";
        String password = "umg123";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            c = DriverManager.getConnection(url, user, password);
            s = c.createStatement();
        }catch(SQLException e)
        {
            System.out.println("Error al conectar a la base de datos");
        }catch(ClassNotFoundException ex)
        {
            Logger.getLogger(manejoBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void cerrar()
    {
        try
        {
            s.close();
            c.close();
        }catch(SQLException e)
        {
            System.out.println("Error al cerrar conexión con base de datos");
        }
    }
    
    public static void insertar(String pInstruccion)
    {
        try
        {
            conectar();
            s.executeQuery(pInstruccion);           
        }catch(SQLException e)
        {
            System.out.println("Error al insertar datos en la base de datos");
        }
    }
    
    public static void update(String pInstruccion)
    {
        try
        {
            conectar();
            s.executeQuery(pInstruccion);            
        }catch(SQLException e)
        {
            System.out.println("Error al Actualizar BDD");            
        }
    }
    
    public static ArrayList productosRegistrados()
    {
        ArrayList<clsProducto> lista = new ArrayList();
        String Query = "select codigo, nombre, saldo, precio from productos";
        conectar();
        
        try
        {
            s = c.prepareStatement(Query);
            r = s.executeQuery(Query);
            
            while(r.next())
            {
                clsProducto p = new clsProducto();
                p.setvCodigo(Integer.parseInt(r.getString(1)));
                p.setvNombre(r.getString(2));
                p.setvCantidad(Integer.parseInt(r.getString(3)));
                p.setvPrecio(Float.parseFloat(r.getString(4)));                
                lista.add(p);
            }                
        }catch(SQLException ex)
        {
            Logger.getLogger(manejoBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}