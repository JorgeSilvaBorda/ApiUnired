package unired.api.nominas;

public class ProcesosNomina {
    private Integer total;
    private Integer exitoso;
    private Integer error;
    private Integer noRecibida;
    private Integer sinProcesar;
    private Integer parcialmente;
    private Integer noCumple;
    private Integer pendiente;
    private Integer ejecutados;

    public ProcesosNomina() {
    }

    public ProcesosNomina(Integer total, Integer exitoso, Integer error, Integer noRecibida, Integer sinProcesar, Integer parcialmente, Integer noCumple, Integer pendiente, Integer ejecutados) {
	this.total = total;
	this.exitoso = exitoso;
	this.error = error;
	this.noRecibida = noRecibida;
	this.sinProcesar = sinProcesar;
	this.parcialmente = parcialmente;
	this.noCumple = noCumple;
	this.pendiente = pendiente;
	this.ejecutados = ejecutados;
    }
    
    public Integer getTotal() {
	return total;
    }

    public void setTotal(Integer total) {
	this.total = total;
    }

    public Integer getExitoso() {
	return exitoso;
    }

    public void setExitoso(Integer exitoso) {
	this.exitoso = exitoso;
    }

    public Integer getError() {
	return error;
    }

    public void setError(Integer error) {
	this.error = error;
    }

    public Integer getNoRecibida() {
	return noRecibida;
    }

    public void setNoRecibida(Integer noRecibida) {
	this.noRecibida = noRecibida;
    }

    public Integer getSinProcesar() {
	return sinProcesar;
    }

    public void setSinProcesar(Integer sinProcesar) {
	this.sinProcesar = sinProcesar;
    }

    public Integer getParcialmente() {
	return parcialmente;
    }

    public void setParcialmente(Integer parcialmente) {
	this.parcialmente = parcialmente;
    }

    public Integer getNoCumple() {
	return noCumple;
    }

    public void setNoCumple(Integer noCumple) {
	this.noCumple = noCumple;
    }

    public Integer getPendiente() {
	return pendiente;
    }

    public void setPendiente(Integer pendiente) {
	this.pendiente = pendiente;
    }

    public Integer getEjecutados() {
	return ejecutados;
    }

    public void setEjecutados(Integer ejecutados) {
	this.ejecutados = ejecutados;
    }

    
}
