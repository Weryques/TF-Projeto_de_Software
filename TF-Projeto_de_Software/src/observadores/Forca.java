package observadores;

import interfaces.Observer;

/**Classe interessada em saber quantas chances de errar tem-se
 * @author weryquessantos
 *
 */
public class Forca implements Observer{

	/* (non-Javadoc)
	 * @see interfaces.Observer#atualiza(char[], java.lang.String, int, char[])
	 */
	@Override
	public void atualiza(char[] copiaTracejada, String resultado,
			int tentativasRestantes, char[] erradas) {

		
		if(tentativasRestantes != 0){
			System.out.println();
			System.out.println("Chances de errar: "+ tentativasRestantes);
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
