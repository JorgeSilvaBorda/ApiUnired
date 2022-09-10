package unired.api.rendiciones;

public class ProcesosNomina {
    private Integer exitoso;
    private Integer error;
    private Integer noRecibida;
    private Integer sinProcesar;
    private Integer parcialmente;
    private Integer noCumple;
    private Integer pendiente;

    public ProcesosNomina() {
    }

    public ProcesosNomina(Integer exitoso, Integer error, Integer noRecibida, Integer sinProcesar, Integer parcialmente, Integer noCumple, Integer pendiente) {
	this.exitoso = exitoso;
	this.error = error;
	this.noRecibida = noRecibida;
	this.sinProcesar = sinProcesar;
	this.parcialmente = parcialmente;
	this.noCumple = noCumple;
	this.pendiente = pendiente;
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
    
    
}
