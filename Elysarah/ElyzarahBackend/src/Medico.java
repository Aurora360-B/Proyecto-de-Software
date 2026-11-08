package ElyzarahBackend.src;

public class Medico {
    private int id_medico;
    private String nombres; 
    private String apellidos;
    private String telefono;
    private int numero_licencia; 
    private String correo; 
    private int id_especialidad; 

    public Medico (){

    }

    public Medico(int id_medico, String nombres, String apellidos, String telefono, int numero_licencia, String correo,
            int id_especialidad) {
        this.id_medico = id_medico;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.numero_licencia = numero_licencia;
        this.correo = correo;
        this.id_especialidad = id_especialidad;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNumero_licencia() {
        return numero_licencia;
    }

    public void setNumero_licencia(int numero_licencia) {
        this.numero_licencia = numero_licencia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    

}
