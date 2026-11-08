import java.sql.Time;
import java.util.Date;

import ElyzarahBackend.src.Cita;
import ElyzarahBackend.src.CitaDAO;
import ElyzarahBackend.src.Medico;
import ElyzarahBackend.src.MedicoDAO;
import ElyzarahBackend.src.Paciente;
import ElyzarahBackend.src.PacienteDAO;

public class App {
    public static void main(String[] args) throws Exception {

       /*Paciente p = new Paciente(0, "Cédula", "1004626436", 
       "Juan", "Villanueva", "3215627895", "juan.villanueva@gmail.com",
        "Dosquebradas - Buenos Aires Cra: #24-54", "Nueva Esp");   
        PacienteDAO dao = new PacienteDAO();
        dao.insertarPaciente(p); 
         */    



        /*Medico m = new Medico(0, "Camila", "Villa", "3207089969",
         15205890, "camila.villa@medicos.com", 1);
         MedicoDAO dao1 = new MedicoDAO();
         dao1.insertarMedico(m);*/

         Cita nuevaCita = new Cita(
            1, 
            1, 
            1, 
            Date.valueOf("2026-11-15"), 
            Time.valueOf("10:00:00"), 
            Time.valueOf("10:30:00"), 
            "Valoración inicial", 
            "Programada"
        );

        CitaDAO dao = new CitaDAO();
        dao.agendarCita(nuevaCita);
    }

    }

