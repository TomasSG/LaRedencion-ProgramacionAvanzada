package pk;

import java.util.ArrayList;

public class CapituloTres {

	private static final String PAHT_IN_3 = "in/03.in";
	private static final String PAHT_OUT_3 = "out/capitulo3.out";
	private static final String PAHT_OUT_2 = "out/capitulo2.out";

	public static void main(String[] args) {
		ArrayList<String> stringNro1 = FileManager.leerArchivo(PAHT_IN_3);
		ArrayList<String> stringNro2 = FileManager.leerArchivo(PAHT_OUT_2);
		String secMalvodavo = new String(stringNro2.get(0));
		String secEncriptado = new String(stringNro1.get(0));
		char[] frase = new char[secEncriptado.length()/3 + 1];
		ArrayList<String> resultado = new ArrayList<String>();
		int j = 0;
		for(int i = 0; i < secMalvodavo.length() && i < secMalvodavo.length(); i+=3) {
			int nroMaldovado,nroEncriptado;
			if(i==1437) {
				nroMaldovado = Integer.parseInt(secMalvodavo.substring(i,1439));
				nroEncriptado = Integer.parseInt(secEncriptado.substring(i,1439));
			} else {
			nroMaldovado = Integer.parseInt(secMalvodavo.substring(i,i+3));
			nroEncriptado = Integer.parseInt(secEncriptado.substring(i,i+3));
			}
				
			int res = (int) Math.abs(nroMaldovado ^ nroEncriptado);
			frase[j++] = (char)res;
		}
		resultado.add(String.valueOf(frase));
		FileManager.escribirArchivo(PAHT_OUT_3, resultado);
	}
}
