package Methods;
import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.util.ArrayList;


	import org.apache.poi.hssf.usermodel.HSSFRow;
	import org.apache.poi.hssf.usermodel.HSSFSheet;
	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	import org.apache.poi.ss.usermodel.Row;
	import Methods.Despacho;

public class Excel implements Exportador {
		
		
		 public void exportar(ArrayList<Despacho> lista, String ruta) {
			HSSFSheet hoja;
			String separador = System.getProperty("file.separator");		
			File archivo = new File(ruta + separador + "Despacho_.xls");
			if (!archivo.exists()) {
				 HSSFWorkbook libro = new HSSFWorkbook(); 
				 hoja = libro.createSheet();

				 Row header = hoja.createRow(0);
				 header.createCell(0).setCellValue("direccionDespacho");
				 header.createCell(1).setCellValue("nombreCliente");
				 header.createCell(2).setCellValue("productos");
				 header.createCell(3).setCellValue("montoTotal");
				 header.createCell(4).setCellValue("fecha");
			 
				 for(int i = 0; i < lista.size() ; i++) {
					 HSSFRow fila = hoja.createRow((short) i + 1);
					 fila.createCell(0).setCellValue(lista.get(i).getDireccionDespacho());
					 fila.createCell(1).setCellValue(lista.get(i).getNombreCliente());
					 fila.createCell(2).setCellValue(lista.get(i).getProductos());
					 fila.createCell(3).setCellValue(lista.get(i).getMontoTotal());
					 fila.createCell(4).setCellValue(lista.get(i).getFechaCompra());			 
				 }
				 try {
					 FileOutputStream elFichero = new FileOutputStream(ruta + separador + "Despacho_.xls");
					 libro.write(elFichero);
					 elFichero.close();
					 libro.close();
					 } catch (Exception e) {
					 e.printStackTrace();
				 }
				 try {
					 libro.close();
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
			} else {			
				try {
					UpdateExcel(lista,ruta + separador + "Despacho_.xls");
				} catch (Exception e) {				
					e.printStackTrace();
				}
			}
		 }

		
		  
		  private static void UpdateExcel(ArrayList<Despacho> lista, String ruta) throws Exception {		  
			  FileInputStream file = new FileInputStream(new File(ruta));
			  HSSFWorkbook workbook = new HSSFWorkbook(file);
		      HSSFSheet sheet = workbook.getSheetAt(0);
		      int rows = sheet.getLastRowNum();
		      for(int i = 0; i < lista.size() ; i++) {
					 HSSFRow fila = sheet.createRow((short) rows + 1);
					 fila.createCell(0).setCellValue(lista.get(i).getDireccionDespacho());
					 fila.createCell(1).setCellValue(lista.get(i).getNombreCliente());
					 fila.createCell(2).setCellValue(lista.get(i).getProductos());
					 fila.createCell(3).setCellValue(lista.get(i).getMontoTotal());
					 fila.createCell(4).setCellValue(lista.get(i).getFechaCompra());			 
				}
		        try {
					 FileOutputStream elFichero = new FileOutputStream(ruta);
					 workbook.write(elFichero);
					 elFichero.close();
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

