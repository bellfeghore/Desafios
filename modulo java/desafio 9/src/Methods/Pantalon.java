package Methods;

public class Pantalon extends Articulo {
	

	public Pantalon(String articulo, int precio, String nombre, String talla, String codigo, String marca) {
		super(articulo, precio, nombre, talla, codigo, marca);
		// TODO Auto-generated constructor stub
	}
	String color;
	int cantidadDeBolsillos;
	
	public Pantalon(String articulo, int precio, String nombre, String talla, String codigo, String marca, String color,
			int cantidadDeBolsillos) {
		super(articulo, precio, nombre, talla, codigo, marca);
		this.color = color;
		this.cantidadDeBolsillos = cantidadDeBolsillos;
	}
	public int getCantidadDeBolsillos() {
		return cantidadDeBolsillos;
	}
	public void setCantidadDeBolsillos(int cantidadDeBolsillos) {
		this.cantidadDeBolsillos = cantidadDeBolsillos;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Pantalon [Color=" + color + 
				", bolsillos=" + cantidadDeBolsillos +
				", Talla=" + talla +
				", Marca=" + marca +
				", Precio=" + precio +
				", Nombre=" + nombre + 
				", Codigo=" + codigo +  "]";
	}
}
