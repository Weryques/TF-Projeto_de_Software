package observadores;

import interfaces.IteradorA;
import interfaces.Observer;
import iteraveis.VetoresIteraveis;

/**Classe observadora interessada em saber se alguma letra foi adivinhada
 * @author weryquessantos
 *
 */
public class PalavraAnonima implements Observer{
	/**Instancia do iteravel VetoresIteraveis*/
	private VetoresIteraveis iteravel = new VetoresIteraveis();
	/**Instancia do iterador IteradorA*/
	private IteradorA iterador;

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
	public Observer criarse(){
		return this;
	}
}
