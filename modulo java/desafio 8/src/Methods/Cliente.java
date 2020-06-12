package Methods;

public class Cliente {
	String nombreCliente;
	String rutCliente;
	String edadCliente;
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getRutCliente() {
		return rutCliente;
	}
	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}
	public String getEdadCliente() {
		return edadCliente;
	}
	public void setEdadCliente(String edadCliente) {
		this.edadCliente = edadCliente;
	}
	public Cliente(String nombreCliente, String rutCliente, String edadCliente) {
		super();
		this.nombreCliente = nombreCliente;
		this.rutCliente = rutCliente;
		this.edadCliente = edadCliente;
	}
}
