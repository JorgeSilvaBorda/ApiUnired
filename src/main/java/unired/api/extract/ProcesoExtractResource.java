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
    
    @GET
    @Path("/resumen")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Integer> getExtractDiaActual(){
        
        List<ProcesoExtract> procesos = mapper.getExtractDiaActual();
        Integer programadosHoy = 0;
        Integer pendientes = 0;
        Integer enEjecucion = 0;
        Integer exitoso = 0;
        Integer error = 0;
        
        if(procesos.size() >= 1){
            if(procesos.get(0).getIdTipoLog() == 2){
                if(procesos.size() == 1){
                    pendientes = 1;
                    enEjecucion = 1;
                    exitoso = 1;
                    error = 0;
                }else if(procesos.size() > 1){
                    if(procesos.get(procesos.size() - 1).getIdTipoLog() == 6){
                        pendientes = 0;
                        enEjecucion = 0;
                        exitoso = 1;
                        error = 0;
                    }else if(procesos.get(procesos.size() - 1).getIdTipoLog() == 4){
                        pendientes = 0;
                        enEjecucion = 0;
                        exitoso = 0;
                        error = 1;
                    }
                }
                programadosHoy = 1;
            }
        }
        
        Map<String, Integer> salida = new HashMap();
        
        salida.put("programadosHoy", programadosHoy);
        salida.put("pendientes", pendientes);
        salida.put("enEjecucion", enEjecucion);
        salida.put("exitoso", exitoso);
        salida.put("error", error);
        System.out.println(salida);
        return salida;
        
    }
    
    @GET
    @Path("/dia/pendientes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoExtract> getPendientes(){
        List<ProcesoExtract> listado = new ArrayList();
        List<ProcesoExtract> procesos = mapper.getExtractDiaActual();
        
        if(procesos.size() == 1 && procesos.get(0).getIdTipoLog() == 2){
            listado.add(procesos.get(0));
            return listado;
            
        }
        return new ArrayList();
        
    }
    
    @GET
    @Path("/dia/exitosos")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, ProcesoExtract> getExitosos(){
        Map<String, ProcesoExtract> procesoExitoso = new HashMap();
        List<ProcesoExtract> procesos = mapper.getExtractDiaActual();
        if(procesos.size() > 1 && procesos.get(procesos.size() - 1).getIdTipoLog() == 6){
            procesoExitoso.put("procesoInicio", procesos.get(0));
            procesoExitoso.put("procesoFin", procesos.get(procesos.size() - 1));
            return procesoExitoso;
            
        }
        return new HashMap();
        
    }
    
    @GET
    @Path("/dia/errores")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, ProcesoExtract> getErrores(){
        Map<String, ProcesoExtract> procesoError = new HashMap();
        List<ProcesoExtract> procesos = mapper.getExtractDiaActual();
        if(procesos.size() > 1 && procesos.get(procesos.size() - 1).getIdTipoLog() == 4){
            procesoError.put("procesoInicio", procesos.get(0));
            procesoError.put("procesoFin", procesos.get(procesos.size() - 1));
            return procesoError;
            
        }
        return new HashMap();
        
    }
}
