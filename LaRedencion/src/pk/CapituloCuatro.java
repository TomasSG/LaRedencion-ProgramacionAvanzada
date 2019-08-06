package pk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CapituloCuatro {
	private static final String PAHT_IN = "in/04.in";
	private static final String PAHT_OUT = "out/capitulo4.out";
	private static final int[][] matAdy = new int[100][100];
	private static final String[] ciudades = new String[100];
	private int[] padres;

	public CapituloCuatro(String path) {
		try {
			Scanner sc = new Scanner(new File(path));
			sc.useLocale(Locale.ENGLISH);
			int cantLineas = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < cantLineas; i++) {
				ciudades[i] = sc.nextLine();
			}
			while (sc.hasNext()) {
				int fil = sc.nextInt(), col = sc.nextInt(), val = sc.nextInt();
				matAdy[fil][col] = val;
				matAdy[col][fil] = val;
			}
			sc.close();
			rellenarMatrizAdyacencia();
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir el archivo en " + path);
		}
	}

	private void rellenarMatrizAdyacencia() {
		for (int i = 0; i < matAdy.length; i++) {
			for (int j = 0; j < matAdy.length; j++) {
				if (matAdy[i][j] == 0) {
					matAdy[i][j] = Integer.MAX_VALUE;
					matAdy[j][i] = Integer.MAX_VALUE;
				}
			}
		}

	}

	private boolean existe(int nodo, ArrayList<Integer> s) {
		for (Integer valor : s) {
			if (valor.equals(nodo)) {
				return true;
			}
		}
		return false;
	}

	private int buscarMenorNodo(int[] d, ArrayList<Integer> s) {
		int menorValor = Integer.MAX_VALUE;
		int menorPos = -1;
		for (int i = 0; i < d.length; i++) {
			if (d[i] < menorValor && !existe(i, s)) {
				menorValor = d[i];
				menorPos = i;
			}
		}
		return menorPos;
	}

	private boolean existeOtroCamino(int[] costos, int nodoIntermedio, int nodoFin) {
		return costos[nodoIntermedio] != Integer.MAX_VALUE && matAdy[nodoIntermedio][nodoFin] != Integer.MAX_VALUE
				&& costos[nodoFin] > costos[nodoIntermedio] + matAdy[nodoIntermedio][nodoFin];
	}

	public int[] dijkstraConCamino(int nodoIni) {
		int[] costos = matAdy[nodoIni].clone();
		padres = new int[matAdy.length];
		for (int i = 0; i < padres.length; i++) {
			padres[i] = nodoIni;
		}
		ArrayList<Integer> conjuntoSolucion = new ArrayList<Integer>();
		conjuntoSolucion.add(nodoIni);
		while (conjuntoSolucion.size() < matAdy.length) {
			int menorNodo = buscarMenorNodo(costos, conjuntoSolucion);
			if (menorNodo != -1) {
				conjuntoSolucion.add(menorNodo);
				for (int i = 0; i < costos.length; i++) {
					if (!existe(i, conjuntoSolucion)) {
						if (existeOtroCamino(costos, menorNodo, i)) {
							costos[i] = costos[menorNodo] + matAdy[menorNodo][i];
							padres[i] = menorNodo;
						}
					}
				}
			} else {
				System.out.println("Paso por aca");
			}
		}
		return costos;
	}

	public ArrayList<Integer> reconstruirCamino(int nodoFin) {
		int i = nodoFin;
		ArrayList<Integer> solucion = new ArrayList<Integer>();
		solucion.add(nodoFin);
		while (padres[i] != i) {
			i = padres[i];
			solucion.add(i);
		}
		return solucion;
	}

	private static int buscarNodoDeCiudad(String string) {
		for (int i = 0; i < ciudades.length; i++) {
			if (ciudades[i].equals(string)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		CapituloCuatro c = new CapituloCuatro(PAHT_IN);
		ArrayList<String> solucion = new ArrayList<String>();
		int nodoIni = buscarNodoDeCiudad("Snagov");
		int nodoFin = buscarNodoDeCiudad("Chisinau");
		int[] costos = c.dijkstraConCamino(nodoIni);
		solucion.add(String.valueOf(costos[nodoFin]));
		ArrayList<Integer> camino = c.reconstruirCamino(nodoFin);
		String caminoCompleto = new String();
		for (int i = camino.size() - 1; i >= 0; i--) {
			if (i == 0) {
				caminoCompleto += ciudades[camino.get(i)];
			} else {
				caminoCompleto += ciudades[camino.get(i)] + " -> ";
			}
		}
		solucion.add(caminoCompleto);
		FileManager.escribirArchivo(PAHT_OUT, solucion);
	}

}
