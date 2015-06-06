package principal;

import interfaces.Observavel;
import interfaces.Observer;

import java.util.*;

public class TelaObservavel implements Observavel{
	List<Observer> observadores = new ArrayList<Observer>();
	String resultado;

	int tentativasRestantes;
	char[] erradas, copiaTracejada;
		
	@Override
	public void adicionaObservers(Observer observer) {
		observadores.add(observer);
	}

	@Override
	public void remove() {
		System.exit(0);
	}

	@Override
	public void notificaObservers() {		
		Iterator<Observer> iterator = observadores.iterator();
		while (iterator.hasNext()) {
			Observer jogador = (Observer)iterator.next();
			jogador.atualiza(copiaTracejada, resultado, tentativasRestantes, erradas);
		}
	}
	
	public void informarDadosAlterados(){
		notificaObservers();
	}
	
	public void setEnviarDadosAlterados(char[] copiaTracejada, char[] erradas, int tentativasRestantes, String resultado){
		this.copiaTracejada = copiaTracejada;
		this.erradas = erradas;
		this.tentativasRestantes = tentativasRestantes;
		this.resultado = resultado;
		informarDadosAlterados();
	}
}
