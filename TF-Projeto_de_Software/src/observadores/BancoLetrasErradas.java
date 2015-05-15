package observadores;

import interfaces.Observer;

public class BancoLetrasErradas implements Observer {

	@Override
	public void atualiza(char[] copiaTracejada, String resultado,
			int tentativasRestantes, char[][] forca, char[] erradas) {
		
		System.out.println();
		
		if(erradas != null){
			for(int i = 0; i < erradas.length; i++){
				System.out.print(" "+ erradas[i] +" ");
			}
		}	
		
		System.out.println();
	}
	
	public BancoLetrasErradas cria_se(){
		return this;
	}
}
