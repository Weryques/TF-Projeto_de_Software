package Iteradores;

import interfaces.IteradorA;

public class IteradorVetores implements IteradorA {
	char vetor[];
	int i = 0;
	
	/**
	 * @param vetor
	 */
	public IteradorVetores(char[] vetor) {
		this.vetor = vetor;
	}

	@Override
	public boolean hasNext() {
		if(vetor == null || i >= vetor.length || vetor[i] == '\0'){
			return false;
		}
		else{
			return true;
		}
	}

	@Override
	public Object next() {
		char caractere = vetor[i];
		i++;
		return caractere;
	}
}
