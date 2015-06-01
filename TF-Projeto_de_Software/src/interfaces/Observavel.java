package interfaces;

import interfaces.Observer;;

public interface Observavel {
	public void adicionaObservers(Observer observer);
	public void remove();
	public void notificaObservers();
}
