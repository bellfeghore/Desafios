package Methods;


public class Despacho {
	private String direccionDespacho;
	private String nombreCliente;
	private String productos;
	private int montoTotal;
	private String fechaCompra;

	public Despacho(String direccionDespacho, String nombreCliente, String productos, int montoTotal,
			String fechaCompra) {
		super();
		this.direccionDespacho = direccionDespacho;
		this.nombreCliente = nombreCliente;
		this.productos = productos;
		this.montoTotal = montoTotal;
		this.fechaCompra = fechaCompra;
	}

	public String getDireccionDespacho() {
		return direccionDespacho;
	}

	public void setDireccionDespacho(String direccionDespacho) {
		this.direccionDespacho = direccionDespacho;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getProductos() {
		return productos;
	}

	public void setProductos(String productos) {
		this.productos = productos;
	}

	public int getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(int montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	@Override
	public String toString() {
		return "OrdenesDespacho [DireccionDespacho=" + direccionDespacho + ", NombreCliente=" + nombreCliente
				+ ", Productos=" + productos + ", MontoTotal=" + montoTotal + ", FechaCompra=" + fechaCompra + "]";
	}

}
