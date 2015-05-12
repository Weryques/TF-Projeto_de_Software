package interfaces;

import interfaces.Observer;;

public interface Subject {
	public void adicionaJogador(Observer jogador);
	public void remove();
	public void notificaJogadores();
}
