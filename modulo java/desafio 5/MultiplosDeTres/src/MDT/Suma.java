package MDT;

import java.util.ArrayList;

public class Suma {
	static void sum(ArrayList<Integer> ad) {
		int resultado=0;
		for(int r:ad) {
			resultado+=r;
		}
		System.out.println(resultado);
	}
}
