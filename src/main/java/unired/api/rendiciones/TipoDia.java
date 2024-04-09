package unired.api.rendiciones;

import java.io.Serializable;

public class TipoDia implements Serializable {
    
    private Integer feriado;
    private Integer finSemana;
    private Integer ayerFeriado;
    
    public TipoDia(){
	
    }
    /*
    public TipoDia(@Param("feriado") int feriado, @Param("finSemana") int finSemana, @Param("ayerFeriado") int ayerFeriado) {
	this.feriado = feriado;
	this.finSemana = finSemana;
	this.ayerFeriado = ayerFeriado;
    }
    */
    /*
    public TipoDia(Integer feriado, Integer finSemana, Integer ayerFeriado, String comment) {
	this.feriado = feriado;
	this.finSemana = finSemana;
	this.ayerFeriado = ayerFeriado;
	this.comment = comment;
    }
    */
    public int getFeriado() {
	return feriado;
    }

    public void setFeriado(Integer feriado) {
	this.feriado = feriado;
    }

    public Integer getFinSemana() {
	return finSemana;
    }

    public void setFinSemana(Integer finSemana) {
	this.finSemana = finSemana;
    }

    public Integer getAyerFeriado() {
	return ayerFeriado;
    }

    public void setAyerFeriado(Integer ayerFeriado) {
	this.ayerFeriado = ayerFeriado;
    }        
    
}
