package unired.api.rendiciones;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class SubProceso {

    @JsonProperty("idSubProceso")
    private Integer idBitacora;
    
    private String descripcion;
    
    @JsonProperty("codEvento")
    private Integer eventosProceso;
    
    private LocalDateTime fechaCreacion;
    
    @JsonProperty("idProceso")
    private Integer procesos_IdProceso;

    public SubProceso() {
    }

    public SubProceso(Integer idBitacora, String descripcion, Integer eventosProceso, LocalDateTime fechaCreacion, Integer procesos_IdProceso) {
	this.idBitacora = idBitacora;
	this.descripcion = descripcion;
	this.eventosProceso = eventosProceso;
	this.fechaCreacion = fechaCreacion;
	this.procesos_IdProceso = procesos_IdProceso;
    }

    public Integer getIdBitacora() {
	return idBitacora;
    }

    public void setIdBitacora(Integer idBitacora) {
	this.idBitacora = idBitacora;
    }

    public String getDescripcion() {
	return descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public Integer getEventosProceso() {
	return eventosProceso;
    }

    public void setEventosProceso(Integer eventosProceso) {
	this.eventosProceso = eventosProceso;
    }

    public LocalDateTime getFechaCreacion() {
	return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
	this.fechaCreacion = fechaCreacion;
    }

    public Integer getProcesos_IdProceso() {
	return procesos_IdProceso;
    }

    public void setProcesos_IdProceso(Integer procesos_IdProceso) {
	this.procesos_IdProceso = procesos_IdProceso;
    }
    
    public String getNomEvento(){
	switch(this.eventosProceso){
	    case 30: return "Inicio del Proceso";
	    case 31: return "Extrae datos especiales de la EPS";
	    case 32: return "Ejecuta Filtro de Rendición para EPS";
	    case 33: return "Se ha dejado el Archivo de Rendición en el FTP Interno";
	    case 34: return "Inicio y Fin de envío a casillas FTP o Mail";
	    case 57: return "Término de Proceso para la EPS y envío de Correo";
	    case 58: return "Inicio generación de archivo genérico y depósito del mismo en carpeta genérica del servidor interno";
	    case 59: return "Error del proceso";
	    default: return "";
	}
    }
    
    
}
