package Methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class Excel implements Exp {
	@Override	 
	 public ArrayList Leer(String ruta) throws Exception{
		ArrayList<Articulos> lista = new ArrayList<Articulos>();	
		File archivo = new File(ruta);
		if (archivo.exists()) {
			FileInputStream file = new FileInputStream(new File(ruta));
			  HSSFWorkbook workbook = new HSSFWorkbook(file);
		      HSSFSheet sheet = workbook.getSheetAt(0);
		      int rows = sheet.getLastRowNum();
		      HSSFRow fila;
		      HSSFCell Cell;
		      int cols =0;
		      String CellValue;
		      for(int i = 0; i <= rows ; i++) {
					fila = sheet.getRow(i);
					if (fila == null) {
						break;
					} else {
						
						if (fila.getCell(0).getNumericCellValue() == 0 ){
							Libros libro = new Libros(
									fila.getCell(0).getNumericCellValue(),
									fila.getCell(3).getStringCellValue(),
									fila.getCell(2).getStringCellValue(),
									fila.getCell(1).getNumericCellValue(),
									fila.getCell(6).getBooleanCellValue(),
									fila.getCell(5).getStringCellValue(),
									fila.getCell(4).getNumericCellValue()
									);
							lista.add(libro);
						}else {
							Peliculas pelicula = new Peliculas(
									fila.getCell(0).getNumericCellValue(),
									fila.getCell(3).getStringCellValue(),
									fila.getCell(2).getStringCellValue(),
									fila.getCell(1).getNumericCellValue(),
									fila.getCell(6).getBooleanCellValue(),
									fila.getCell(4).getNumericCellValue(),
									fila.getCell(5).getStringCellValue()
									); 
						  	lista.add(pelicula);
						}
						
					}	 
				}
		} else {
			System.out.println("Problema en Ruta al leer Archivo: Ruta -> " + ruta);
		}
		return lista;
	 }
	
	
	
	@Override	 
	 public int LeerUsuarios(String ruta, String usuario, String clave) throws Exception{
		int idExcel=-1;
		int salida = -1;			
		File archivo = new File(ruta);
				if(archivo.exists()) {
			FileInputStream file = new FileInputStream(new File(ruta));
			  HSSFWorkbook workbook = new HSSFWorkbook(file);
		      HSSFSheet sheet = workbook.getSheetAt(0);
		      int rows = sheet.getLastRowNum();
		      HSSFRow fila;
		      
			HSSFCell Cell;
		      int cols =0;
		      
			String CellValue;
		      for(int i = 0; i <= rows ; i++) {
					fila = sheet.getRow(i);
					if (fila == null) {
						salida = 0;
					} else {
						if ((fila.getCell(0).getStringCellValue().compareTo(usuario) == 0 )  && 
							(fila.getCell(1).getStringCellValue().compareTo(clave)== 0)) {
  				    	    if (fila.getCell(2) != null) {
								if (fila.getCell(2).getBooleanCellValue()== false) {								
									idExcel=i;
									salida = i;
								}else {
									System.out.println("Usuario utilizando otra estacion...");
									salida =  -1;	
								}
  				    	    }else {
  				    	    	idExcel=i;
								salida = i;
  				    	    }
						}
							
					}	 
				}
		      	try {
					
					 workbook.close();
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
		} else {
			System.out.println("Problema en Ruta al leer Archivo: Ruta -> " + ruta);
			salida =  -1;
		}
		if (salida>-1) {
			UpdateExcel(ruta,1,idExcel);
		}
		return salida;
		
	 }

	
	
	
	@Override	 
	 public ArrayList ExcelUsuariosArray(String ruta) throws Exception{
		ArrayList<Users> lista = new ArrayList<Users>();				
		File archivo = new File(ruta);
		if (archivo.exists()) {
			FileInputStream file = new FileInputStream(new File(ruta));
			  HSSFWorkbook workbook = new HSSFWorkbook(file);
		      HSSFSheet sheet = workbook.getSheetAt(0);
		      int rows = sheet.getLastRowNum();
		      HSSFRow fila;
		      HSSFCell Cell;
		      int cols =0;
		      String CellValue;
		      for(int i = 0; i <= rows ; i++) {
					fila = sheet.getRow(i);
					if (fila == null) {
						break;
					} else {
						Users users = new Users(									
									fila.getCell(0).getStringCellValue(),
									fila.getCell(1).getStringCellValue(),
									true
									);
							lista.add(users);						
							
					}	 
				}
		} else {
			System.out.println("Problema en Ruta al leer Archivo: Ruta -> " + ruta);
		}
		return lista;
	 }


	
	 public void UpdateExcel(String ruta, int tipoUpdate,int filaExcel) throws Exception {
		  
		  FileInputStream file = new FileInputStream(new File(ruta));
		  HSSFWorkbook workbook = new HSSFWorkbook(file);
	      HSSFSheet sheet = workbook.getSheetAt(0);
	      
	      HSSFRow fila = sheet.getRow(filaExcel);
	      
	      if (tipoUpdate == 1) {
	    	  if (fila.getCell(2) != null) {
		    	  if (fila.getCell(2).getBooleanCellValue()== false) {
		    		  fila.createCell(2).setCellValue(true);
		    	  } else {
		    		  fila.createCell(2).setCellValue(false);
		    	  }
	    	  } else {
	    		  fila.createCell(2).setCellValue(true);
	    	  }
		}else {
			if (fila.getCell(6) != null) {
		    	  if (fila.getCell(6).getBooleanCellValue()== false) {
		    		  fila.createCell(6).setCellValue(true);
		    	  } else {
		    		  fila.createCell(6).setCellValue(false);
		    	  }
	    	  } else {
	    		  fila.createCell(6).setCellValue(true);
	    	  }
			}
	        try {
				 FileOutputStream fichero = new FileOutputStream(ruta);
				 workbook.write(fichero);
				 fichero.close();
				 workbook.close();
				 } catch (Exception e) {
				 e.printStackTrace();
			 }
			 try {
				 workbook.close();
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
	    }



	
	
}

