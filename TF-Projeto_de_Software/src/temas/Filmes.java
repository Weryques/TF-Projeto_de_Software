package temas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import interfaces.TipoTema;

public class Filmes implements TipoTema{

	@Override
	public String getPalavraArquivo() throws IOException {
		String palavra = null;
		List listaDePalavras = new ArrayList();
		Scanner scan = extracted().useDelimiter("\\\n");
		
		while(scan.hasNext()){
			listaDePalavras.add(scan.next());
		}
		
		Collections.shuffle(listaDePalavras);
		palavra = (String) listaDePalavras.get(0);
		
		return palavra;
	}

	private Scanner extracted() throws FileNotFoundException {
		return new Scanner(new FileReader("Filmes.txt"));
	}	
	
}

