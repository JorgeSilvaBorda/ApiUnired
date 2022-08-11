package unired.api.usuarios;

public class Usuario {
    
    private String login;

    public Usuario() {
    }

    public Usuario(String login) {
	this.login = login;
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }
    
    
}
