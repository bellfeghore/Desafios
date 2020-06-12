import java.util.Scanner;

public class Rectangulo {
	public static void main (String...arg) {
		int ancho,largo,a,p;
		float x,sa,sp,sancho,slargo;
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese el ancho del rectangulo");
		ancho=scan.nextInt();
		System.out.println("Ingrese el largo del rectangulo");
		largo=scan.nextInt();
		System.out.println("Cuan mas pequeño es el subrectangulo?(el valor no debe ser inferior al ancho o largo");
		x=scan.nextFloat();
		if(x>=ancho) {
			System.out.println("No se puede calcular un subrectangulo con esa medida");
		}
		if(x>=largo) {
			System.out.println("No se puede calcular un subrectangulo con esa medida");
		}
		a=ancho*largo;
		p=(2*ancho)+(2*largo);
		sancho=ancho-x;
		slargo=largo-x;
		sa=sancho*slargo;
		sp=(2*sancho)+(2*slargo);
		
		System.out.println("Su Area y perimetro es:");
		System.out.println(a + "    " + p);
		System.out.println(sa + "    " + sp);
	}
}
