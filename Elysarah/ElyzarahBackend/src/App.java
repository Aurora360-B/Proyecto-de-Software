import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        /*
         * Paciente p = new Paciente(0, "Cédula", "1004626436",
         * "Juan", "Villanueva", "3215627895", "juan.villanueva@gmail.com",
         * "Dosquebradas - Buenos Aires Cra: #24-54", "Nueva Esp");
         * PacienteDAO dao = new PacienteDAO();
         * dao.insertarPaciente(p);
         */

        /*
         * Medico m = new Medico(0, "Camila", "Villa", "3207089969",
         * 15205890, "camila.villa@medicos.com", 1);
         * MedicoDAO dao1 = new MedicoDAO();
         * dao1.insertarMedico(m);
         */

        /*
         * Cita nuevaCita = new Cita(
         * 1,
         * 1,
         * 1,
         * 2, Date.valueOf("2026-11-15"),
         * Time.valueOf("10:00:00"),
         * Time.valueOf("10:30:00"),
         * "Valoración inicial",
         * "Programada"
         * );
         * 
         * CitaDAO dao = new CitaDAO();
         * dao.agendarCita(nuevaCita);
         */

        /*
         * Consultorio nuevoConsultorio = new Consultorio("1", "105", "Sede Norte");
         * ConsultorioDAO consultorioDAO = new ConsultorioDAO();
         * consultorioDAO.insertarConsultorio(nuevoConsultorio);
         */

        /*
         * EspecialidadDAO dao = new EspecialidadDAO();
         * List<Especialidad> especialidades = dao.listarEspecialidades();
         * 
         * System.out.println("--- LISTA DE ESPECIALIDADES ---");
         * for (Especialidad esp : especialidades) {
         * System.out.println("ID: " + esp.getIdEspecialidad() + " - Nombre: " +
         * esp.getNombreEspecialidad());
         * 
         * }
         */

        HistorialAtencion nuevoHistorial = new HistorialAtencion(
                1, // id_cita (debe existir en tu tabla citas)
                java.sql.Date.valueOf("2026-11-15"),
                "Dolor de cabeza severo y mareos",
                "Migraña tensional",
                "Reposo y analgésicos cada 8 horas",
                "Paciente evoluciona favorablemente");

        HistorialAtencionDAO historialDAO = new HistorialAtencionDAO();
        historialDAO.registrarAtencion(nuevoHistorial);
    }

}
