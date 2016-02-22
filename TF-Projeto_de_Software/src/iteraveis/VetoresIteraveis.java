package iteraveis;

import interfaces.IteradorA;
import interfaces.IteravelA;
import iteradores.IteradorVetores;

/**Iteravel concreto, implementa a interface IteravelA
 * @author weryquessantos
 *
 */
public class VetoresIteraveis implements IteravelA{
	/** Atributo vetor*/
	private char vetor[];
	
	/**
	 * @param vetor the vetor to set
	 */
	public void setVetor(char[] vetor) {
		this.vetor = vetor;
	}

	/* (non-Javadoc)
	 * @see interfaces.IteravelA#criaIteradorA()
	 */
	@Override
	public IteradorA criaIteradorA() {
		return new IteradorVetores(vetor);
	}

}
