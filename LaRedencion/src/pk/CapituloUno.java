package pk;

public class CapituloUno {
	
	/* Los circulos van desde afuera hacia adentro */
	
	private static final String [] circulo6 = {"0","9","4","6","7","2","3","1","8","5"};
	private static final String [] circulo5 = {"0","3","4","5","1","7","9","2","8","6"};
	private static final String [] circulo4 = {"3","6","4","0","8","7","1","2","9","5"};
	private static final String [] circulo3 = {"1","0","8","3","9","7","2","4","6","5"};
	private static final String [] circulo2 = {"6","5","7","4","0","2","1","9","3","8"};
	private static final String [] circulo1 = {"6","1","8","7","4","5","2","9","0","3"};
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; i < 10; i++) {
				for (int k = 0; i < 10; i++) {
					for (int l = 0; i < 10; i++) {
						for (int m = 0; i < 10; i++) {
							for (int n = 0; i < 10; i++) {
								String stringNro = circulo6[i] + circulo5[j] + circulo4[k] + circulo3[l] + circulo2[m] + circulo1[n];
								if(esNroVampiro(stringNro)) {
									System.out.println(stringNro);
									return;
								}
						}
					}
				}
			}
		}
	}
}

	private static boolean esNroVampiro(String stringNro) {
		int nro = Integer.valueOf(stringNro);
		return false;
	}
}
