package Methods;
import java.util.*;
public class CuentaCorriente extends Producto {


	
	public CuentaCorriente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CuentaCorriente(String numeroTarjeta, float saldo, String edadCliente) {
		super(numeroTarjeta, saldo, edadCliente);
		// TODO Auto-generated constructor stub
	}

	int deuda=15000;

	public int getDeuda() {
		return deuda;
	}

	public void setDeuda(int deuda) {
		this.deuda = deuda;
	}
	
}
