package Methods;

public class Articulo {
	String articulo;
	int precio;
	String nombre, talla, codigo, marca;

	

	public Articulo(String articulo, int precio, String nombre, String talla, String codigo, String marca) {
		super();
		this.articulo = articulo;
		this.precio = precio;
		this.nombre = nombre;
		this.talla = talla;
		this.codigo = codigo;
		this.marca = marca;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
