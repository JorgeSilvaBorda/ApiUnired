package unired.api.conciliacion;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProcesoConciliacion {
    private Integer idLogSistema;
    private String idEmpresa;
    private String nombreEps;
    private LocalDateTime fechaHoraCreacion;
    private LocalDate fechaCreacion;
    private String horaCreacion;
    private Integer idTipoLog;
    private String descripcionLog;

    public ProcesoConciliacion() {
    }

    public ProcesoConciliacion(Integer idLogSistema, String idEmpresa, String nombreEps, LocalDateTime fechaHoraCreacion, LocalDate fechaCreacion, String horaCreacion, Integer idTipoLog, String descripcionLog) {
        this.idLogSistema = idLogSistema;
        this.idEmpresa = idEmpresa;
        this.nombreEps = nombreEps;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.fechaCreacion = fechaCreacion;
        this.horaCreacion = horaCreacion;
        this.idTipoLog = idTipoLog;
        this.descripcionLog = descripcionLog;
    }

    public Integer getIdLogSistema() {
        return idLogSistema;
    }

    public void setIdLogSistema(Integer idLogSistema) {
        this.idLogSistema = idLogSistema;
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

    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(String horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    public Integer getIdTipoLog() {
        return idTipoLog;
    }

    public void setIdTipoLog(Integer idTipoLog) {
        this.idTipoLog = idTipoLog;
    }

    public String getDescripcionLog() {
        return descripcionLog;
    }

    public void setDescripcionLog(String descripcionLog) {
        this.descripcionLog = descripcionLog;
    }
    
    
}
