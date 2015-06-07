package interfaces;

/**Interface Observer
 * @author weryquessantos
 *
 */
public interface Observer {
	/**Metodo para atualizar os observers
	 * @param copiaTracejada
	 * @param resultado
	 * @param tentativasRestantes
	 * @param erradas
	 */
	public void atualiza(char[] copiaTracejada, String resultado, int tentativasRestantes, char[] erradas);
	/**
	 * @return Observer
	 */
	public Observer cria_se();
}
