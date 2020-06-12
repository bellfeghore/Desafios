package Methods;

import java.util.ArrayList;

public interface Exp {
	
	ArrayList Leer(String ruta) throws Exception;
	ArrayList ExcelUsuariosArray(String ruta) throws Exception;

	void UpdateExcel(String ruta, int tipoUpdate, int filaExcel) throws Exception;
	int LeerUsuarios(String ruta, String usuario, String clave) throws Exception;

}
