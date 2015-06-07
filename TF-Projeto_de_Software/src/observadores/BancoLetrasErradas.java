package observadores;

import interfaces.Observer;

/**Classe que observa as letra erradas
 * @author weryquessantos
 *
 */
public class BancoLetrasErradas implements Observer {

	/* (non-Javadoc)
	 * @see interfaces.Observer#atualiza(char[], java.lang.String, int, char[])
	 */
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
	
	/* (non-Javadoc)
	 * @see interfaces.Observer#cria_se()
	 */
	public Observer cria_se(){
		return this;
	}
}
