
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteDAO {

  public boolean insertarPaciente(Paciente paciente) {
        String sql = "INSERT INTO pacientes (tipo_documento, numero_documento, nombres, apellidos, telefono, correo, direccion, eps) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conexion = Conexion_Data.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            pstmt.setString(1, paciente.getTipoDocumento());
            pstmt.setString(2, paciente.getNumeroDocumento());
            pstmt.setString(3, paciente.getNombres());
            pstmt.setString(4, paciente.getApellidos());
            pstmt.setString(5, paciente.getTelefono());
            pstmt.setString(6, paciente.getCorreo());
            pstmt.setString(7, paciente.getDireccion());
            pstmt.setString(8, paciente.getEps());
            
            pstmt.executeUpdate();
            System.out.println("¡Paciente registrado con éxito en la base de datos clinica_citas!");
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar el paciente: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    

}
