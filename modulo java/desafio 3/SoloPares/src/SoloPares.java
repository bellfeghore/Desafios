import java.util.*;
public class SoloPares {
	public static void main (String...Arg) {
		int valor;
		int i =0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese un numero");
		valor=scan.nextInt();
		while(i<valor||i>valor) {
			if(i%2==0) {
				System.out.println(i);
			}
			i++;
		}
	}
}
