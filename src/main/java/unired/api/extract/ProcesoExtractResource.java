package unired.api.extract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/procesoextract")
public class ProcesoExtractResource {

    @Inject
    ProcesoExtractMapper mapper;

    /*
    @GET
    @Path("/resumen")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Integer> getExtractDiaActual() {

	List<ProcesoExtract> procesos = mapper.getExtractDiaActual();
	Integer programadosHoy = 0;
	Integer pendientes = 0;
	Integer enEjecucion = 0;
	Integer exitoso = 0;
	Integer error = 0;

	if (procesos.size() > 1) {
	    if (procesos.get(0).getIdTipoLog() == 2) {
		if (procesos.size() == 1) {
		    pendientes = 1;
		    enEjecucion = 1;
		    exitoso = 0;
		    error = 0;
		} else if (procesos.size() > 1) {
		    if (procesos.get(procesos.size() - 1).getIdTipoLog() == 6) {
			pendientes = 0;
			enEjecucion = 0;
			exitoso = 1;
			error = 0;
		    } else if (procesos.get(procesos.size() - 1).getIdTipoLog() == 4) {
			pendientes = 0;
			enEjecucion = 0;
			exitoso = 0;
			error = 1;
		    }
		}
		programadosHoy = 1;
	    }
	} else {
	    if (procesos.size() == 1) {
		if (procesos.get(0).getIdTipoLog() == 2) {
		    pendientes = 1;
		    enEjecucion = 1;
		    exitoso = 0;
		    error = 0;
		}
	    } else {
		pendientes = 0;
		enEjecucion = 0;
		exitoso = 0;
		error = 0;
	    }
	}

	Map<String, Integer> salida = new HashMap();

	salida.put("programadosHoy", programadosHoy);
	salida.put("pendientes", pendientes);
	salida.put("enEjecucion", enEjecucion);
	salida.put("exitoso", exitoso);
	salida.put("error", error);
	return salida;
	
    }
    */
    
    @GET
    @Path("/resumen")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Integer> getResumenDiaActual(){
	List<ProcesoExtract> procesos = mapper.getExtractDiaActual();
	Integer programadosHoy = 1;
	Integer pendientes = 0;
	Integer enEjecucion = 0;
	Integer exitoso = 0;
	Integer error = 0;
	
	Map<String, Integer> resumen = new HashMap(); //Campos de salida
	
	//Por defecto con todo en cero
	resumen.put("programadosHoy", programadosHoy);
	resumen.put("pendientes", pendientes);
	resumen.put("enEjecucion", enEjecucion);
	resumen.put("exitoso", exitoso);
	resumen.put("error", error);
	
	//No existen registros para la hora correspondiente
	if(procesos.size() == 0){
	    return resumen;
	}
	
	//Existe solo un registro. Revisar el estado para informar
	if(procesos.size() == 1){
	    if(procesos.get(0).getIdTipoLog() == 2){ //Es un registro de inicio de proceso
		resumen.put("programadosHoy", 1);
		resumen.put("pendientes", 1);
		resumen.put("enEjecucion", 1);
		return resumen;
	    }
	    
	    if(procesos.get(0).getIdTipoLog() == 6){//Es un registro de término exitoso
		resumen.put("programadosHoy", 1);
		resumen.put("exitoso", 1);
	    }
	    
	    if(procesos.get(0).getIdTipoLog() == 4){ //Es un registro de término de error
		resumen.put("programadosHoy", 1);
		resumen.put("error", 1);
	    }
	}
	
	//Existen exactamente dos registros
	if(procesos.size() == 2){
	    if(procesos.get(0).getIdTipoLog() == 2 && procesos.get(1).getIdTipoLog() == 4){ //Es un inicio normal y término de error
		resumen.put("programadosHoy", 1);
		resumen.put("error", 1);
	    }
	    
	    if(procesos.get(0).getIdTipoLog() == 2 && procesos.get(1).getIdTipoLog() == 6){ //Es un inicio normal y término con éxito
		resumen.put("programadosHoy", 1);
		resumen.put("exitoso", 1);
	    }
	    
	    if (procesos.get(0).getIdTipoLog() != 2 && procesos.get(1).getIdTipoLog() == 4){ //Es un término con Error, pero no cuenta con un inicio
		resumen.put("programadosHoy", 1);
		resumen.put("error", 1);
	    }
	    
	    if (procesos.get(0).getIdTipoLog() != 2 && procesos.get(1).getIdTipoLog() == 6){ //Es un término exitoso, pero no cuenta con un inicio
		resumen.put("programadosHoy", 1);
		resumen.put("exitoso", 1);
	    }
	}
	
	//Existen varios registros para el proceso. Considerar primero y último
	if (procesos.size() > 2){
	    if(procesos.get(0).getIdTipoLog() == 2 && procesos.get(procesos.size() - 1).getIdTipoLog() == 4){ //Es un inicio normal y término de error
		resumen.put("programadosHoy", 1);
		resumen.put("error", 1);
	    }
	    
	    if(procesos.get(0).getIdTipoLog() == 2 && procesos.get(procesos.size() - 1).getIdTipoLog() == 6){ //Es un inicio normal y término con éxito
		resumen.put("programadosHoy", 1);
		resumen.put("exitoso", 1);
	    }
	    
	    if (procesos.get(0).getIdTipoLog() != 2 && procesos.get(procesos.size() - 1).getIdTipoLog() == 4){ //Es un término con error, pero no cuenta con un inicio
		resumen.put("programadosHoy", 1);
		resumen.put("error", 1);
	    }
	    
	    if (procesos.get(0).getIdTipoLog() != 2 && procesos.get(procesos.size() - 1).getIdTipoLog() == 6){ //Es un término exitoso, pero no cuenta con un inicio
		resumen.put("programadosHoy", 1);
		resumen.put("exitoso", 1);
	    }
	}
	
	return resumen;
    }

    @GET
    @Path("/dia/pendientes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoExtract> getPendientes() {
	List<ProcesoExtract> listado = new ArrayList();
	List<ProcesoExtract> procesos = mapper.getExtractDiaActual();

	if (procesos.size() == 1 && procesos.get(0).getIdTipoLog() == 2) {
	    listado.add(procesos.get(0));
	    return listado;

	}
	return new ArrayList();

    }

    @GET
    @Path("/dia/exitosos")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, ProcesoExtract> getExitosos() {
	Map<String, ProcesoExtract> procesoExitoso = new HashMap();
	List<ProcesoExtract> procesos = mapper.getExtractDiaActual();
	if (procesos.size() > 1 && procesos.get(procesos.size() - 1).getIdTipoLog() == 6) {
	    procesoExitoso.put("procesoInicio", procesos.get(0));
	    procesoExitoso.put("procesoFin", procesos.get(procesos.size() - 1));
	    return procesoExitoso;

	}
	return new HashMap();

    }

    @GET
    @Path("/dia/errores")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, ProcesoExtract> getErrores() {
	Map<String, ProcesoExtract> procesoError = new HashMap();
	List<ProcesoExtract> procesos = mapper.getExtractDiaActual();
	if (procesos.size() > 1 && procesos.get(procesos.size() - 1).getIdTipoLog() == 4) {
	    procesoError.put("procesoInicio", procesos.get(0));
	    procesoError.put("procesoFin", procesos.get(procesos.size() - 1));
	    return procesoError;

	}
	return new HashMap();

    }
}
