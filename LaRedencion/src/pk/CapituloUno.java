package pk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CapituloUno {

	/* Los circulos van desde afuera hacia adentro */

	private static final String[] circulo6 = { "4", "6", "7", "2", "3", "1", "8", "5", "0", "9" };
	private static final String[] circulo5 = { "4", "5", "1", "7", "9", "2", "8", "6", "0", "3" };
	private static final String[] circulo4 = { "4", "0", "8", "7", "1", "2", "9", "5", "3", "6" };
	private static final String[] circulo3 = { "1", "0", "8", "3", "9", "7", "2", "4", "6", "5" };
	private static final String[] circulo2 = { "6", "5", "7", "4", "0", "2", "1", "9", "3", "8" };
	private static final String[] circulo1 = { "6", "1", "8", "7", "4", "5", "2", "9", "0", "3" };
	private static final String PATH = "out/capitulo1.out";

	public static void main(String[] args) {
		ArrayList<String> resultado = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					for (int l = 0; l < 10; l++) {
						for (int m = 0; m < 10; m++) {
							for (int n = 0; n < 10; n++) {
								String stringNro1 = circulo6[i] + circulo5[j] + circulo4[k] + circulo3[l] + circulo2[m]
										+ circulo1[n];
								String stringNro2 = circulo6[10 - i - 1] + circulo5[10 - j - 1] + circulo4[10 - k - 1]
										+ circulo3[10 - l - 1] + circulo2[10 - m - 1] + circulo1[10 - n - 1];
									if (i + j + k + l + m + n == 10 && esNroVampiro(stringNro1, resultado)) {
										System.out.println("Encontrado!");
									}
									if (i + j + k + l + m + n == 10 && esNroVampiro(stringNro2, resultado)) {
										System.out.println("Encontrado!");

								}
							}						}
					}
				}
			}
		}
		FileManager.escribirArchivo(PATH, resultado);
	}

	private static boolean esNroVampiro(String stringNro, ArrayList<String> resultado) {
		int nro = Integer.valueOf(stringNro);
		for (int k = 0; k < 2000; k++) {
			char[] vecAux = new char[6];
			List<Character> listaAux = new ArrayList<Character>();
			copiarALista(stringNro, listaAux);
			Collections.shuffle(listaAux);
			copiarAVector(listaAux, vecAux);
			char[] val1 = { vecAux[0], vecAux[1], vecAux[2] };
			char[] val2 = { vecAux[3], vecAux[4], vecAux[5] };
			for (int i = 0; i < 3; i++) {
				int nro1, nro2;
				if (i == 0) {
					nro1 = Character.getNumericValue(val1[0]) * 100 + Character.getNumericValue(val1[1]) * 10
							+ Character.getNumericValue(val1[2]);
					nro2 = Character.getNumericValue(val1[0]) * 100 + Character.getNumericValue(val1[2]) * 10
							+ Character.getNumericValue(val1[1]);
				} else if (i == 1) {
					nro1 = Character.getNumericValue(val1[1]) * 100 + Character.getNumericValue(val1[2]) * 10
							+ Character.getNumericValue(val1[0]);
					nro2 = Character.getNumericValue(val1[1]) * 100 + Character.getNumericValue(val1[0]) * 10
							+ Character.getNumericValue(val1[2]);
				} else {
					nro1 = Character.getNumericValue(val1[2]) * 100 + Character.getNumericValue(val1[0]) * 10
							+ Character.getNumericValue(val1[1]);
					nro2 = Character.getNumericValue(val1[2]) * 100 + Character.getNumericValue(val1[1]) * 10
							+ Character.getNumericValue(val1[0]);
				}
				for (int j = 0; j < 3; j++) {
					int nro3, nro4;
					if (j == 0) {
						nro3 = Character.getNumericValue(val2[0]) * 100 + Character.getNumericValue(val2[1]) * 10
								+ Character.getNumericValue(val2[2]);
						nro4 = Character.getNumericValue(val2[0]) * 100 + Character.getNumericValue(val2[2]) * 10
								+ Character.getNumericValue(val2[1]);
					} else if (j == 1) {
						nro3 = Character.getNumericValue(val2[1]) * 100 + Character.getNumericValue(val2[2]) * 10
								+ Character.getNumericValue(val2[0]);
						nro4 = Character.getNumericValue(val2[1]) * 100 + Character.getNumericValue(val2[0]) * 10
								+ Character.getNumericValue(val2[2]);
					} else {
						nro3 = Character.getNumericValue(val2[2]) * 100 + Character.getNumericValue(val2[0]) * 10
								+ Character.getNumericValue(val2[1]);
						nro4 = Character.getNumericValue(val2[2]) * 100 + Character.getNumericValue(val2[1]) * 10
								+ Character.getNumericValue(val2[0]);
					}
					if (nro3 * nro1 == nro) {
						System.out.println("Colmillos: " + nro3 + " * " + nro1 + " = " + nro);
						resultado.add("Colmillos: " + nro3 + " * " + nro1 + " = " + nro);
						return true;
					} else if (nro3 * nro2 == nro) {
						System.out.println("Colmillos: " + nro3 + " * " + nro2 + " = " + nro);
						resultado.add("Colmillos: " + nro3 + " * " + nro2 + " = " + nro);
						return true;
					} else if (nro4 * nro1 == nro) {
						System.out.println("Colmillos: " + nro4 + " * " + nro1 + " = " + nro);
						resultado.add("Colmillos: " + nro4 + " * " + nro1 + " = " + nro);
						return true;
					} else if (nro4 * nro2 == nro) {
						System.out.println("Colmillos: " + nro4 + " * " + nro2 + " = " + nro);
						resultado.add("Colmillos: " + nro4 + " * " + nro2 + " = " + nro);
						return true;
					}
				}
			}
		}
		return false;
	}

	private static void copiarAVector(List<Character> listaAux, char[] vecAux) {
		for (int i = 0; i < listaAux.size(); i++) {
			vecAux[i] = listaAux.get(i);
		}

	}

	private static void copiarALista(String stringNro, List<Character> listaAux) {
		for (int i = 0; i < stringNro.length(); i++) {
			listaAux.add(stringNro.charAt(i));
		}
	}
}
