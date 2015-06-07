package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

/**Interface Tema
 * @author weryquessantos
 *
 */
public interface Tema {
	/**Metodo para pegar palavra do arquivo
	 * @return String
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public String getPalavraArquivo() throws IOException, FileNotFoundException;
}
