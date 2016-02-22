package niveis;

import interfaces.Nivel;


/**Classe que implementa a interface Nivel
 * @author weryquessantos
 *
 */
public class Facil implements Nivel{
	private int tentativasRestantes = 13;

	/* (non-Javadoc)
	 * @see interfaces.Nivel#getTentativasRestantes()
	 */
	public int getTentativasRestantes() {
		return tentativasRestantes;
	}

}
