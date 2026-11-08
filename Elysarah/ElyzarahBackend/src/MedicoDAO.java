
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicoDAO {

    public boolean insertarMedico(Medico medico) {
        String sql = "INSERT INTO medicos (nombres, apellidos, numero_licencia, telefono, correo, id_especialidad) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conexion = Conexion_Data.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            pstmt.setString(1, medico.getNombres());
            pstmt.setString(2, medico.getApellidos());
            pstmt.setInt(3, medico.getNumero_licencia());
            pstmt.setString(4, medico.getTelefono());
            pstmt.setString(5, medico.getCorreo());
            pstmt.setInt(6, medico.getId_especialidad());
            
            pstmt.executeUpdate();
            System.out.println("¡Médico registrado con éxito en la base de datos clinica_citas!");
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar el médico: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
