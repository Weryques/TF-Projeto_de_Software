package observadores;

import interfaces.Observer;

public class BancoLetrasErradas implements Observer {

	@Override
	public void atualiza(char[] copiaTracejada, String resultado,
			int tentativasRestantes, char[] erradas) {
		
		
		
		if(erradas != null){
			System.out.println();
			for(int i = 0; i < erradas.length; i++){
				System.out.print(" "+ erradas[i] +" ");
			}
			System.out.println();
		}	
		

	}
	
	public Observer cria_se(){
		return this;
	}
}
