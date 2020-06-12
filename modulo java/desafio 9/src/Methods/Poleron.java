package Methods;

public class Poleron extends Articulo {
	public Poleron(String articulo, int precio, String nombre, String talla, String codigo, String marca) {
		super(articulo, precio, nombre, talla, codigo, marca);
		// TODO Auto-generated constructor stub
	}
	String color;

	public Poleron(String articulo, int precio, String nombre, String talla, String codigo, String marca,
			String color) {
		super(articulo, precio, nombre, talla, codigo, marca);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Poleron [Color=" + color +
				", Talla=" + talla +
				", Marca=" + marca +
				", Precio=" + precio +
				", Nombre=" + nombre +
				", Codigo=" + codigo +   "]";
	}
}
