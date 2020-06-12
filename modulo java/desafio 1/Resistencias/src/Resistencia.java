import java.util.Scanner;

public class Resistencia {
	public static void main (String...arg) {
		System.out.println("Ingrese el valor de las 3 resistencias");
		Scanner scan = new Scanner(System.in);
		float a,s,d,f;
		a=scan.nextFloat();
		if(a<=0) {
			System.out.println("No puede ingresar un valor menor o igual a 0");
		}
		s=scan.nextFloat();
		if(s<=0) {
			System.out.println("No puede ingresar un valor menor o igual a 0");
		}
		d=scan.nextFloat();
		if(d<=0) {
			System.out.println("No puede ingresar un valor menor o igual a 0");
		}
		f=(1/((1/a)+(1/s)+(1/d)));
		System.out.println("Su RT es: " + f);
	}
}
