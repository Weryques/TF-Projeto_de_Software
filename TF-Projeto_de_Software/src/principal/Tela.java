package principal;

import interfaces.Subject;
import interfaces.Observer;

import java.util.*;

public class Tela implements Subject{
	List jogadores = new ArrayList();
	String resultado;

	int tentativasRestantes;
	char[][] forca;
	char[] erradas, copiaTracejada;
		
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
			jogador.atualiza(copiaTracejada, resultado, tentativasRestantes, forca, erradas);
		}
	}
	
	public void informarDadosAlterados(){
		notificaJogadores();
	}
	
	public void setEnviarDadosAlterados(char[] copiaTracejada, char[] erradas, char[][] forca, int tentativasRestantes){
		this.copiaTracejada = copiaTracejada;
		this.erradas = erradas;
		this.forca = forca;
		this.tentativasRestantes = tentativasRestantes;
		informarDadosAlterados();
	}
	
	public void setResultado(String resultado) {
		this.resultado = resultado;
		informarDadosAlterados();
	}
}
