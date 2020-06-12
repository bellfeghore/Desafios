package NP;

import java.util.ArrayList;

public class counters {
	static void contadores (ArrayList<Integer> list) {
		ArrayList<Integer> n = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		ArrayList<Integer> p = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i)<0) {
				n.add(list.get(i));
			}else {
				if(list.get(i)==0) {

					c.add(list.get(i));
				}else {

					p.add(list.get(i));
				}
			}
		}
		System.out.println("candidad de");
		System.out.println("Negativos: "+n.size());
		System.out.println("Ceros: "+c.size());
		System.out.println("Positivos:"+p.size());
	}
}
