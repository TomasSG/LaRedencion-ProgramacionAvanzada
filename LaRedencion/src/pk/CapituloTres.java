package pk;

import java.math.BigInteger;
import java.util.ArrayList;

public class CapituloTres {

	private static final String PAHT_IN_3 = "in/03.in";
	private static final String PAHT_OUT_3 = "out/capitulo3.out";
	private static final String PAHT_OUT_2 = "out/capitulo2.out";

	public static void main(String[] args) {
		ArrayList<String> stringNro1 = FileManager.leerArchivo(PAHT_IN_3);
		ArrayList<String> stringNro2 = FileManager.leerArchivo(PAHT_OUT_2);
		BigInteger nro1=new BigInteger(stringNro1.get(0));
		BigInteger nro2=new BigInteger(stringNro2.get(0));
		String stringNro  = nro1.add(nro2).toString();
		int[] valores = new int[stringNro.length() / 3];
		int j = 0;
		for (int i = 0; i < stringNro.length(); i++) {
			String nroParcial = String.valueOf(stringNro.charAt(i)) + String.valueOf(stringNro.charAt(++i))
					+ String.valueOf(stringNro.charAt(++i));
			valores[j] = Integer.valueOf(nroParcial);
			j++;
		}
		ArrayList<String> solucion = new ArrayList<String>();
		for(int i = 0; i < valores.length; i++) {
			solucion.add(Character.toString((char)valores[i]));
		}
		FileManager.escribirArchivo(PAHT_OUT_3, solucion);
		for(String s: solucion) {
			System.out.print(s);
		}
	}
}
