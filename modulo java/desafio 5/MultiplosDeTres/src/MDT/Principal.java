package MDT;

import java.util.ArrayList;

public class Principal {
	public static void main (String...arg) {
		ArrayList<Integer> multiple = new ArrayList<Integer>();
		for (String dato:arg) {
			multiple.add(Integer.parseInt(dato));
		}
		Filtro.average(multiple);
	}
	
}
