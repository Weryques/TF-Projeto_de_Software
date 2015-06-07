package observadores;

import interfaces.Observer;

/**Classe interessa em saber como termina o jogo
 * @author weryquessantos
 *
 */
public class FimJogo implements Observer{

	/* (non-Javadoc)
	 * @see interfaces.Observer#atualiza(char[], java.lang.String, int, char[])
	 */
	@Override
	public void atualiza(char[] copiaTracejada, String resultado,
			int tentativasRestantes, char[] erradas) {
		
		
		
		if(resultado != null){
			System.out.println();
			System.out.println(resultado);
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
