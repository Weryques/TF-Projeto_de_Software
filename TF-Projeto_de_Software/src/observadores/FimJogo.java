package observadores;

import interfaces.Observer;

public class FimJogo implements Observer{

	@Override
	public void atualiza(char[] copiaTracejada, String resultado,
			int tentativasRestantes, char[] erradas) {
		
		
		
		if(resultado != null){
			System.out.println();
			System.out.println(resultado);
			System.out.println();
		}
		
		
	}
	
	public Observer cria_se(){
		return this;
	}
}
