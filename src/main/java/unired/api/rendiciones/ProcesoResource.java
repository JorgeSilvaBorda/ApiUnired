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
    @Path("/dia/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosDia(){
	return mapper.getProcesosDia();
    }
    
    @GET
    @Path("/dia/{codEstado}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosDiaCodEstado(@PathParam("codEstado") Integer codEstado){
	return mapper.getProcesosDiaCodEstado(codEstado);
    }
    
    @GET
    @Path("/dia/ejecutados")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosDiaProcesados(){
	return mapper.getProcesosDiaEjecutados();
    }
    
    @GET
    @Path("/dia/exitosos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosDiaExitosos(){
	return mapper.getProcesosDiaExitosos();
    }
    
    @GET
    @Path("/dia/errores")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosDiaErrores(){
	return mapper.getProcesosDiaErrores();
    }
    
    @GET
    @Path("/dia/pendientes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosDiaPendientess(){
	return mapper.getProcesosDiaPendientes();
    }
    
    @GET
    @Path("/dia/vacias")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosRendicionVacia(){
	return mapper.getProcesosRendicionVacia();
    }
    
    @GET
    @Path("/dia/enviadasmail")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosEnviadoMail(){
	return mapper.getProcesosDiaEnviadoMail();
    }
    
    @GET
    @Path("/dia/ejecucion")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosEjecucion(){
	return mapper.getProcesosRendicionEjecucion();
    }
}
