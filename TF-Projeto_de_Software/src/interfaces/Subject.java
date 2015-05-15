package interfaces;

import interfaces.Observer;;

public interface Subject {
	public void adicionaObservers(Observer observer);
	public void remove();
	public void notificaObservers();
}
