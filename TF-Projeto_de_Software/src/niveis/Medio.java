package niveis;

import interfaces.Nivel;


/**Classe que implementa a interface Nivel
 * @author weryquessantos
 *
 */
public class Medio implements Nivel{
	int tentativasRestantes = 10;

	/* (non-Javadoc)
	 * @see interfaces.Nivel#getTentativasRestantes()
	 */
	public int getTentativasRestantes() {
		return tentativasRestantes;
	}

}
