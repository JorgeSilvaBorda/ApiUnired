package unired.api.rendiciones;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class Proceso {

    private Integer idProceso;

    private String idEmpresa;

    @JsonProperty("nombreEmpresa")
    private String nombreEps;

    @JsonProperty("codEstado")
    private Integer estadoProceso;

    private LocalDateTime fechaProceso;

    private LocalDateTime fechaCreacion;

    private LocalDateTime inicioProceso;

    private LocalDateTime finProceso;

    private String fechaIso;

    @JsonProperty("idDefinicionArchivos")
    private Integer definicionArchivos_IdDefinicionArchivos;

    @JsonProperty("idUsuario")
    private String usuario_IdUsuario;

    public Proceso() {
    }

    public Proceso(Integer idProceso, String idEmpresa, String nombreEps, Integer estadoProceso, LocalDateTime fechaProceso, LocalDateTime fechaCreacion, LocalDateTime inicioProceso, LocalDateTime finProceso, String fechaIso, Integer definicionArchivos_IdDefinicionArchivos, String usuario_IdUsuario) {
	this.idProceso = idProceso;
	this.idEmpresa = idEmpresa;
	this.nombreEps = nombreEps;
	this.estadoProceso = estadoProceso;
	this.fechaProceso = fechaProceso;
	this.fechaCreacion = fechaCreacion;
	this.inicioProceso = inicioProceso;
	this.finProceso = finProceso;
	this.fechaIso = fechaIso;
	this.definicionArchivos_IdDefinicionArchivos = definicionArchivos_IdDefinicionArchivos;
	this.usuario_IdUsuario = usuario_IdUsuario;
    }

    public Integer getIdProceso() {
	return idProceso;
    }

    public void setIdProceso(Integer idProceso) {
	this.idProceso = idProceso;
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

    public Integer getEstadoProceso() {
	return estadoProceso;
    }

    public void setEstadoProceso(Integer estadoProceso) {
	this.estadoProceso = estadoProceso;
    }

    public LocalDateTime getFechaProceso() {
	return fechaProceso;
    }

    public void setFechaProceso(LocalDateTime fechaProceso) {
	this.fechaProceso = fechaProceso;
    }

    public LocalDateTime getFechaCreacion() {
	return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
	this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getInicioProceso() {
	return inicioProceso;
    }

    public void setInicioProceso(LocalDateTime inicioProceso) {
	this.inicioProceso = inicioProceso;
    }

    public LocalDateTime getFinProceso() {
	return finProceso;
    }

    public void setFinProceso(LocalDateTime finProceso) {
	this.finProceso = finProceso;
    }

    public String getFechaIso() {
	return fechaIso;
    }

    public void setFechaIso(String fechaIso) {
	this.fechaIso = fechaIso;
    }

    public Integer getDefinicionArchivos_IdDefinicionArchivos() {
	return definicionArchivos_IdDefinicionArchivos;
    }

    public void setDefinicionArchivos_IdDefinicionArchivos(Integer definicionArchivos_IdDefinicionArchivos) {
	this.definicionArchivos_IdDefinicionArchivos = definicionArchivos_IdDefinicionArchivos;
    }

    public String getUsuario_IdUsuario() {
	return usuario_IdUsuario;
    }

    public void setUsuario_IdUsuario(String usuario_IdUsuario) {
	this.usuario_IdUsuario = usuario_IdUsuario;
    }

    public String getEstado() {
	switch (this.estadoProceso) {
	    case 56:
		return "En Espera";
	    case 25:
		return "Pendiente";
	    case 26:
		return "En Ejecución";
	    case 27:
		return "Generado";
	    case 28:
		return "Transmitido";
	    case 29:
		return "Falla en el Proceso";
	    case 40:
		return "Enviado a Mail";
	    case 4046:
		return "Rendición Vacía";
	    default:
		return "";
	}
    }

    public String getTipoEstado() {
	switch (this.estadoProceso) {
	    case 56:
		return "Transitorio";
	    case 25:
		return "Transitorio";
	    case 26:
		return "Transitorio";
	    case 27:
		return "Exitoso";
	    case 28:
		return "Transitorio";
	    case 29:
		return "Error";
	    case 40:
		return "Exitoso";
	    case 4046:
		return "Exitoso";
	    default:
		return "";
	}
    }
}
