package unired.api.conciliacion;

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
@Path("/procesoconciliacion")
public class ProcesoConciliacionResource {

    @Inject
    ProcesoConciliacionMapper mapper;
    /*
    @GET
    @Path("/resumen")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Integer> getConciliacionDiaActual() {
        List<ProcesoConciliacion> procesos = mapper.getConciliacionDiaActual();
        Integer programadosHoy = 0;
        Integer pendientes = 0;
        Integer enEjecucion = 0;
        Integer ejecutados = 0;
        Integer exitoso = 0;
        Integer error = 0;

        if (procesos.size() >= 1) {
            //Recorrer todos los procesos para sumar
            for (ProcesoConciliacion proceso : procesos) {
                switch (proceso.getIdTipoLog()) {
                    case 2:
                        programadosHoy++;
                        break;
                    case 4:
                        error++;
                        break;
                    case 6:
                        exitoso++;
                    default:
                        break;
                }
            }
        }

        ejecutados = error + exitoso;

        //Prevenir pendientes menor a cero
        pendientes = ((programadosHoy - ejecutados) < 0 ? 0 : (programadosHoy - ejecutados));
        enEjecucion = pendientes;

        Map<String, Integer> salida = new HashMap();
        salida.put("programadosHoy", programadosHoy);
        salida.put("pendientes", pendientes);
        salida.put("enEjecucion", enEjecucion);
        salida.put("ejecutados", ejecutados);
        salida.put("exitoso", exitoso);
        salida.put("error", error);

        return salida;
    }
    */
    
    @GET
    @Path("/resumen")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Integer> getResumenDiaActual(){
	List<ProcesoConciliacion> procesos = mapper.getConciliacionDiaActual();
        Integer programadosHoy = 0;
        Integer pendientes = 0;
        Integer enEjecucion = 0;
        Integer ejecutados = 0;
        Integer exitoso = 0;
        Integer error = 0;
	
	Map<String, Integer> resumen = new HashMap();
	
	//Por defecto, todos en cero
	resumen.put("programadosHoy", programadosHoy);
	resumen.put("pendientes", pendientes);
	resumen.put("enEjecucion", enEjecucion);
	resumen.put("ejecutados", ejecutados);
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
		resumen.put("ejecutados", 1);
		resumen.put("exitoso", 1);
	    }
	    
