import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultorioDAO {

    public boolean insertarConsultorio(Consultorio consultorio) {
        String sql = "INSERT INTO consultorios (numero, piso, sede) VALUES (?, ?, ?)";
        
        try (Connection conexion = Conexion_Data.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            pstmt.setString(1, consultorio.getNumeroConsultorio());
            pstmt.setString(2, consultorio.getPiso());
            pstmt.setString(3, consultorio.getDescripcion());
            
            pstmt.executeUpdate();
            System.out.println("¡Consultorio registrado con éxito en la base de datos clinica_citas!");
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar el consultorio: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
