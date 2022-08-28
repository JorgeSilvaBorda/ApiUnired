package unired.api.rendiciones;

public class TipoDia {
    private Integer esFeriado;
    private Integer esFinDeSemana;
    private Integer ayerFinDeSemanaOFeriado;
    
    public TipoDia(){
	
    }

    public TipoDia(Integer esFeriado, Integer esFinDeSemana, Integer ayerFinDeSemanaOFeriado) {
	this.esFeriado = esFeriado;
	this.esFinDeSemana = esFinDeSemana;
	this.ayerFinDeSemanaOFeriado = ayerFinDeSemanaOFeriado;
    }

    public Integer getEsFeriado() {
	return esFeriado;
    }

    public void setEsFeriado(Integer esFeriado) {
	this.esFeriado = esFeriado;
    }

    public Integer getEsFinDeSemana() {
	return esFinDeSemana;
    }

    public void setEsFinDeSemana(Integer esFinDeSemana) {
	this.esFinDeSemana = esFinDeSemana;
    }

    public Integer getAyerFinDeSemanaOFeriado() {
	return ayerFinDeSemanaOFeriado;
    }

    public void setAyerFinDeSemanaOFeriado(Integer ayerFinDeSemanaOFeriado) {
	this.ayerFinDeSemanaOFeriado = ayerFinDeSemanaOFeriado;
    }

        
}
