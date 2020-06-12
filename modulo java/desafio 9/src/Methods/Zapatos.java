package Methods;

public class Zapatos extends Articulo {
	
	public Zapatos(String articulo, int precio, String nombre, String talla, String codigo, String marca) {
		super(articulo, precio, nombre, talla, codigo, marca);
		// TODO Auto-generated constructor stub
	}

	String modelo;

	public Zapatos(String articulo, int precio, String nombre, String talla, String codigo, String marca,
			String modelo) {
		super(articulo, precio, nombre, talla, codigo, marca);
		this.modelo = modelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Zapato [modelo=" + modelo + ", Talla=" + talla + ", Marca=" + marca + ", Precio=" + precio + ", Nombre="
				+ nombre + ", Codigo=" + codigo + "]";
	}
}
