package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Methods.*;

public class Main {
	public static ArrayList<Articulos> articulos;
	public static ArrayList<Users> usuarios;
	public static Scanner sc = new Scanner(System.in);

	public static String rArticulos;
	public static String rUsuarios;
	public static String formatoArchivo;

	public static String pass;
	public static String login;
	public static int indiceUsuario;
	public static int indicelArticulo;

	public static void main(String... arg) throws Exception {
		configuracion();
		datos();
		iniciar();
	}

	public static void configuracion() throws IOException {
		rArticulos = Configuracion.rArticulos().toString();
		rUsuarios = Configuracion.rUsuarios().toString();
		formatoArchivo = Configuracion.formatoSalida().toString();
	}

	public static void datos() throws Exception {
		Excel exportador = new Excel();
		articulos = new ArrayList<Articulos>(exportador.Leer(rArticulos));
		usuarios = new ArrayList<Users>(exportador.ExcelUsuariosArray(rUsuarios));
	}

	public static int iniciar() throws Exception {
		int iniciarSesion = 0;
		while (iniciarSesion == 0) {
			System.out.println("Ingrese su usuario ");
			login = sc.next();
			System.out.println("Ingrese su clave ");
			pass = sc.next();
			Excel exportador = new Excel();
			indiceUsuario = exportador.LeerUsuarios(rUsuarios, login, pass);
			if (indiceUsuario > -1) {
				menu();
				iniciarSesion = 1;
			} else {
				System.out.println("Error en usuario o clave ingresados");
				iniciarSesion = 0;
			}
		}
		return iniciarSesion;
	}

	public static void menu() throws Exception {
		int opcion = 0;
		String opc;
		boolean numerico;
		while (opcion == 0) {
			System.out.println("Bienvenido " + usuarios.get(indiceUsuario).getId());
			System.out.println("---------------------------");
			System.out.println("Que desea hacer?");
			System.out.println("1.- Buscar un artículo");
			System.out.println("2.- Reservar un artículo");
			System.out.println("3.- Devolver reserva");
			System.out.println("4.- Salir");
			opc = sc.next();
			opcion = Integer.parseInt(opc);
			numerico = true;

			if ((opcion > 4) || (opcion < 0)) {
				opcion = 0;
			}
			switch (opcion) {
			case 1:
				buscar();
				opcion = 0;
				break;
			case 2:
				reservar();
				opcion = 0;
				break;
			case 3:
				devolver();
				opcion = 0;
				break;

			case 4:
				Excel exportador = new Excel();
				exportador.UpdateExcel(rUsuarios, 1, indiceUsuario);
				opcion = 1;
				break;
			}
		}

	}

	public static int lista(boolean disponible) {
		int cuentalista = 0;
		for (Articulos articulos : articulos) {
			if (articulos.isReservado() == disponible) {
				System.out.println(articulos.toString());
				cuentalista++;
			}
		}
		System.out.println();
		return cuentalista;
	}

	public static void buscar() {
		String nombreBuscar;
		System.out.println("Ingrese un nombre para buscar el la lista. ");
		nombreBuscar = sc.next();
		for (Articulos articulos : articulos) {
			if (articulos.getNombre().indexOf(nombreBuscar) > -1) {
				System.out.println(articulos.toString());
			}
		}
	}

	public static void reservar() throws Exception {
		String nombreBuscar;
		int i = 0;
		int indice = -1;
		boolean encontrado = false;
		if (lista(false) > 0) {
			System.out.println("Ingrese el código del artículo.");
			nombreBuscar = sc.next();
			for (i = 0; i < articulos.size(); i++) {
				if (articulos.get(i).getCodigo().equals(nombreBuscar)) {
					if (articulos.get(i).isReservado() == false) {
						encontrado = true;
						indice = i;
						break;
					} else {
						System.out.println("Articulo reservado.");
						System.out.println("------------------------------------------------------------");
						System.out.println();
					}
				}
			}
			if (encontrado) {
				Excel exportador = new Excel();
				exportador.UpdateExcel(rArticulos, 2, i);
				datos();
				System.out.println("Reserva realizada.");
				System.out.println("------------------------------------------------------------");
				System.out.println();
			} else {
				System.out.println("El articulo no se encuentra disponible. ");
				System.out.println("------------------------------------------------------------");
				System.out.println();

			}
		} else {
			System.out.println("No existen articulos disponibles para reserva.");
		}

	}

	public static void devolver() throws Exception {
		String nombreBuscar;
		int i = 0;
		int indice = -1;
		boolean encontrado = false;
		if (lista(true) > 0) {
			System.out.println("Ingrese el código del artículo a Devolver.");
			nombreBuscar = sc.next();
			for (i = 0; i < articulos.size(); i++) {
				if (articulos.get(i).getCodigo().equals(nombreBuscar)) {
					if (articulos.get(i).isReservado()) {
						encontrado = true;
						indice = i;
						break;
					}
				}
			}
			if (encontrado) {
				Excel exportador = new Excel();
				exportador.UpdateExcel(rArticulos, 2, i);
				datos();
				System.out.println("Devolución de reserva realizada.");
				System.out.println("------------------------------------------------------------");
				System.out.println();
			} else {
				System.out.println("El articulo no se encuentra disponible o en estado reservado. ");
				System.out.println("------------------------------------------------------------");
				System.out.println();
			}
		} else {
			System.out.println("No existen articulos disponibles para devolucion de reserva.");
		}
	}
}
