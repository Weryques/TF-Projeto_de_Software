package principal;

import java.io.IOException;

import interfaces.AdivinhacaoStrategy;

/**Classe do contexto da estrategia
 * @author weryquessantos
 *
 */
public class PalavraContext {
	/** Instancias das estrategias*/
	AdivinhacaoStrategy todasLetras;
	AdivinhacaoStrategy letraPorLetra;

	/**Inicializa a instancia @param todasLetras
	 * @param todasLetras
	 */
	public void setTodasLetras(AdivinhacaoStrategy todasLetras) {
		this.todasLetras = todasLetras;
	}

	/**Inicializa a instancia @param letraPorLetra
	 * @param letraPorLetra
	 */
	public void setLetraPorLetra(AdivinhacaoStrategy letraPorLetra) {
		this.letraPorLetra = letraPorLetra;
	}

	/**Metodo que inicia a estrategia TodasLetras
	 * @throws IOException
	 */
	public void todasLetras() throws IOException{
		todasLetras.adivinhar();
	}
	
	/**Metodo que inicia a estrategia LetraPorLetra
	 * @throws IOException
	 */
	public void letraPorLetra() throws IOException{
		letraPorLetra.adivinhar();
	}
}
