package unired.api.nominas;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/procesonominas")
@ApplicationScoped
public class ProcesoNominaResource {

    @Inject
    ProcesoNominasMapper mapper;

    @GET
    @Path("/resumen")
    @Produces(MediaType.APPLICATION_JSON)
    public ProcesosNomina getResumentNominas() {
	return mapper.getResumenNominas();
    }
    
    @GET
    @Path("/dia")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoNomina> getProgramadas() {
	return mapper.getProgramadas();
    }
    
    @GET
    @Path("/dia/ejecutados")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoNomina> getEjecutadas() {
	return mapper.getEjecutadas();
    }
    
    @GET
    @Path("/dia/exitosos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoNomina> getExitosas() {
	return mapper.getExitosas();
    }
    
    @GET
    @Path("/dia/errores")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoNomina> getErrores() {
	return mapper.getErrores();
    }
    
    @GET
    @Path("/dia/pendientes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoNomina> getPendientes() {
	return mapper.getPendientes();
    }
    
    @GET
    @Path("/dia/norecibidas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoNomina> getNoRecibidas() {
	return mapper.getNoRecibidas();
    }
    
    @GET
    @Path("/dia/sinprocesar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoNomina> getSinProcesar() {
	return mapper.getSinProcesar();
    }
    
    @GET
    @Path("/dia/parcialmente")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoNomina> getParcialmente() {
	return mapper.getParcialmente();
    }
    
    @GET
    @Path("/dia/nocumple")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoNomina> getNoCumple() {
	return mapper.getNoCumple();
    }
}
