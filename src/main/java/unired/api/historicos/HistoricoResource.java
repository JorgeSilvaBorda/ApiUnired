package unired.api.historicos;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import unired.api.conciliacion.ProcesoConciliacionCompleto;
import unired.api.conciliacion.ProcesoConciliacionMapper;
import unired.api.extract.ProcesoExtractCompleto;
import unired.api.extract.ProcesoExtractMapper;
import unired.api.nominas.ProcesoNomina;
import unired.api.nominas.ProcesoNominasMapper;
import unired.api.rendiciones.Proceso;
import unired.api.rendiciones.ProcesoMapper;

@Path("/historico")
public class HistoricoResource {
    
    @Inject
    ProcesoMapper rendicionesMapper;
    
    @Inject
    ProcesoNominasMapper nominasMapper;
    
    @Inject
    ProcesoExtractMapper extractMapper;
    
    @Inject
    ProcesoConciliacionMapper conciliacionMapper;
    
    @GET
    @Path("/rendiciones/{fechaIni}/{fechaFin}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getRendicionesHistoria(@PathParam("fechaIni") String fechaIni, @PathParam("fechaFin") String fechaFin) {
	System.out.println(rendicionesMapper.getRendicionesHistoria(fechaIni, fechaFin).size());
	return rendicionesMapper.getRendicionesHistoria(fechaIni, fechaFin);
    }
    
    @GET
    @Path("/nominas/{fechaIni}/{fechaFin}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoNomina> getNominasHistoria(@PathParam("fechaIni") String fechaIni, @PathParam("fechaFin") String fechaFin) {
	return nominasMapper.getNominasHistoria(fechaIni, fechaFin);
    }
    
    @GET
    @Path("/extract/{fechaIni}/{fechaFin}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoExtractCompleto> getExtractHistoria(@PathParam("fechaIni") String fechaIni, @PathParam("fechaFin") String fechaFin) {
	return extractMapper.getHistoricoExtract(fechaIni, fechaFin);
    }
    
    @GET
    @Path("/conciliacion/{fechaIni}/{fechaFin}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoConciliacionCompleto> getConciliacionHistoria(@PathParam("fechaIni") String fechaIni, @PathParam("fechaFin") String fechaFin) {
	return conciliacionMapper.getHistoricoConciliacion(fechaIni, fechaFin);
    }
}
