package Methods;

public class Libros extends Articulos {

	protected String imprenta;
	protected double paginas;

	public Libros() {
		super();
	}

	public Libros(double tipo, String codigo, String nombre, double plazo, boolean reservado, String imprenta,
			double paginas) {
		super(tipo, codigo, nombre, plazo, reservado);

		this.imprenta = imprenta;
		this.paginas = paginas;
	}

	public Libros(String imprenta, double paginas) {
		super();
		this.imprenta = imprenta;
		this.paginas = paginas;
	}

	public String getImprenta() {
		return imprenta;
	}

	public void setImprenta(String imprenta) {
		this.imprenta = imprenta;
	}

	public double getPaginas() {
		return paginas;
	}

	public void setPaginas(double paginas) {
		this.paginas = paginas;
	}
	@Override
	public String toString() {
		return "Libro [Paginas=" + paginas +
				 ", Imprenta=" + imprenta +
				 ", plazoMaximo=" + plazo +
				 ", Nombre=" + nombre +
			     ", Codigo=" + codigo +				 
				 ", Reservado=" + reservado + "]";
	}
}
