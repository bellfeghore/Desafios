package Methods;

public class Producto {
	String numeroTarjeta;
	float saldo;
	String edadCliente;
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public String getEdadCliente() {
		return edadCliente;
	}
	public void setEdadCliente(String edadCliente) {
		this.edadCliente = edadCliente;
	}
	public Producto(String numeroTarjeta, float saldo, String edadCliente) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.saldo = saldo;
		this.edadCliente = edadCliente;
	}
	public Producto() {
		super();
	}
	}

