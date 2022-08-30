package unired.api.rendiciones;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

@Path("/proceso")
public class ProcesoResource {

    @Inject
    ProcesoMapper mapper;
    @Inject
    TipoDiaMapper tMapper;

    @Path("/{idProceso}/subprocesos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SubProceso> getSubProcesos(@PathParam("idProceso") Integer idProceso) {
	return mapper.getSubProcesosIdProceso(idProceso);
    }

    @GET
    @Path("/resumen")
    @Produces(MediaType.APPLICATION_JSON)
    public Procesos getResumenProcesos() {
	Procesos procs = mapper.getCuentaProcesos();
	TipoDia tipo = new TipoDia();
	tipo = tMapper.obtenerTipoDiaHoy();
	if (tipo.getFeriado() == 1 || tipo.getFinSemana() == 1) {
	    System.out.println("Es feriado o finde");
	    procs.setTotal(mapper.getProgramadosDiaFeriado());
	} else if (tipo.getAyerFeriado() == 1) {
	    System.out.println("Ayer fue feriado");
	    procs.setTotal(mapper.getProgramadosDiaPostFeriado());
	} else {
	    System.out.println("Es dia normal");
	    procs.setTotal(mapper.getProgramadosDiaNormal());
	    System.out.println("total: " + procs.getTotal());
	}
	return procs;
    }

    @GET
    @Path("/dia/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoProgramado> getProcesosDia() {
	TipoDia tipo = tMapper.obtenerTipoDiaHoy();
	
	if (tipo.getFeriado() == 1 || tipo.getFinSemana() == 1) {
	    return mapper.getProcesosDiaFeriado();
	} else if (tipo.getAyerFeriado() == 1) {
	    return mapper.getProcesosDiaPostferiado();
	} else {
	    return mapper.getProcesosDiaNormal();
	}
    }

    @GET
    @Path("/dia/ejecutados")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosDiaProcesados() {
	return mapper.getProcesosDiaEjecutados();
    }

    @GET
    @Path("/dia/exitosos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosDiaExitosos() {
	return mapper.getProcesosDiaExitosos();
    }

    @GET
    @Path("/dia/errores")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosDiaErrores() {
	return mapper.getProcesosDiaErrores();
    }

    @GET
    @Path("/dia/pendientes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosDiaPendientess() {
	return mapper.getProcesosDiaPendientes();
    }

    @GET
    @Path("/dia/vacias")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosRendicionVacia() {
	return mapper.getProcesosRendicionVacia();
    }

    @GET
    @Path("/dia/enviadasmail")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosEnviadoMail() {
	return mapper.getProcesosDiaEnviadoMail();
    }

    @GET
    @Path("/dia/generadas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosGenerados() {
	return mapper.getProcesosGenerados();
    }

    @GET
    @Path("/dia/transmitidas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosTransmitidos() {
	return mapper.getProcesosTransmitidos();
    }

    @GET
    @Path("/dia/ejecucion")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getProcesosEjecucion() {
	return mapper.getProcesosRendicionEjecucion();
    }
}
