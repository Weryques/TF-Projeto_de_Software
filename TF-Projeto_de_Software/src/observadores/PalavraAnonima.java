package observadores;

import Iteraveis.VetoresIteraveis;
import interfaces.IteradorA;
import interfaces.Observer;

/**Classe interessada em saber se alguma letra foi adivinhada
 * @author weryquessantos
 *
 */
public class PalavraAnonima implements Observer{
	VetoresIteraveis iteravel = new VetoresIteraveis();
	IteradorA iterador;

	/* (non-Javadoc)
	 * @see interfaces.Observer#atualiza(char[], java.lang.String, int, char[])
	 */
	@Override
	public void atualiza(char[] copiaTracejada, String resultado,
			int tentativasRestantes, char[] erradas) {

		iteravel.setVetor(copiaTracejada);
		iterador = iteravel.criaIteradorA();

		System.out.println();
		while(iterador.hasNext()){
			System.out.print(" "+ iterador.next() +" ");
		}
		System.out.println();

	}

	/* (non-Javadoc)
	 * @see interfaces.Observer#cria_se()
	 */
	public Observer cria_se(){
		return this;
	}
}
