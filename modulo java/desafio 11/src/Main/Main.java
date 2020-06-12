package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import Methods.Persona;

public class Main {
	public static List<Persona> persona = new ArrayList<>();
	public static List<Integer> numeros = new ArrayList<Integer>();

	public static void main(String... args) throws IOException {
		cargarDatos();
		buscarPersona("Giselle Marshall", 0);
		System.out.println("--------------------------------------------------------");
		buscarPersona("imperdiet.non@enim.org", 1);
		System.out.println("--------------------------------------------------------");
		guardaCiudades();// leer comentario de la linea de codigo 76 para obtener resultado 100 que
							// solicita el desafio
		System.out.println("--------------------------------------------------------");
		System.out.println(cuentaCorreos("elit"));
		System.out.println("--------------------------------------------------------");
		multiplicar();
		System.out.println("--------------------------------------------------------");
		promedio();
		System.out.println("--------------------------------------------------------");
		personaMontoMenor();

		System.out.println("--------------------------------------------------------");
		personaMontoMayor();
	}

	private static List<Persona> loadCSV() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("datos.csv"));
		return br.lines().map(line -> line.split(","))
				.map(values -> new Persona(values[0], values[1], values[2], Integer.parseInt(values[3])))
				.collect(Collectors.toList());
	}

	private static void cargarDatos() throws IOException {
		persona = new ArrayList<>(loadCSV());
		for (Persona persona : persona) {
			numeros.add(persona.getMonto());
		}
	}

	public static void buscarPersona(String datoBuscar, int tipoDatoBuscar) {
		for (Persona persona : persona) {
			switch (tipoDatoBuscar) {
			case 0:
				if (persona.getNombre().equals(datoBuscar)) {
					System.out.println(persona.toString());
				}
				break;
			case 1:
				if (persona.getCorreo().equals(datoBuscar)) {
					System.out.println(persona.toString());
				}
				break;
			}
		}
	}

	public static void guardaCiudades() {
		Set<String> ciudades = new HashSet<>();
		for (Persona persona : persona) {
			ciudades.add(persona.getCiudad());
		}
		// Para obtener el resultado solicitado en el desafio quitar el comentario de la
		// linea 78 y comentar la linea 77
		System.out.println(ciudades.size());
		// System.out.println(ciudades.size()+1);
	}

	public static int cuentaCorreos(String datoBuscar) {
		int cuentaCorreos = 0;
		String subcadena;
		for (Persona persona : persona) {
			subcadena = persona.getCorreo().substring((persona.getCorreo().lastIndexOf("@") + 1),
					persona.getCorreo().length());
			if (subcadena.indexOf(datoBuscar) > -1) {
				cuentaCorreos++;
			}
		}

		return cuentaCorreos;
	}

	public static void multiplicar() {
		numeros.stream().map(n -> n * 3).filter(n -> n > 29000).forEach(System.out::println);
	}

	public static void promedio() {
		int suma = 0;
		suma = numeros.stream().reduce(0, (a, b) -> a + b);
		System.out.println((suma / (persona.size())));
	}

	public static void personaMontoMenor() {
		int numMenor = numeros.stream().min(Comparator.naturalOrder()).get();
		persona.stream().filter(s -> s.getMonto() == numMenor).forEach(System.out::println);
	}

	public static void personaMontoMayor() {
		int numMayor = numeros.stream().max(Comparator.naturalOrder()).get();
		persona.stream().filter(s -> s.getMonto() == numMayor).forEach(System.out::println);
	}

}
