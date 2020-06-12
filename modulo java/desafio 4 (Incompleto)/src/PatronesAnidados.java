import java.util.*;
public class PatronesAnidados {
	public static void main (String...arg) {
		Scanner scan = new Scanner(System.in);
		int valor;
		System.out.println("Ingrese un valor entre 1 y 6");
			valor = scan.nextInt();
			if(valor<=5) {
			Patron1(valor);
			Patron2(valor);
			Patron3(valor);
			Patron4(valor);
			}else {
				if(valor==6) {
					Patron3(valor);
					Patron4(valor);
				}
				else {
					System.out.print("Ingrese un valor valido");
				}
		}
	}
	static void Patron1 (int valor) {
		int i=0;
		String patron = "";
		while(i<valor) {
			if(i==0) {
				for(int a = 0; a<valor;a++) {
					patron=patron.concat("*");
				}
				
				System.out.println(patron);
				patron = "";
				i++;
			}
			else {
				if(i==valor-1) {
					for(int a = 0; a<valor;a++) {
						patron=patron.concat("*");
					}
					System.out.println(patron);
					patron = "";
					i++;
				}
				
				else {
						int a = 0;
						while(a<valor) {
							if(a==0) {
									patron=patron.concat("*");
									a++;
							}
							else {
								if(a==valor-1) {
									patron=patron.concat("*");
									a++;
								}
								else {
									patron=patron.concat(" ");
									a++;
								}
							}
							
						}
						i++;
						System.out.println(patron);
						patron = "";
					}
				}
			}
			
		}
	static void Patron2 (int valor) {
		int a = 0;
		String patron = "";
		for(int f = 0 ;f<valor;f++) {
			for(int c = 0;c<valor;c++) {
				if(f==0||f==valor-1||c==valor-1-f) {
					System.out.print("*");
				} else{
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
	static void Patron3 (int valor) {
		
		for(int f=0;f<valor;f++){
	    	for(int c=0;c<valor;c++){      
	    		if(c==f || c==valor-1-f) {
                        System.out.print("X");
	    		}else {

                    System.out.print(" ");
	    		}
	    	}
	    	System.out.println();
	}
	}
	static void Patron4 (int valor) {
		for(int f=0;f<valor;f++){
			for(int c=0;c<valor;c++){      
			if(f==0&&c!=valor-1) {
			 System.out.print("*");
			   	}else {
			   		if(c==0&&f!=0){
				   		System.out.print(" ");
			    		}else {
				   			if(c==valor-1&&f!=valor-1) {
						  			System.out.print(" ");
				    		}else {
				    			if(f==valor-1&&c!=0) {
				    				System.out.print("*");		    				
				    			}else {
				    				if(c!=0&&c!=valor-1) {
				    					System.out.print("*");
				    				}
				    			}
				    		}	
				    	}
			    	}
			    }System.out.println();
			}
	}
}
