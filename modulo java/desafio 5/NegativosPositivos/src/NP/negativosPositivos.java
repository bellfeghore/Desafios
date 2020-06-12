package NP;

import java.util.ArrayList;

public class negativosPositivos {
	public static void main (String...arg) {
		ArrayList<Integer> listado = new ArrayList<Integer>();
		for(String n:arg) {
			listado.add(Integer.parseInt(n));
		}
		counters.contadores(listado);
	}
}
