package niveis;

import interfaces.Nivel;


/**Classe que implementa a interface Nivel
 * @author weryquessantos
 *
 */
public class Dificil implements Nivel{
	private int tentativasRestantes = 6;
	
	/* (non-Javadoc)
	 * @see interfaces.Nivel#getTentativasRestantes()
	 */
	public int getTentativasRestantes() {
		return tentativasRestantes;
	}
}
