package temasStrategy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import interfaces.TipoTemaStrategy;

public class Animais implements TipoTemaStrategy{

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

	private Scanner extracted() throws FileNotFoundException {
		return new Scanner(new FileReader("Animais.txt"));
	}

}
