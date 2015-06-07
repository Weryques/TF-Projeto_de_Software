package observadores;

import interfaces.Observer;

/**Classe interessada em saber se alguma letra foi adivinhada
 * @author weryquessantos
 *
 */
public class PalavraAnonima implements Observer{

	/* (non-Javadoc)
	 * @see interfaces.Observer#atualiza(char[], java.lang.String, int, char[])
	 */
	@Override
	public void atualiza(char[] copiaTracejada, String resultado,
			int tentativasRestantes, char[] erradas) {


		if(copiaTracejada != null){
			System.out.println();
			for(int i = 0; i < copiaTracejada.length; i++){
				System.out.print(" "+ copiaTracejada[i] +" ");
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
