package pk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
}
