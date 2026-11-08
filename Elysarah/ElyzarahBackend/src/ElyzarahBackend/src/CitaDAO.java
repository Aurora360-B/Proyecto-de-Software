package ElyzarahBackend.src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CitaDAO {

    public boolean agendarCita(Cita cita) {
        String sql = "INSERT INTO citas (id_paciente, id_medico, id_consultorio, fecha, hora_inicio, hora_fin, motivo_consulta, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conexion = Conexion_Data.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            pstmt.setInt(1, cita.getIdPaciente());
            pstmt.setInt(2, cita.getIdMedico());
            pstmt.setInt(3, cita.getIdConsultorio());
            pstmt.setDate(4, cita.getFecha());
            pstmt.setTime(5, cita.getHoraInicio());
            pstmt.setTime(6, cita.getHoraFin());
            pstmt.setString(7, cita.getMotivoConsulta());
            pstmt.setString(8, cita.getEstado());
            
            pstmt.executeUpdate();
            System.out.println("¡Cita agendada con éxito en la base de datos!");
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al agendar la cita: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
