
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion_Data {

    private static final String URL = "jdbc:mysql://localhost:3306/clinica_citas?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "admin";

    public static Connection conectar () {
        Connection conexion = null; 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("¡Conexión exitosa a la base de datos clinica_citas!");
        } catch (ClassNotFoundException e){
            System.out.println("Error: No se encontró el driver JDBC de MySQL.");
        } catch (SQLException e){
            System.out.println("Error de SQL al conectar con la base de datos.");
            e.printStackTrace();
        }
        return conexion;
    }



}
