package unired.api.nominas;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ProcesoNomina {
    private String idEmpresa;
    private String codEmpresa;
    private String nomEmpresa;
    private String horaIni;
    private String horaFin;
    private LocalDateTime fechaProceso;
    private LocalDateTime fechaTermino;
    private Integer minutos;
    private Integer idEstado;
    private String estado;

    public ProcesoNomina() {
    }

    public ProcesoNomina(String idEmpresa, String codEmpresa, String nomEmpresa, String horaIni, String horaFin, LocalDateTime fechaProceso, LocalDateTime fechaTermino, Integer minutos, Integer idEstado, String estado) {
	this.idEmpresa = idEmpresa;
	this.codEmpresa = codEmpresa;
	this.nomEmpresa = nomEmpresa;
	this.horaIni = horaIni;
	this.horaFin = horaFin;
	this.fechaProceso = fechaProceso;
	this.fechaTermino = fechaTermino;
	this.minutos = minutos;
	this.idEstado = idEstado;
	this.estado = estado;
    }

    public String getIdEmpresa() {
	return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
	this.idEmpresa = idEmpresa;
    }

    public String getCodEmpresa() {
	return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
	this.codEmpresa = codEmpresa;
    }

    public String getNomEmpresa() {
	return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
	this.nomEmpresa = nomEmpresa;
    }

    public String getHoraIni() {
	return horaIni;
    }

    public void setHoraIni(String horaIni) {
	this.horaIni = horaIni;
    }

    public String getHoraFin() {
	return horaFin;
    }

    public void setHoraFin(String horaFin) {
	this.horaFin = horaFin;
    }

    public LocalDateTime getFechaProceso() {
	return fechaProceso;
    }

    public void setFechaProceso(LocalDateTime fechaProceso) {
	this.fechaProceso = fechaProceso;
    }

    public LocalDateTime getFechaTermino() {
	return fechaTermino;
    }

    public void setFechaTermino(LocalDateTime fechaTermino) {
	this.fechaTermino = fechaTermino;
    }

    public Integer getMinutos() {
	return minutos;
    }

    public void setMinutos(Integer minutos) {
	this.minutos = minutos;
    }

    public Integer getIdEstado() {
	return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
	this.idEstado = idEstado;
    }

    public String getEstado() {
	return estado;
    }

    public void setEstado(String estado) {
	this.estado = estado;
    }
    
    
}
