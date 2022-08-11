package unired.api.usuarios;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.bson.Document;

@ApplicationScoped
public class UsuarioService {
    
    @Inject MongoClient client;
    
    public Usuario getByLogin(String login){
	Document document = (Document) getCollection().find(Filters.eq("login", login)).first();
	
	Usuario usuario = new Usuario();
	
	if (document == null){
	    usuario.setLogin("");
	    return usuario;
	}
	
	usuario.setLogin(document.getString("login"));
	
	return usuario;
    }
    
    private MongoCollection getCollection() {
	return client.getDatabase("dashboard").getCollection("usuario");
    }
}
