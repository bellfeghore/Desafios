package Methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class Configuracion {
	public static String formatoSalida() throws IOException{
		return Configuracion("formatoArchivos");
	}
	public static String rArticulos() throws IOException{
		return Configuracion("rArticulos");
	}
	public static String rUsuarios() throws IOException{
		return Configuracion("rUsuarios");
	}
	private static String Configuracion(String configuracion)throws IOException{
		BufferedReader lector = Files.newBufferedReader(Paths.get("config.txt"));
		String linea;
		while((linea=lector.readLine())!=null) {
			if(linea.contains(configuracion)) {
				return (linea.substring(linea.indexOf("=")+1, linea.indexOf(";")));
			}
		}
		throw new IOException("No se encuentra el archivo config.txt");
	}
}
