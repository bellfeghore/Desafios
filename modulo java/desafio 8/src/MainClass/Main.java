package MainClass;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import Methods.*;

public class Main {
	public static void main(String... arg) {
		Scanner scan = new Scanner(System.in);
		int i = 0;
		String rut = "";
		String contraseña = "";
		int opcion = 0, seleccion = 0;
		programaPrincipal(scan, i, contraseña, opcion);
	}

	private static void programaPrincipal(Scanner scan, int i, String contraseña, int opcion) {
		String rut;
		int seleccion;
		while (i == 0) {
			System.out.println("Ingrese nombre del cliente");
			String nombre = scan.next();
			System.out.println("Ingrese rut del cliente(sin puntos ni guion");
			String rutcrudo = scan.next();

			if (rutcrudo.contains(".")) {
				System.out.println("No se puede ingresar rut con '.'");
			} else {
				if (rutcrudo.contains("-")) {
					System.out.println("No puede ingresar rut con '-'");
				} else {
					if (rutcrudo.length() < 9) {
						System.out.println("Rut demasiado corto");
					} else {
						rut = rutcrudo;
						int c = 0;
						while (c == 0) {
							System.out.println("Ingrese una clave de acceso(4 digitos)");
							contraseña = scan.next();
							if (contraseña.length() != 4) {
								System.out.println("la clave ingresada no cumple los parametros");
							} else {
								c++;
							}
						}
						System.out.println("Ingrese fecha de nacimiento del cliente(DD/MM/AAAA)");

						String fechaNacimiento = scan.next();
						System.out.println("Ingrese un saldo");
						int saldo = scan.nextInt();
						String edadCliente = calculaEdad(fechaNacimiento);

						Cliente cliente = new Cliente(nombre, rut, edadCliente);
						String rutC = String.valueOf(rut);
						rutC = rutC.substring(0, 8);
						String nTarjeta = "";
						nTarjeta = nTarjeta.concat("00-" + rutC);
						CuentaCorriente ctacte = new CuentaCorriente(nTarjeta, saldo, edadCliente);
						TarjetaCredito credito = new TarjetaCredito(nTarjeta, saldo, edadCliente);
						c = 0;
						login(scan, rut, contraseña, c);
						System.out.println("bienvenido");
						System.out.println(cliente.getNombreCliente() + "(" + cliente.getEdadCliente() + ")");
						while (opcion == 0) {
							System.out.println("Que deseas hacer ?");
							System.out.println("1- Menu Cuenta Corriente");
							System.out.println("2- Menu Tarjeta de Credito");
							System.out.println("3- Ver datos de mi ejecutivo");
							System.out.println("4- Salir");
							seleccion = scan.nextInt();
							switch (seleccion) {
							case 1:
								menuCuentaCorriente(scan, ctacte);
								break;
							case 2:
								menuTarjetaCredito(scan, credito);
								break;
							case 3:
								datosEjecutivo();
								break;
							case 4:
								cierreSesion();
								opcion++;
								i++;
								break;
							}
						}
					}
				}
			}

		}
	}

	private static void datosEjecutivo() {
		String nombreEjecutivo="Francisca  Araya";
		String rutEjecutivo="17.076.089-1";
		String direccionSucursal="Estado 135, oficina 1, piso 1";
	}

	private static void menuTarjetaCredito(Scanner scan, TarjetaCredito credito) {
		int c=0;
		int v=0;
		while (c == 0) {
		System.out.println("Tarjeta de credito: " + credito.getNumeroTarjeta());
		System.out.println("Saldo: $" + credito.getSaldo() + "/" + credito.getMaximo());
		System.out.println("Deuda: $" + credito.getDeuda());
		if (credito.getDeuda() != 0) {
			if (credito.getDeuda() < credito.getSaldo()) {
				System.out.println("1.-Abonar monto personalizado");
				System.out.println("2.-Pagar deuda completa");
				System.out.println("0.-Volver al menu");
				v=scan.nextInt();

			} else {
				if (credito.getDeuda() > credito.getSaldo()) {
					System.out.println("1.-Abonar monto personalizado");
					System.out.println("0.-Volver al menu");
					v=scan.nextInt();
				}
			}
		}
		else {
			System.out.println("0.-Volver al menu");
			v=scan.nextInt();
		}
			switch (v) {
			case 2:
				credito.setDeuda(0);
				credito.setSaldo(credito.getSaldo() - credito.getDeuda());
				System.out.println("La deuda completa se ha pagado con exito");
				v++;
				break;
			case 1:
				System.out.println("Cuanto desea abonar?");
				int abono = scan.nextInt();
				if (abono > credito.getSaldo()) {
					System.out.println("No se pudo procesar la solicitud, monto ingresado excede saldo actual.");
					System.out.println("Saldo actual: $" + credito.getSaldo() + " porfavor intente nuevamente");
				} else {
					credito.setSaldo(credito.getSaldo() - abono);
					credito.setDeuda(credito.getDeuda() - abono);
					System.out.println("Su deuda ha sido abonada exitosamente");
					v++;
				}
				break;
			case 0:
				c++;
				break;
			}
		}
	}

	private static void login(Scanner scan, String rut, String contraseña, int c) {
		while (c == 0) {
			System.out.println("Bienvenido, para continuar ingresar rut(sin puntos ni guion) y clave numerica");
			String user = scan.next();
			String pass = scan.next();
			if (user.compareTo(rut) == 0 && pass.compareTo(contraseña) == 0) {
				c++;
			}
		}
	}

	private static void menuCuentaCorriente(Scanner scan, CuentaCorriente ctacte) {
		int x = 0;
		while (x == 0) {
		System.out.println("cuenta corriente: " + ctacte.getNumeroTarjeta());
		System.out.println("saldo actual :" + ctacte.getSaldo());
		System.out.println("tiene una deuda de: $" + ctacte.getDeuda());
			System.out.println("1.-Volver al menu");
			if (ctacte.getDeuda() > 0) {
				System.out.println("2.-Pagar deuda");
			}
			int z = scan.nextInt();
			switch (z) {
			case 1:
				x++;
				break;
			case 2:
				if (ctacte.getSaldo() >= ctacte.getDeuda()) {
					ctacte.setDeuda(0);
					ctacte.setSaldo(ctacte.getSaldo() - ctacte.getSaldo());
					System.out.println("Su deuda ha sido pagada con exito");
				} else {
					System.out.println("Saldo insuficiente");
				}
			}
		}
	}

	private static void cierreSesion() {
		System.out.println("Cerrando Sesion ...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ex) {
			System.out.println("No se ha podido cerrar sesion");
		}
		System.out.println("Se ha cerrado la sesion con exito");
	}

	private static String calculaEdad(String fechaNacimiento) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNac, ahora);
		String edadCliente = String.valueOf(periodo.getYears());
		return edadCliente;
	}
}
