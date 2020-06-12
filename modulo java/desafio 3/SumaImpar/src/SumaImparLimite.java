import java.util.*;
public class SumaImparLimite {
	public static void main (String...arg) {
		Scanner scan = new Scanner(System.in);
		int min, max,suma=0;
		System.out.println("Ingrese el valor minimo");
		min= scan.nextInt();
		System.out.println("Ingrese el valor maximo");
		max= scan.nextInt();
		while(min<=max) {
			if(min%2==0) {
				
			}
			else {
				suma+=min;
			}
			min++;
		}
		System.out.println(suma);
		
	}
}
