package unired.api.historicos;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
    
    @GET
    @Path("/rendiciones/{fechaIni}/{fechaFin}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proceso> getRendicionesHistoria(@PathParam("fechaIni") String fechaIni, @PathParam("fechaFin") String fechaFin) {
	return rendicionesMapper.getRendicionesHistoria(fechaIni, fechaFin);
    }
    
    @GET
    @Path("/nominas/{fechaIni}/{fechaFin}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcesoNomina> getNominasHistoria(@PathParam("fechaIni") String fechaIni, @PathParam("fechaFin") String fechaFin) {
	return nominasMapper.getNominasHistoria(fechaIni, fechaFin);
    }
}
