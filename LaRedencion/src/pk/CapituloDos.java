package pk;

import java.util.ArrayList;
import java.math.BigInteger;

public class CapituloDos {

	private static final String PATH = "out/capitulo2.out";
	private static final int POS = 6880;

	public static void main(String[] args) {
		ArrayList<String> texto = new ArrayList<String>();
		texto.add(calcularNroEn(POS));
		FileManager.escribirArchivo(PATH, texto);
	}

	private static String calcularNroEn(int pos) {
		BigInteger nroAnt = new BigInteger("-1"), nroAct =new BigInteger("6");
		if (pos == 0) {
			return "0";
		}
		if (pos == 1) {
			return "-1";
		} else if (pos == 2) {
			return "6";
		} else if (pos < 0) {
			return null;
		}
		for (long i = 0; i < pos - 2; i++) {
			BigInteger aux = nroAct.abs();
			nroAct = nroAct.add(nroAnt);
			nroAnt = aux.abs();
		}
		return String.valueOf(nroAct);
	}
}
