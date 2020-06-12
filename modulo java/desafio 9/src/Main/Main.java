package Main;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Methods.Articulo;
import Methods.Cesta;
import Methods.Despacho;
import Methods.Excel;
import Methods.Exportador;
import Methods.Pantalon;
import Methods.Poleron;
import Methods.Zapatos;


//Recordar ingresar direccion del archivo donde se guardara la orden(...\eclipse-workspace\CarritoDeCompras\src\Main), reemplazar los "..." por la direccion faltante

public class Main {
	public static ArrayList <Articulo> productos = new ArrayList<Articulo>();
	public static ArrayList <Cesta> carroCompra = new ArrayList<Cesta>();
	public static ArrayList<Despacho> ordenes = new ArrayList<Despacho>();
	public static Scanner sc = new Scanner(System.in);
	private static Exportador exportador;
	public static String ruta;
	public static void main(String[] args) {
		if (args.length > 0) {
			  for(String arg : args) {
				  ruta=arg.toString();				  
			  }
			  GuardarDatos();	
			  menu();
	  }else {
		  System.out.println("Debe Indicar ruta de almacenamiento Excel en argumentos...");
	  }
	}
    
	private static void menu() {
		int opcion =0;
		while (opcion==0) {		
			Separador();
			System.out.println("1.- Mostrar productos disponibles");
			System.out.println("2.- Agregar productos al carrito");
			System.out.println("3.- Pagar");
			System.out.println("4.- Salir");
			opcion = sc.nextInt();
			if ((opcion > 4) || (opcion < 0)) {
				opcion = 0;
			}
			switch (opcion) {
			case 1:
				Separador();
				productos.forEach(name -> System.out.println(name.toString()));
				Separador();
				opcion = 0;
				break;
			case 2:
				Separador();
				AgregarAlaCesta();
				opcion = 0;
				Separador();
				break;
			case 3:
				Separador();
				Pagar();
				opcion = 0;
				break;	
			}
		}
	}
	
	private static void Pagar() {
		int opcion =0;
		int TotalPago;
		if (carroCompra.size() > 0) {
			while (opcion==0) {		
				Separador();
				System.out.println("Cual es su medio de pago?");
				System.out.println("1.- Crédito");
				System.out.println("2.- Débito");			
				System.out.println("3.- Cancelar");
				opcion = sc.nextInt();
				if ((opcion > 3) || (opcion < 0)) {
					opcion = 0;
				}
				switch (opcion) {
				case 1:
					Separador();
					TotalPago = Pagar("Crédito");
					if (TotalPago > 0 ) {										
						if (ValidaCredito()) {
							Orden(TotalPago);		
							exportador = new Excel();
							exportador.exportar(ordenes,ruta);
							System.out.println("Orden de despacho generada correctamente...");
							carroCompra.clear();
						}	
					}
					Separador();					
					break;
				case 2:
					Separador();
					TotalPago = Pagar("Débito");
					if (TotalPago > 0 ) {
						Orden(TotalPago);						
						exportador = new Excel();
						exportador.exportar(ordenes,ruta);
						System.out.println("Orden de despacho generada correctamente...");
						carroCompra.clear();
					}
					
					Separador();					
					break;	
				}
			}
		} else {
			System.out.println("No posee productos en carro de compra...");
		}
	}
	
