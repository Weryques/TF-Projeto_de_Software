package principal;

import interfaces.Subject;
import interfaces.Observer;

import java.util.*;

public class Tela implements Subject{
	List jogadores = new ArrayList();
	String palavraAnonima, resultado;
	int tentativasRestantes;
	char[][] forca;
	
	Tela(String palavraAnonima, String resultado, int tentativasRestantes, char[][] forca){
		this.forca = forca;
		this.palavraAnonima = palavraAnonima;
		this.resultado = resultado;
		this.tentativasRestantes = tentativasRestantes;
	}
	
	@Override
	public void adicionaJogador(Observer jogador) {
		jogadores.add(jogador);
	}

	@Override
	public void remove() {
		System.exit(0);
	}

	@Override
	public void notificaJogadores() {		
		Iterator iterator = jogadores.iterator();
		while (iterator.hasNext()) {
			Observer jogador = (Observer)iterator.next();
			jogador.atualiza(palavraAnonima, resultado, tentativasRestantes, forca);
		}
	}
}
