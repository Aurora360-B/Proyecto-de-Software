public class Consultorio {

    private int idConsultorio;
    private String numeroConsultorio;
    private String piso;
    private String descripcion;

    public Consultorio(){

    }

    public Consultorio(String numeroConsultorio, String piso, String descripcion) {
        this.numeroConsultorio = numeroConsultorio;
        this.piso = piso;
        this.descripcion = descripcion;
    }

    public int getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(int idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public String getNumeroConsultorio() {
        return numeroConsultorio;
    }

    public void setNumeroConsultorio(String numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
