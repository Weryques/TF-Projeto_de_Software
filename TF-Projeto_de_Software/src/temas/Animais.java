package temas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import interfaces.TipoTema;

public class Animais implements TipoTema{

	@Override
	public String getPalavraArquivo() throws IOException, FileNotFoundException {		
		String palavra = null;
		List listaDePalavras = new ArrayList();
		Scanner scan = extracted().useDelimiter("\\|");
		
		while(scan.hasNext()){
			listaDePalavras.add(scan.next());
		}
		
		Collections.shuffle(listaDePalavras);
		palavra = (String) listaDePalavras.get(0);
		
		return palavra;
	}

	private Scanner extracted() throws FileNotFoundException {
		return new Scanner(new FileReader("Animais.txt"));
	}

}