	private static boolean ValidaCredito() {
		int cuotas = -1;
		String confirma ="X";
	    while (cuotas ==-1) {				
			System.out.println("¿Con cuantas cuotas desea pagar ? (0-24)");			
			cuotas=sc.nextInt();
			if ((cuotas > 24) || (cuotas < 0)) {
				cuotas = -1;				
			}
	    }   
		while ((confirma.compareTo("Y") != 0) && (confirma.compareTo("N") != 0) ) {
		  	  System.out.println("¿Está seguro de pagar con " + cuotas + " cuotas ?");
			  System.out.println("Ingrese Y para si o N pana no");
			  confirma = sc.next();
		}									
		if (confirma.compareTo("Y") == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	private static void Orden(int TotalPago) {
		String direccionDespacho="";
		int ingresa =0;
		String nombreCliente="";
		String productos=null;
		int i=0;
		
		while (ingresa ==0) {				
			System.out.println("¿Cuál es la dirección de despacho?");
			direccionDespacho=sc.next();
			if (direccionDespacho.compareTo("")!=0) {
				ingresa =1;
			}			
		}
		ingresa=0;
		while (ingresa==0) {
			System.out.println("¿Cuál es nombre de quien recibe el producto?");
			nombreCliente=sc.next();
			if (nombreCliente.compareTo("")!=0) {
				ingresa =1;
			}
		}
		for(Cesta Carro : carroCompra) {
			if (Carro.getCodigo().compareTo("")!=0) {
				if (i==0) {
					productos = Carro.getCodigo();
				} else {
					productos += "," + Carro.getCodigo();
				}
				i++;
			}	
		}
		String fecha; 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		fecha = sdf.format(new Date());		
		Despacho ordenFinal = new Despacho(direccionDespacho, nombreCliente,productos,TotalPago,fecha);
		ordenes.add(ordenFinal);
	}
	
	private static int Pagar(String TipoPago) {
		int total =0;
		String confirma = "X";
		for(Cesta Carro : carroCompra) {
		    total += Carro.getPrecio();
		}
		while ((confirma.compareTo("Y") != 0) && (confirma.compareTo("N") != 0) ) {
			System.out.println("¿Está seguro de pagar con " + TipoPago + " el total de $" + total + "?");
			System.out.println("Ingrese Y para si o N pana no");
			confirma = sc.next();
		}									
		if (confirma.compareTo("Y") == 0) {
			return total;
		}else {
			return 0;
		}		
	}
	
	private static void AgregarAlaCesta() {
		String codigo = "";
		String confirma ="X";
		boolean encontrado=false;
		Cesta carro;
		
		while (codigo=="") {
			productos.forEach(name -> System.out.println(name.toString()));
			System.out.println("Ingrese el código del articulo que desea agregar");
			codigo= sc.next();
			for(Articulo lista : productos)
			{
				if ((lista.getCodigo().equals(codigo)) && (encontrado==false)) {
					System.out.println("¿Está seguro de agregar " +
							lista.getNombre() + " al carrito por $ "+
							lista.getPrecio() + " ?");
					encontrado = true;
					while ((confirma.compareTo("Y") != 0) && (confirma.compareTo("N") != 0) ) {
						System.out.println("Ingrese Y para si o N pana no");
						confirma = sc.next();
					}									
					if (confirma.compareTo("Y") == 0) {
						carro = new Cesta(lista.getCodigo(),lista.getPrecio());
						carroCompra.add(carro);
						System.out.println(lista.getNombre() + " agregado correctamente.");
					}
				}
			}
			if (!encontrado) {
				System.out.println("Codigo de producto inexistente.... ");
				codigo="";
			}
		}		
	}
	
	
	private static void Separador() {
		System.out.println("------------------------------------------------------------------------");
	}
	
	
	private static void GuardarDatos() {
		Pantalon pantalon = new Pantalon("Pantalón",15000,"Variant Caqui Corto","1000","30","Variant","Caqui",2 );
		productos.add(pantalon);
		
		pantalon = new Pantalon("Pantalón",15000,"Variant Caqui Corto","1000","30","Variant","Caqui",2 );
		productos.add(pantalon);
		
		pantalon = new Pantalon("Pantalón",19000,"Variant Negro Largo","1001","30","Variant","Negro",2 );
		productos.add(pantalon);
		
		Poleron poleron = new Poleron("Polerón",9000,"Variant Rojo","2002","29","Variant","Negro");
		productos.add(poleron);
		
		Zapatos zapato = new Zapatos("Zapato",25000,"Mega CZ50","3003","34","Mega","CZ50");
		productos.add(zapato);
		
		zapato = new Zapatos("Zapato",20000,"Mega CX50","3004","40","Mega","CX50");
		productos.add(zapato);		
	}
}