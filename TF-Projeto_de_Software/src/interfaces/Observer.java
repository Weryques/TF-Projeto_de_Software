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
	/**Metodo que retorna um observer. O proprio observer retorna sua instancia
	 * @return Observer
	 */
	public Observer cria_se();
}
