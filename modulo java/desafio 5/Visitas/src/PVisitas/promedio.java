package PVisitas;

import java.util.*;

public class promedio {
	public void average(ArrayList <Integer> pr ){
		int p=0;
		
		for (int i=0;i<pr.size();i++) {
			p+=pr.get(i);
		}
		int resultadoPromedio = p/pr.size();
		System.out.println(resultadoPromedio);
	}
}
