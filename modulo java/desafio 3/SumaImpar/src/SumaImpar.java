import java.util.*;
public class SumaImpar {
	public static void main (String...arg) {
		Scanner scan = new Scanner(System.in);
		int valor;
		int suma=0, i=0;
		
		System.out.println("Ingrese un numero");
		valor = scan.nextInt();
		while(i<=valor) {
			if(i%2==0) {
				
			}else {
				suma+=i;
				
			}
		i++;
		}
		System.out.println(suma);
	}
}
