package Iteradores;

import interfaces.IteradorA;

/**Iterador concreto, implementa a interface IteradorA
 * @author weryquessantos
 *
 */
public class IteradorVetores implements IteradorA {
	
	/**Atributo vetor*/
	private char vetor[];
	
	/**Atributo i */
	private int i = 0;
	
	/**Construtor da classe IteradorVetores
	 * @param vetor
	 */
	public IteradorVetores(char[] vetor) {
		this.vetor = vetor;
	}

	/* (non-Javadoc)
	 * @see interfaces.IteradorA#hasNext()
	 */
	@Override
	public boolean hasNext() {
		if(vetor == null || i >= vetor.length || vetor[i] == '\0'){
			return false;
		}
		else{
			return true;
		}
	}

	/* (non-Javadoc)
	 * @see interfaces.IteradorA#next()
	 */
	@Override
	public Object next() {
		char caractere = vetor[i];
		i++;
		return caractere;
	}
}
