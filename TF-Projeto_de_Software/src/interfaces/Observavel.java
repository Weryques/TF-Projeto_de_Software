package interfaces;

import interfaces.Observer;;

/**Interface Observavel
 * @author weryquessantos
 *
 */
public interface Observavel {
	/**Adiciona observadores
	 * @param observer
	 */
	public void adicionaObservers(Observer observer);
	/**Remove observadores*/
	public void remove();
	/**Notifica observadores*/
	public void notificaObservers();
}
