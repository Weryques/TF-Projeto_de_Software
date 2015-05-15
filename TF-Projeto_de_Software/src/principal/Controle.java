package principal;

import java.io.*;
import java.util.*;

import niveis.*;
import temas.*;
import observadores.*;

public class Controle {
	static Scanner scan = new Scanner(System.in);

	public void controle(Animais animais, Filmes filmes, Profissoes profissoes, Tela tela, FimJogo fimJogo, BancoLetrasErradas bancoLetras, Forca forcaI, PalavraAnonima palavraAnonima,
			Dificil dificil, Facil facil, Medio medio, char[] copiaTracejada, char[] erradas, char letra,
			char[][] forca, int qAcertos, int h, int nivel, int tema)
					throws IOException {

		String palavra;
		String resultado;
		int tentativasRestantes = 0;

		tentativasRestantes = definirTentativas(dificil, facil, medio, nivel,
				tentativasRestantes);
		palavra = definirTema(animais, filmes, profissoes, tema);

		tracejarPalavra(palavra, copiaTracejada);
		adicionaObservers(tela, fimJogo, bancoLetras, forcaI,
				palavraAnonima);

		while(true){
			int qA = 0;

			tela.setEnviarDadosAlterados(copiaTracejada, erradas, forca, tentativasRestantes);

			if(qAcertos == tamanho(palavra)){
				resultado = "VOCÊ ACERTOU! PARABÉNS!";
				tela.setResultado(resultado);
				break;
			}
			else if(tentativasRestantes == 0){
				resultado = "VOCÊ PERDEU. TENTE NOVAMENTE!";
				tela.setResultado(resultado);
				break;
			}

			System.out.print("Digite uma letra (MAIÚSCULA): ");
			letra = scan.next().charAt(0);

			for(int i = 0; i < palavra.length(); i++){
				if(palavra.charAt(i) == letra){
					qAcertos++;
					qA++;
					copiaTracejada[i] = letra;
				}
			}

			if(qA == 0){
				erradas[h++] = letra;
				tentativasRestantes--;
			}
		}
	}

	public String definirTema(Animais animais, Filmes filmes,
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

	public void adicionaObservers(Tela tela, FimJogo fimJogo,
			BancoLetrasErradas bancoLetras, Forca forcaI,
			PalavraAnonima palavraAnonima) {
		tela.adicionaObservers(fimJogo.cria_se());
		tela.adicionaObservers(bancoLetras.cria_se());
		tela.adicionaObservers(forcaI.cria_se());
		tela.adicionaObservers(palavraAnonima.cria_se());
	}

	public int tamanho(String palavra){//criei para palavras compostas
		int tamanhoReal = 0;

		for(int i = 0; i < palavra.length(); i++){
			if(palavra.charAt(i) != ' '){
				tamanhoReal++;
			}
		}

		return tamanhoReal;
	}

	public int menuTema() {
		int tema = 0;
		System.out.println("|-------Tema-----|");
		System.out.println("|----------------|");
		System.out.println("| 1 - Animais    |");
		System.out.println("| 2 - Filmes     |");
		System.out.println("| 3 - Profissões |");
		System.out.println("|----------------|");
		System.out.print("Escolha o tema da palavra: ");
		tema = scan.nextInt();
		return tema;
	}

	public int menuTemaOuAleatoria() {
		int escolha1 = 0;
		System.out.println("Digite 1 (um) para escolher o tema da palavra.");
		System.out.println("Digite 0 (zero) para adivinhar uma palavra de tema aleatório.");
		System.out.print("Aqui: ");
		escolha1 = scan.nextInt();
		return escolha1;
	}

	public int menuNiveis() {
		int nivel = 0;
		System.out.println("|-----Níveis----|");
		System.out.println("|---------------|");
		System.out.println("| 1 - Fácil     |");
		System.out.println("| 2 - Médio     |");
		System.out.println("| 3 - Dificil   |");
		System.out.println("|---------------|");
		System.out.print("Escolha o nível de dificuldade: ");
		nivel = scan.nextInt();
		return nivel;
	}

	public void tracejarPalavra(String palavra, char[] copiaTracejada){
		for (int i = 0; i < palavra.length(); i++) {
			if(palavra.charAt(i) != ' ')
				copiaTracejada[i] = '_';

		}
	}

}
