package interfaces;

import java.io.IOException;

/**Interface Strategy
 * @author weryquessantos
 *
 */
public interface AdivinhacaoStrategy {
	/**Metodo abstrato, que tem papel de adivinhar
	 * @throws IOException
	 */
	public void adivinhar() throws IOException;
}
