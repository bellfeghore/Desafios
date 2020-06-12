import java.util.*;
public class fechas {
	public static void main(String[] arg) {
		String persona1,persona2,y1,y2,z1,z2,q1,q2;
		int a1,a2,m1,m2,d1,d2;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Ingrese la Fecha de nacimiento de la primera persona");
		System.out.println("DD/MM/AAAA");
		persona1=scan.next();
		System.out.println("Ingrese la Fecha de nacimiento de la segunda persona");
		System.out.println("DD/MM/AAAA");
		persona2=scan.next();
		//extraemos datos de año
		y1= persona1.substring(6, 10);
		a1= Integer.parseInt(y1);
		y2= persona2.substring(6, 10);
		a2= Integer.parseInt(y2);
		if(a1==a2) {
			//extraemos datos de mes
			z1= persona1.substring(3, 5);
			m1= Integer.parseInt(z1);
			z2= persona2.substring(3, 5);
			m2= Integer.parseInt(z2);
			if(m1==m2) {
				//extraemos datos de dia
				q1= persona1.substring(0, 2);
				d1= Integer.parseInt(q1);
				q2= persona2.substring(0, 2);
				d2= Integer.parseInt(q2);
				if(d1==d2) {

					System.out.println("Las dos personas tienen la misma edad");
				}
				else {
					if(d1<d2) {
						System.out.println("La segunda persona es mayor");
						
					}
					else {
						System.out.println("La primera persona es mayor");
						
					}
				}
			}
			else {
				if(m1<m2) {
					System.out.println("La segunda persona es mayor");
					
				}
				else {
						System.out.println("La primera persona es mayor");
						
				}
			}
		}
		else {
			if(a1<a2) {
				System.out.println("La segunda persona es mayor");
			}
			else {
					System.out.println("La primera persona es mayor");
					
				
			}
		}
	}
}