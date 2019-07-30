package pk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileManager {
	public static void escribirArchivo(String path, ArrayList<String> texto) {
		try {
			PrintWriter pw = new PrintWriter(new File(path));
			for(String s : texto) {
				pw.println(s);
			}
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo encontrar el archivo en : " + path);
		}
	}
	
	public static ArrayList<String> leerArchivo(String path){
		try {
			Scanner sc = new Scanner(new File(path));
			ArrayList<String> texto = new ArrayList<String>();
			sc.useLocale(Locale.ENGLISH);
			while(sc.hasNext()) {
				texto.add(sc.nextLine());
			}
			sc.close();
			return texto;
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo encontrar el archivo en : " + path);
		}
		return null;
	}
}
