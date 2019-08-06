package pk;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class CapituloCinco {
	private static final String PAHT_IN = "in/05.in";
	private static final String PAHT_OUT = "out/capitulo5.out";
	private static String[] nros;	
	
	public static void main(String[] args) {
		nros = FileManager.leerArchivo(PAHT_IN).get(0).split(",");
		String[] resultado = new String[nros.length];
		for(int i = 0; i < nros.length; i++) {
			int nro;
			if(nros[i].contains(" ")) {
				nro = Integer.parseInt(nros[i].substring(1));
			} else {
				nro = Integer.parseInt(nros[i]);
			}
			if(nro > 1476) {
				resultado[i] = "#";
			}else {
				resultado[i] = " ";
			}
		}
		System.out.println(resultado.length);
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(PAHT_OUT));
			for(int i = 136; i < 250; i++) {
				for(int j = 0; j < nros.length; j++) {
					if(j%i==0) {
						pw.print("\n");
						pw.print(resultado[j]);
					} else {
						pw.print(resultado[j]);
					}
				}
				pw.print("\n\n\n");
			}
			pw.close();
		} catch (IOException e) {
			System.out.println("No se pudo encontrar el archivo para escribir en " + PAHT_OUT);
		}
	}
}
