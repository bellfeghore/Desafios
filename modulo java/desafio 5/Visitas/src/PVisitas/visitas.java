package PVisitas;

import java.util.*;

public class visitas {
	public static void main (String...arg) {
		promedio calculo = new promedio();
		ArrayList<Integer> listado = new ArrayList<Integer>();
		for (String visitas:arg) {
			listado.add(Integer.parseInt(visitas));
		}
		calculo.average(listado);

	}
}
