import java.util.Scanner;

public class SoloPares2 {
	public static void main (String...Arg) {
		int valor;
		int i =0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese un numero");
		valor=scan.nextInt();
		while(i<valor||i>valor) {
			i++;
			if(i%2==0) {
				System.out.println(i);
			}
		
		}
	}
}
