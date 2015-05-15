package observadores;

import interfaces.Observer;

public class PalavraAnonima implements Observer{

	@Override
	public void atualiza(char[] copiaTracejada, String resultado,
			int tentativasRestantes, char[][] forca, char[] erradas) {
		
		System.out.println();
		
		for(int i = 0; i < copiaTracejada.length; i++){
			System.out.print(" "+ copiaTracejada[i] +" ");
		}
		System.out.println();
		System.out.println();
	}

	public PalavraAnonima cria_se(){
		return this;
	}
}
