package Methods;

public class Cesta {
	String codigo;
	int precio;
	public Cesta() {
		super();
	}
	public Cesta(String codigo, int precio) {
		super();
		this.codigo = codigo;
		this.precio = precio;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "CarroCompra [codigo=" + codigo + ", Precio=" + precio + "]";
	}
}
