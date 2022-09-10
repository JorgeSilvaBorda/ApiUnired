package unired.api.rendiciones;

import io.quarkus.agroal.DataSource;
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
    //@DataSource("nominas")
    ProcesoNominasMapper mapper;

    @GET
    @Path("/resumen")
    @Produces(MediaType.APPLICATION_JSON)
    public ProcesosNomina getResumentNominas() {
	return mapper.getResumenNominas();
    }
}
