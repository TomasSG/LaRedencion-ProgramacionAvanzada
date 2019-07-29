package pk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CapituloDos {
	
	private static final String PATH = "out/capitulo2.out";
	private static final int POS = 6880;
	
	public static void main(String[] args) {
		ArrayList<String> texto = new ArrayList<String>();
		texto.add(calcularNroEn(POS));
		FileManager.escribirArchivo(PATH, texto);
	}

	private static String calcularNroEn(int pos) {
		String nroAnt = "-1", nroAct = "6";
		ArrayList<String> solucion = new ArrayList<String>();
		if(pos == 0) {
			return "0";
		}
		if(pos == 1) {
			return "-1";
		}
		if(pos == 2) {
			return "6";
		}
		if(pos < 0) {
			return null;
		}
		for(long i = 0; i < pos - 2; i++) {
			if(nroAct.length() == 65000) {
				solucion.add(nroAct);
			}
			String aux = nroAct;
			nroAct= nroAnt + nroAct;
			nroAnt = aux;
		}
		return String.valueOf(nroAct);
	}
}
