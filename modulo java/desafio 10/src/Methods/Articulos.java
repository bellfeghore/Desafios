package Methods;

public abstract class Articulos {
	protected double tipo;
	protected String codigo;
	protected String nombre;
	protected double plazo;
	protected boolean reservado;

	public Articulos() {
		super();
	}

	public Articulos(double tipo, String codigo, String nombre, double plazo, boolean reservado) {
		super();
		this.tipo = tipo;
		this.codigo = codigo;
		this.nombre = nombre;
		this.plazo = plazo;
		this.reservado = reservado;
	}

	public double getTipo() {
		return tipo;
	}

	public void setTipo(double tipo) {
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPlazo() {
		return plazo;
	}

	public void setPlazo(double plazo) {
		this.plazo = plazo;
	}

	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

}
