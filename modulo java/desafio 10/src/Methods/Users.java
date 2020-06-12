package Methods;

public class Users {
	String id;
	String pass;
	boolean online;
	public Users() {
		super();
	}
	public Users(String id, String pass, boolean online) {
		super();
		this.id = id;
		this.pass = pass;
		this.online = online;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isOnline() {
		return online;
	}
	public void setOnline(boolean online) {
		this.online = online;
	}
	@Override
	public String toString() {
		return "Usuarios [UsuarioId=" + id + ", UsuarioPW=" + pass + ", UsuarioEnUso=" + online + "]";
	}
}
