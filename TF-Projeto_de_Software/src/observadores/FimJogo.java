package observadores;

import principal.Tela;
import interfaces.Observer;

public class FimJogo implements Observer{

	@Override
	public void atualiza(char[] copiaTracejada, String resultado,
			int tentativasRestantes, char[][] forca, char[] erradas) {
		Tela tela = new Tela();
		
		System.out.println();
		
		if(resultado != null){
			System.out.println(resultado);
			tela.remove();
		}
		
		System.out.println();
	}
	
	public FimJogo cria_se(){
		return this;
	}
}
