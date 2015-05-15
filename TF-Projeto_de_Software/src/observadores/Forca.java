package observadores;

import interfaces.Observer;

public class Forca implements Observer{

	@Override
	public void atualiza(char[] copiaTracejada, String resultado,
			int tentativasRestantes, char[][] forca, char[] erradas) {
		System.out.println();
		
		System.out.println("Chances de errar: "+ tentativasRestantes);
		
		System.out.println();			
	}
	
	public Forca cria_se(){
		return this;
	}

}
