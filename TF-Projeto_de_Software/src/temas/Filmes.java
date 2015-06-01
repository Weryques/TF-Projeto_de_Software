package temas;

import java.io.*;
import java.util.*;

import interfaces.Tema;

public class Filmes implements Tema{

	@Override
	public String getPalavraArquivo() throws IOException {
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
		return new Scanner(new FileReader("Filmes.txt"));
	}	
	
}

