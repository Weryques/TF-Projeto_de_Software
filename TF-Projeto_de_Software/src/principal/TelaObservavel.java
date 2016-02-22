package principal;

import interfaces.Observavel;
import interfaces.Observer;

import java.util.*;

/**Classe que recebe as informacoes de interesse dos observers de outras e as manda para os observers. Tambem tem responsabilidade de remover e adicionar observers
 * @author weryquessantos
 *
 */
public class TelaObservavel implements Observavel{
	/** Lista de observers*/
	private List<Observer> observadores = new ArrayList<Observer>();
	
	/** Atributo resultado*/
	private String resultado;

	/**Atributo tentativasRestantes */
	private int tentativasRestantes;
	
	/** Atributos erradas e copiaTracejada*/
	private char[] erradas; 
	private char[] copiaTracejada;
		
	/* (non-Javadoc)
	 * @see interfaces.Observavel#adicionaObservers(interfaces.Observer)
	 */
	@Override
	public void adicionaObservers(Observer observer) {
		observadores.add(observer);
	}

	/* (non-Javadoc)
	 * @see interfaces.Observavel#remove()
	 */
	@Override
	public void remove() {
		System.exit(0);
	}

	/* (non-Javadoc)
	 * @see interfaces.Observavel#notificaObservers()
	 */
	@Override
	public void notificaObservers() {		
		Iterator<Observer> iterator = observadores.iterator();
		while (iterator.hasNext()) {
			Observer jogador = (Observer)iterator.next();
			jogador.atualiza(copiaTracejada, resultado, tentativasRestantes, erradas);
		}
	}
	
	/** Metodo auxiliar*/
	public void informarDadosAlterados(){
		notificaObservers();
	}
	
	/**Define as auterações dos variáveis, para que depois sejam mandadas para os observers
	 * @param copiaTracejada
	 * @param erradas
	 * @param tentativasRestantes
	 * @param resultado
	 */
	public void setEnviarDadosAlterados(char[] copiaTracejada, char[] erradas, int tentativasRestantes, String resultado){
		this.copiaTracejada = copiaTracejada;
		this.erradas = erradas;
		this.tentativasRestantes = tentativasRestantes;
		this.resultado = resultado;
		informarDadosAlterados();
	}
}
