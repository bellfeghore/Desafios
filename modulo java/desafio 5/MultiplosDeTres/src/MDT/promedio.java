package MDT;

import java.util.ArrayList;

public class promedio {
	static void average (ArrayList<Integer> av) {
		int suma=0,resultado;
		for(int i = 0; i<av.size();i++) {
			suma+=av.get(i);
		}
		resultado=suma/av.size();
		System.out.println(resultado);
	}
}
