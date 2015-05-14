package principal;

import interfaces.Observer;

public class Jogador implements Observer {

	@Override
	public void atualiza(char[] copiaTracejada, String resultado,
			int tentativasRestantes, char[][] forca, char[] erradas) {
		Tela tela = new Tela();
		
		System.out.println();
		
		System.out.println("Chances de errar: "+ tentativasRestantes);
		
		System.out.println();
		
		for(int i = 0; i < copiaTracejada.length; i++){
			System.out.print(" "+ copiaTracejada[i] +" ");
		}
		
		System.out.println();
		
		if(erradas != null){
			for(int i = 0; i < erradas.length; i++){
				System.out.print(" "+ erradas[i] +" ");
			}
		}
		
		System.out.println();
		System.out.println();
		if(resultado != null){
			System.out.println(resultado);
			tela.remove();
		}
		
	}
	
	public Jogador cria_se(){
		return this;
	}
}
