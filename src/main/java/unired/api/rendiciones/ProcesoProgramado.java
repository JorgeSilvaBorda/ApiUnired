package unired.api.rendiciones;

public class ProcesoProgramado {
    private Integer idTarea;
    private String horaEjecucion;
    private String idEmpresa;
    private String nombreEps;

    public ProcesoProgramado() {
    }

    public ProcesoProgramado(Integer idTarea, String horaEjecucion, String idEmpresa, String nombreEps) {
	this.idTarea = idTarea;
	this.horaEjecucion = horaEjecucion;
	this.idEmpresa = idEmpresa;
	this.nombreEps = nombreEps;
    }

    public Integer getIdTarea() {
	return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
	this.idTarea = idTarea;
    }

    public String getHoraEjecucion() {
	return horaEjecucion;
    }

    public void setHoraEjecucion(String horaEjecucion) {
	this.horaEjecucion = horaEjecucion;
    }

    public String getIdEmpresa() {
	return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
	this.idEmpresa = idEmpresa;
    }

    public String getNombreEps() {
	return nombreEps;
    }

    public void setNombreEps(String nombreEps) {
	this.nombreEps = nombreEps;
    }
    
    
}
