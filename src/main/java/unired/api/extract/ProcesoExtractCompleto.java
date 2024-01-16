package unired.api.extract;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProcesoExtractCompleto {
    private LocalDate fechaProceso;
    
    private LocalDateTime fechaHoraIniProceso;
    private String horaIniProceso;
    private Integer idEstadoIniProceso;
    private String descEstadoIniProceso;
    
    private LocalDateTime fechaHoraFinProceso;
    private String horaFinProceso;
    private Integer idEstadoFinProceso;
    private String descEstadoFinProceso;

    public ProcesoExtractCompleto() {
    }
    
    

    public ProcesoExtractCompleto(LocalDate fechaProceso, LocalDateTime fechaHoraIniProceso, String horaIniProceso, Integer idEstadoIniProceso, String descEstadoIniProceso, LocalDateTime fechaHoraFinProceso, String horaFinProceso, Integer idEstadoFinProceso, String descEstadoFinProceso) {
        this.fechaProceso = fechaProceso;
        this.fechaHoraIniProceso = fechaHoraIniProceso;
        this.horaIniProceso = horaIniProceso;
        this.idEstadoIniProceso = idEstadoIniProceso;
        this.descEstadoIniProceso = descEstadoIniProceso;
        this.fechaHoraFinProceso = fechaHoraFinProceso;
        this.horaFinProceso = horaFinProceso;
        this.idEstadoFinProceso = idEstadoFinProceso;
        this.descEstadoFinProceso = descEstadoFinProceso;
    }

    public LocalDate getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(LocalDate fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public LocalDateTime getFechaHoraIniProceso() {
        return fechaHoraIniProceso;
    }

    public void setFechaHoraIniProceso(LocalDateTime fechaHoraIniProceso) {
        this.fechaHoraIniProceso = fechaHoraIniProceso;
    }

    public String getHoraIniProceso() {
        return horaIniProceso;
    }

    public void setHoraIniProceso(String horaIniProceso) {
        this.horaIniProceso = horaIniProceso;
    }

    public Integer getIdEstadoIniProceso() {
        return idEstadoIniProceso;
    }

    public void setIdEstadoIniProceso(Integer idEstadoIniProceso) {
        this.idEstadoIniProceso = idEstadoIniProceso;
    }

    public String getDescEstadoIniProceso() {
        return descEstadoIniProceso;
    }

    public void setDescEstadoIniProceso(String descEstadoIniProceso) {
        this.descEstadoIniProceso = descEstadoIniProceso;
    }

    public LocalDateTime getFechaHoraFinProceso() {
        return fechaHoraFinProceso;
    }

    public void setFechaHoraFinProceso(LocalDateTime fechaHoraFinProceso) {
        this.fechaHoraFinProceso = fechaHoraFinProceso;
    }

    public String getHoraFinProceso() {
        return horaFinProceso;
    }

    public void setHoraFinProceso(String horaFinProceso) {
        this.horaFinProceso = horaFinProceso;
    }

    public Integer getIdEstadoFinProceso() {
        return idEstadoFinProceso;
    }

    public void setIdEstadoFinProceso(Integer idEstadoFinProceso) {
        this.idEstadoFinProceso = idEstadoFinProceso;
    }

    public String getDescEstadoFinProceso() {
        return descEstadoFinProceso;
    }

    public void setDescEstadoFinProceso(String descEstadoFinProceso) {
        this.descEstadoFinProceso = descEstadoFinProceso;
    }
    
    
    
}
