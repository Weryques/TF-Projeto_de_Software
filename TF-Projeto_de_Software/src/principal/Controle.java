package principal;

import java.io.IOException;

import niveis.*;
import observadores.*;
import temas.*;

public class Controle {
	public boolean opMenuValidar(int escolha){
		if(escolha == 1 || escolha == 2 || escolha == 3 || escolha == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String definirPalavra(Animais animais, Filmes filmes,
			Profissoes profissoes, int tema) throws IOException {
		String palavra;
		if(tema == 3){
			palavra = profissoes.getPalavraArquivo();
		}
		else if(tema == 2){
			palavra = filmes.getPalavraArquivo();
		}
		else if(tema == 1){
			palavra = animais.getPalavraArquivo();
		}
		else{
			palavra = animais.getPalavraArquivo();
		}
		return palavra;
	}

	public int definirTentativas(Dificil dificil, Facil facil, Medio medio,
			int nivel, int tentativasRestantes) {
		if(nivel == 3){
			tentativasRestantes = dificil.getTentativasRestantes();
		}
		else if(nivel == 2){
			tentativasRestantes = medio.getTentativasRestantes();
		}
		else if(nivel == 1){
			tentativasRestantes = facil.getTentativasRestantes();
		}
		return tentativasRestantes;
	}

	public void adicionaObservers(TelaObservavel tela, FimJogo fimJogo,
			BancoLetrasErradas bancoLetras, Forca forcaI,
			PalavraAnonima palavraAnonima) {
		tela.adicionaObservers(fimJogo.cria_se());
		tela.adicionaObservers(forcaI.cria_se());
		tela.adicionaObservers(palavraAnonima.cria_se());
		tela.adicionaObservers(bancoLetras.cria_se());
	}

	public int tamanho(String palavra){//criei para palavras compostas
		int tamanhoReal = 0;

		for(int i = 0; i < palavra.length(); i++){ //itero aqui
			if(palavra.charAt(i) != ' '){
				tamanhoReal++;
			}
		}

		return tamanhoReal;
	}
	
	public void tracejarPalavra(String palavra, char[] copiaTracejada){ //itero aqui
		for (int i = 0; i < palavra.length(); i++) {
			if(palavra.charAt(i) != ' ')
				copiaTracejada[i] = '_';

		}
	}
	
	public void definirEstrategia(int modo, PalavraContext palavraCont)
			throws IOException {
		if(modo == 1){
			palavraCont.todasLetras();
		}
		else if(modo == 0){
			palavraCont.letraPorLetra();
		}
	}
	
}
