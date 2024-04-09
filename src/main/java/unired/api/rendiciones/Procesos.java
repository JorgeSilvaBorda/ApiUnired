package unired.api.rendiciones;

public class Procesos {
    private Integer enEspera;
    private Integer pendiente;
    private Integer enEjecucion;
    private Integer generado;
    private Integer transmitido;
    private Integer fallaEnProceso;
    private Integer enviadoAMail;
    private Integer rendicionVacia;
    private Integer exitoso;
    private Integer total;

    public Procesos() {
    }

    public Procesos(Integer enEspera, Integer pendiente, Integer enEjecucion, Integer generado, Integer transmitido, Integer fallaEnProceso, Integer enviadoAMail, Integer rendicionVacia, Integer exitoso, Integer total) {
	this.enEspera = enEspera;
	this.pendiente = pendiente;
	this.enEjecucion = enEjecucion;
	this.generado = generado;
	this.transmitido = transmitido;
	this.fallaEnProceso = fallaEnProceso;
	this.enviadoAMail = enviadoAMail;
	this.rendicionVacia = rendicionVacia;
	this.exitoso = exitoso;
	this.total = total;
    }

    public Integer getEnEspera() {
	return enEspera;
    }

    public void setEnEspera(Integer enEspera) {
	this.enEspera = enEspera;
    }

    public Integer getPendiente() {
	return pendiente;
    }

    public void setPendiente(Integer pendiente) {
	this.pendiente = pendiente;
    }

    public Integer getEnEjecucion() {
	return enEjecucion;
    }

    public void setEnEjecucion(Integer enEjecucion) {
	this.enEjecucion = enEjecucion;
    }

    public Integer getGenerado() {
	return generado;
    }

    public void setGenerado(Integer generado) {
	this.generado = generado;
    }

    public Integer getTransmitido() {
	return transmitido;
    }

    public void setTransmitido(Integer transmitido) {
	this.transmitido = transmitido;
    }

    public Integer getFallaEnProceso() {
	return fallaEnProceso;
    }

    public void setFallaEnProceso(Integer fallaEnProceso) {
	this.fallaEnProceso = fallaEnProceso;
    }

    public Integer getEnviadoAMail() {
	return enviadoAMail;
    }

    public void setEnviadoAMail(Integer enviadoAMail) {
	this.enviadoAMail = enviadoAMail;
    }

    public Integer getRendicionVacia() {
	return rendicionVacia;
    }

    public void setRendicionVacia(Integer rendicionVacia) {
	this.rendicionVacia = rendicionVacia;
    }
    
    public Integer getExitoso() {
	return exitoso;
    }

    public void setExitoso(Integer exitoso) {
	this.exitoso = exitoso;
    }
    
    public Integer getTotal() {
	return total;
    }

    public void setTotal(Integer total) {
	this.total = total;
    }
    
    
}
