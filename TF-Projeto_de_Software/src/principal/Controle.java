package principal;

import java.io.IOException;

import niveis.*;
import observadores.*;
import temas.*;

/**Classe que contem os principais metodos de controle do jogo
 * @author weryquessantos
 *
 */
public class Controle {
	/**Valida a opção digitada
	 * @param escolha
	 * @return boolean
	 */
	public boolean opMenuValidar(int escolha){
		if(escolha > -1 &&  escolha < 4){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**Obtem uma palavra do arquivo de acordo com o @param tema escolhido no menu
	 * @param animais
	 * @param filmes
	 * @param profissoes
	 * @param tema
	 * @return palavra
	 * @throws IOException
	 */
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

	/**Define as tentativas de errar de acordo com @param nivel escolhido no menu
	 * @param dificil
	 * @param facil
	 * @param medio
	 * @param nivel
	 * @param tentativasRestantes
	 * @return tentativasRestantes
	 */
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

	/**Adiciona os observadores a lista de observadores em @class Tela
	 * @param tela
	 * @param fimJogo
	 * @param bancoLetras
	 * @param forcaI
	 * @param palavraAnonima
	 */
	public void adicionaObservers(TelaObservavel tela, FimJogo fimJogo,
			BancoLetrasErradas bancoLetras, Forca forcaI,
			PalavraAnonima palavraAnonima) {
		
		tela.adicionaObservers(fimJogo.criarse());
		tela.adicionaObservers(forcaI.criarse());
		tela.adicionaObservers(palavraAnonima.criarse());
		tela.adicionaObservers(bancoLetras.criarse());
	}

	/**Defini o tamanho real da palavra, ou seja, o tamanho dela sem os espaços
	 * @param palavra
	 * @return tamanhoReal
	 */
	public int tamanho(String palavra){//criei para palavras compostas
		int tamanhoReal = 0;

		for(int i = 0; i < palavra.length(); i++){ //itero aqui
			if(palavra.charAt(i) != ' '){
				tamanhoReal++;
			}
		}

		return tamanhoReal;
	}
	
	/**Define um vetor @param copiaTracejada com a quantidade de traços equivalente a quantidade de letras de @param palavra
	 * @param palavra
	 * @param copiaTracejada
	 */
	public void tracejarPalavra(String palavra, char[] copiaTracejada){ //itero aqui
		for (int i = 0; i < palavra.length(); i++) {
			if(palavra.charAt(i) != ' ')
				copiaTracejada[i] = '_';

		}
	}
	
	/**Inicia a estrategia de acordo com @param modo escolhido no menu
	 * @param modo
	 * @param palavraCont
	 * @throws IOException
	 */
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
