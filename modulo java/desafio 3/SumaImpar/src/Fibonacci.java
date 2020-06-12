import java.util.*;
public class Fibonacci {
	public static void main (String...arg) {
		Scanner scan = new Scanner(System.in);
		int  max,f1=0,f2=1,suma=1, i=0;
		System.out.println("Ingrese un valor");
		max= scan.nextInt();
		System.out.println(f1);
		System.out.println(f2);
		while(i<=max) {
				suma =f1+f2;
				f1=f2;
				f2=suma;
				System.out.println(suma);
				i++;
		}
		
	}
}
