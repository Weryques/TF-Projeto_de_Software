package temas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import interfaces.Tema;

/**Classe que implenta a interface Tema
 * @author weryquessantos
 *
 */
public class Animais implements Tema{

	/* (non-Javadoc)
	 * @see interfaces.Tema#getPalavraArquivo()
	 */
	@Override
	public String getPalavraArquivo() throws IOException{		
		String palavra = null;
		List<String> listaDePalavras = new ArrayList<String>();
		Scanner scan = extracted().useDelimiter("\\\n");
		Random rand = new Random();
		
		while(scan.hasNext()){
			listaDePalavras.add(scan.next());
		}
		
		Collections.shuffle(listaDePalavras);
		palavra = (String) listaDePalavras.get(rand.nextInt(listaDePalavras.size()+1));
		
		return palavra;
	}

	/**
	 * @return Scanner
	 * @throws FileNotFoundException
	 */
	private Scanner extracted() throws FileNotFoundException {
		return new Scanner(new FileReader("Animais.txt"));
	}
}
