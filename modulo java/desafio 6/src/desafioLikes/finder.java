package desafioLikes;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector.*;
import java.util.stream.Collectors;

public class finder {
	public static void main(String... arg) {
		try {
			// creo el objeto file para leer los datos del archivo
			File file = new File(
					"D:\\Hector Calderon\\Documents\\Eclipse_Workspace\\Likes\\src\\desafioLikes\\likes.txt");
			Scanner sc = new Scanner(file);

			// creo los arreglos a usar
			ArrayList<String> dataFoto = new ArrayList<String>();
			ArrayList<String> order = new ArrayList<String>();
			ArrayList<Integer> count = new ArrayList<Integer>();
			ArrayList<String> oCFoto = new ArrayList<String>();

			// guardo en el arreglo dataFoto los datos del archivo
			while (sc.hasNext()) {
				dataFoto.add(sc.next());
				order.add(sc.next());
			}

			// elimino datos repetidos y ordeno de menor a mayor
			Set<String> hashSet = new HashSet<String>(order);
			order.clear();
			order.addAll(hashSet);
			Collections.sort(order);
			System.out.println(order);

			// realizo conteo de datos, guardo en arreglo count y concateno los datos
			// filtrados y el conteo de los mismos en oCFoto
			for (String value : order) {
				int conteo = (int) dataFoto.stream().filter(c -> c.compareTo(value) == 0).count();
				count.add(conteo);
			}
			for (int i = 0; i < order.size(); i++) {
				oCFoto.add(order.get(i).concat(": " + count.get(i)));
			}

			// busco por el mayor y menor numero de datos repetidos
			int mayor = (int) count.stream().max(Comparator.naturalOrder()).get();
			int menor = (int) count.stream().min(Comparator.naturalOrder()).get();

			// guardo en el arreglo correspondientes las coincidencias menores o mayores
			List<String> listaMayor = oCFoto.stream().filter(c -> c.contains(String.valueOf(mayor)))
					.collect(Collectors.toList());
			List<String> listaMenor = oCFoto.stream().filter(c -> c.contains(String.valueOf(menor)))
					.collect(Collectors.toList());
			
			//comienzo a imprimir la informacion solicitada

			for(int z=0;z<oCFoto.size();z++) {
			System.out.println(oCFoto.get(z));}
			if (listaMayor.size() == 1) {
				String max = listaMayor.get(0);
				System.out.println("La foto con mas likes es: " + max.substring(0, 5) + " con " + mayor);
			} else {
				for (String z : listaMayor) {
					String max = listaMayor.get(0);
					System.out.println("La foto con mas likes es: " + max.substring(0, 5) + " con " + mayor);
				}
			}
				if (listaMenor.size() == 1) {
					String min = listaMenor.get(0);
					System.out.println("La foto con menos likes es: " + min.substring(0, 5) + " con " + menor);
				} else {
					for (String z : listaMayor) {
						String min = listaMayor.get(0);
						System.out.println("La foto con mas likes es: " + min.substring(0, 5) + " con " + menor);
					}
				}
				int promedio=0;
				int suma;
				for(int c=0;c<count.size();c++) {
					suma=count.get(c);
					promedio=promedio+suma;
				}
				promedio=promedio/count.size();
				System.out.println("El promedio de likes por foto es: "+promedio);
			
		} catch (FileNotFoundException e) {

		}
	}
}