	    if(procesos.get(0).getIdTipoLog() == 4){ //Es un registro de término de error
		resumen.put("programadosHoy", 1);
		resumen.put("ejecutados", 1);
		resumen.put("error", 1);
	    }
	}
	
	//Existen exactamente dos registros
	if(procesos.size() == 2){
	    if(procesos.get(0).getIdTipoLog() == 2 && procesos.get(1).getIdTipoLog() == 4){ //Es un inicio normal y término de error
		resumen.put("programadosHoy", 1);
		resumen.put("ejecutados", 1);
		resumen.put("error", 1);
	    }
	    
	    if(procesos.get(0).getIdTipoLog() == 2 && procesos.get(1).getIdTipoLog() == 6){ //Es un inicio normal y término con éxito
		resumen.put("programadosHoy", 1);
		resumen.put("ejecutados", 1);
		resumen.put("exitoso", 1);
	    }
	    
	    if (procesos.get(0).getIdTipoLog() != 2 && procesos.get(1).getIdTipoLog() == 4){ //Es un término con éxito, pero no cuenta con un inicio
		resumen.put("programadosHoy", 1);
		resumen.put("ejecutados", 1);
		resumen.put("exitoso", 1);
	    }
	    
	    if (procesos.get(0).getIdTipoLog() != 2 && procesos.get(1).getIdTipoLog() == 6){ //Es un término con de error, pero no cuenta con un inicio
		resumen.put("programadosHoy", 1);
		resumen.put("ejecutados", 1);
		resumen.put("error", 1);
	    }
	}
	
	//Existen varios registros para el proceso. Considerar primero y último
	if (procesos.size() > 2){
	    if(procesos.get(0).getIdTipoLog() == 2 && procesos.get(procesos.size() - 1).getIdTipoLog() == 4){ //Es un inicio normal y término de error
		resumen.put("programadosHoy", 1);
		resumen.put("ejecutados", 1);
		resumen.put("error", 1);
	    }
	    
	    if(procesos.get(0).getIdTipoLog() == 2 && procesos.get(procesos.size() - 1).getIdTipoLog() == 6){ //Es un inicio normal y término con éxito
		resumen.put("programadosHoy", 1);
		resumen.put("ejecutados", 1);
		resumen.put("exitoso", 1);
	    }
	    
	    if (procesos.get(0).getIdTipoLog() != 2 && procesos.get(procesos.size() - 1).getIdTipoLog() == 4){ //Es un término con éxito, pero no cuenta con un inicio
		resumen.put("programadosHoy", 1);
		resumen.put("ejecutados", 1);
		resumen.put("exitoso", 1);
	    }
	    
	    if (procesos.get(0).getIdTipoLog() != 2 && procesos.get(procesos.size() - 1).getIdTipoLog() == 6){ //Es un término con de error, pero no cuenta con un inicio
		resumen.put("programadosHoy", 1);
		resumen.put("ejecutados", 1);
		resumen.put("error", 1);
	    }
	}
	
	return resumen;
    }

    @GET
    @Path("/dia/pendientes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoConciliacion> getPendientes() {
        List<ProcesoConciliacion> listado = new ArrayList();
        List<ProcesoConciliacion> procesos = mapper.getConciliacionDiaActual();

        if (procesos.size() == 1 && procesos.get(0).getIdTipoLog() == 2) {
            listado.add(procesos.get(0));
        }

        return listado;
    }

    @GET
    @Path("/dia/programadas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoConciliacion> getProgramados() {
        List<ProcesoConciliacion> listado = new ArrayList();
        List<ProcesoConciliacion> procesos = mapper.getConciliacionDiaActual();
        for (ProcesoConciliacion proceso : procesos) {
            if (proceso.getIdTipoLog() == 2) {
                listado.add(proceso);
            }
        }

        return listado;
    }

    @GET
    @Path("/dia/ejecutados")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, ProcesoConciliacion> getEjecutados() {
        Map<String, ProcesoConciliacion> procesosEjecutados = new HashMap();
        List<ProcesoConciliacion> procesos = mapper.getConciliacionDiaActual();
        if (procesos.size() > 1) {
            procesosEjecutados.put("procesoInicio", procesos.get(0));
            procesosEjecutados.put("procesoFin", procesos.get(procesos.size() - 1));
        }
        return procesosEjecutados;
    }

    @GET
    @Path("/dia/exitosos")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, ProcesoConciliacion> getExitosos() {
        Map<String, ProcesoConciliacion> procesosExitosos = new HashMap();
        List<ProcesoConciliacion> procesos = mapper.getConciliacionDiaActual();
        if(procesos.size() > 1 && procesos.get(procesos.size() - 1).getIdTipoLog() == 6){
            procesosExitosos.put("procesoInicio", procesos.get(0));
            procesosExitosos.put("procesoFin", procesos.get(procesos.size() - 1));
        }

        return procesosExitosos;
    }
    
    @GET
    @Path("/dia/errores")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, ProcesoConciliacion> getErrores() {
        Map<String, ProcesoConciliacion> procesosError = new HashMap();
        List<ProcesoConciliacion> procesos = mapper.getConciliacionDiaActual();
        if(procesos.size() > 1 && procesos.get(procesos.size() - 1).getIdTipoLog() == 4){
            procesosError.put("procesoInicio", procesos.get(0));
            procesosError.put("procesoFin", procesos.get(procesos.size() - 1));
        }

        return procesosError;
    }
}
