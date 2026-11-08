import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HistorialAtencionDAO {

    public boolean registrarAtencion(HistorialAtencion historial) {
        String sql = "INSERT INTO historial_atencion (id_cita, fecha_registro, sintomas, diagnostico, tratamiento, observaciones) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conexion = Conexion_Data.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            pstmt.setInt(1, historial.getIdCita());
            pstmt.setDate(2, historial.getFechaAtencion());
            pstmt.setString(3, historial.getSintomas());
            pstmt.setString(4, historial.getDiagnostico());
            pstmt.setString(5, historial.getTratamiento());
            pstmt.setString(6, historial.getObservaciones());
            
            pstmt.executeUpdate();
            System.out.println("¡Historial de atención registrado con éxito!");
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al registrar el historial de atención: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
