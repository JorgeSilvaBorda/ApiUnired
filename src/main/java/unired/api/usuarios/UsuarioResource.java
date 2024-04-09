package unired.api.usuarios;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/usuario")
public class UsuarioResource {
    @Inject UsuarioService usuarioService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{login}")
    public Usuario getUsuarioByLogin(@PathParam("login") String login){
	return usuarioService.getByLogin(login);
    }
}
