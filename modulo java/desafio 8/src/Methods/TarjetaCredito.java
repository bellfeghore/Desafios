package Methods;

public class TarjetaCredito extends Producto {

	
	public TarjetaCredito() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TarjetaCredito(String numeroTarjeta, float saldo, String edadCliente) {
		super(numeroTarjeta, saldo, edadCliente);
		// TODO Auto-generated constructor stub
	}
	int deuda = 20000;
	public int getDeuda() {
		return deuda;
	}
	public void setDeuda(int deuda) {
		this.deuda = deuda;
	}
	public float getMaximo() {
		return maximo;
	}
	public void setMaximo(float maximo) {
		this.maximo = maximo;
	}
	float maximo=saldo+200;
}
