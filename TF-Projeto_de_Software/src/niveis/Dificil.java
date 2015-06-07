package niveis;

import interfaces.Nivel;


/**Classe que implementa a interface @interface Nivel
 * @author weryquessantos
 *
 */
public class Dificil implements Nivel{
	int tentativasRestantes = 6;
	
	/* (non-Javadoc)
	 * @see interfaces.Nivel#getTentativasRestantes()
	 */
	public int getTentativasRestantes() {
		return tentativasRestantes;
	}
}
