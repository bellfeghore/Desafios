package Methods;

public class Peliculas extends Articulos {

	protected double duracion;
	protected String calidad;

	public Peliculas() {
		super();
	}

	public Peliculas(double tipo, String codigo, String nombre, double plazo, boolean reservado, double duracion,
			String calidad) {
		super(tipo, codigo, nombre, plazo, reservado);
		this.duracion = duracion;
		this.calidad = calidad;
	}

	public Peliculas(double duracion, String calidad) {
		super();
		this.duracion = duracion;
		this.calidad = calidad;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	@Override
	public String toString() {
		return "Pelicula [Duracion=" + duracion + ", Calidad=" + calidad + ", plazoMaximo=" + plazo + ", Nombre="
				+ nombre + ", Codigo=" + codigo + ", Reservado=" + reservado + "]";
	}
}
