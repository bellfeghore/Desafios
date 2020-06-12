package MDT;

import java.util.ArrayList;

public class Filtro {
	static void average (ArrayList<Integer> pr) {
		for(int a=0;a<pr.size();a++) {
			if(pr.get(a)%3!=0) {
				pr.remove(a);
				a--;
			}
		}
		Suma.sum(pr);
		promedio.average(pr);
	}
}
