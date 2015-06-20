package Iteraveis;

import Iteradores.IteradorVetores;
import interfaces.IteradorA;
import interfaces.IteravelA;

public class VetoresIteraveis implements IteravelA{
	char vetor[];
	
	/**
	 * @param vetor the vetor to set
	 */
	public void setVetor(char[] vetor) {
		this.vetor = vetor;
	}

	@Override
	public IteradorA criaIteradorA() {
		return new IteradorVetores(vetor);
	}

}
