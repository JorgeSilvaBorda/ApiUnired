package unired.api.rendiciones;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/proceso")
public class ProcesoResource {
    @Inject ProcesoMapper mapper;
    
    @Path("/{idProceso}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Proceso getProcesoByIdProceso(@PathParam("idProceso") Integer idProceso){
	return mapper.getProceso(idProceso);
    }
    
    @Path("/{idProceso}/subprocesos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SubProceso> getSubProcesos(@PathParam("idProceso") Integer idProceso){
	return mapper.getSubProcesosIdProceso(idProceso);
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer getProcesosActivos(){
	return mapper.getProcesosActivos();
    }
    
    @GET
    @Path("/resumen")
    @Produces(MediaType.APPLICATION_JSON)
    public Procesos getResumenProcesos(){
	return mapper.getCuentaProcesos();
    }
    
    @GET
    @Path("/dia/{fecha}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosDia(@PathParam("fecha") String fecha){
	return mapper.getProcesosDia(fecha);
    }
    
    @GET
    @Path("/dia/{fecha}/{codEstado}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosDiaCodEstado(@PathParam("fecha") String fecha, @PathParam("codEstado") Integer codEstado){
	return mapper.getProcesosDiaCodEstado(fecha, codEstado);
    }
    
    @GET
    @Path("/dia/{fecha}/ejecutados")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosDiaProcesados(@PathParam("fecha") String fecha){
	return mapper.getProcesosDiaEjecutados(fecha);
    }
    
    @GET
    @Path("/dia/{fecha}/exitosos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosDiaExitosos(@PathParam("fecha") String fecha){
	return mapper.getProcesosDiaExitosos(fecha);
    }
    
    @GET
    @Path("/dia/{fecha}/errores")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosDiaErrores(@PathParam("fecha") String fecha){
	return mapper.getProcesosDiaErrores(fecha);
    }
    
    @GET
    @Path("/dia/{fecha}/pendientes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosDiaPendientess(@PathParam("fecha") String fecha){
	return mapper.getProcesosDiaPendientes(fecha);
    }
}
