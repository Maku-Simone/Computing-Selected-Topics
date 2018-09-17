package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Carlos Elliot
 */
public class Base {
            
    
    private Connection conn = null;
    private String nombr;
    private String p;
    private String idusr;
    private Statement estancia;
        
    public Connection conectar()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String DB, uss, pass;
            DB = "jdbc:mysql://localhost/noditos_guapos";
            uss = "root";
            pass = "";
            conn = DriverManager.getConnection(DB, uss, pass);
            System.out.println("Conexion exitosa");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
     public void cierraConexion() throws SQLException {
        this.conn.close();
    }    
     
      public ResultSet addRegla(int numero) throws SQLException 
           {
              Statement st = (Statement) conn.createStatement();
              return st.executeQuery("call add_regla('"+numero+"');");
           }
      public ResultSet addNodo(long nodo) throws SQLException 
           {
              Statement st = (Statement) conn.createStatement();
              return st.executeQuery("call add_nodo('"+nodo+"');");
           }      
      public ResultSet addPadre(long padre, long hijo) throws SQLException 
           {
              Statement st = (Statement) conn.createStatement();
              return st.executeQuery("call add_padre('"+padre+"', '"+hijo+"');");
           }
      public ResultSet existeNodo(long nodo) throws SQLException 
           {
              Statement st = (Statement) conn.createStatement();
              return st.executeQuery("call existe_Nodo('"+nodo+"')");
           }      
      public ResultSet existeRegla(int numero) throws SQLException 
           {
              Statement st = (Statement) conn.createStatement();
              return st.executeQuery("call existe_Regla('"+numero+"');");
           }     
}
