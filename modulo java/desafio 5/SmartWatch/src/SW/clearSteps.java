package SW;

import java.util.ArrayList;

public class clearSteps {
	static void pasos (ArrayList<String> LimpiarPasos) {
		ArrayList<Integer> filtro = new ArrayList<Integer>();
		for(int i=0;i<LimpiarPasos.size();i++) {
			filtro.add(Integer.parseInt(LimpiarPasos.get(i)));
		}
		for(int o=0; o<filtro.size();o++) {
			if(filtro.get(o)<=200) {
				filtro.remove(o);
			}
			else {
				if(filtro.get(o)>=100000) {
					filtro.remove(o);
				}
			}
		}
		int promedio=0;
		for(int x=0;x<filtro.size();x++) {
			promedio+=filtro.get(x);
			promedio= promedio/filtro.size();
		}
		System.out.println(filtro);
		System.out.println(promedio);
		
	}
}
