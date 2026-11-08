import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadDAO {

    public boolean insertarEspecialidad(Especialidad especialidad) {
        String sql = "INSERT INTO especialidades (nombre_especialidad) VALUES (?)";
        
        try (Connection conexion = Conexion_Data.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            pstmt.setString(1, especialidad.getNombreEspecialidad());
            pstmt.executeUpdate();
            System.out.println("¡Especialidad registrada con éxito!");
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar la especialidad: " + e.getMessage());
            return false;
        }
    }

    // Método para consultar / listar todas las especialidades (SELECT)
    public List<Especialidad> listarEspecialidades() {
        List<Especialidad> lista = new ArrayList<>();
        String sql = "SELECT * FROM especialidades";
        
        try (Connection conexion = Conexion_Data.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Especialidad esp = new Especialidad();
                esp.setIdEspecialidad(rs.getInt("id_especialidad"));
                esp.setNombreEspecialidad(rs.getString("nombre_especialidad"));
                lista.add(esp);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al consultar las especialidades: " + e.getMessage());
        }
        
        return lista;
    }

}
