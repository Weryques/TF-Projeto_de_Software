package interfaces;

import interfaces.Observer;;

/**Interface Observavel
 * @author weryquessantos
 *
 */
public interface Observavel {
	/**
	 * @param observer
	 */
	public void adicionaObservers(Observer observer);
	public void remove();
	public void notificaObservers();
}
