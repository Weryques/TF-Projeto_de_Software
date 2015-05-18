package principal;

import java.io.*;
import java.util.*;

import niveisStrategy.*;
import temasStrategy.*;
import observadores.*;

public class Controle {
	static Scanner scan = new Scanner(System.in);

	public void controle(Animais animais, Filmes filmes, Profissoes profissoes, Tela tela, FimJogo fimJogo, BancoLetrasErradas bancoLetras, Forca forcaI, PalavraAnonima palavraAnonima,
			Dificil dificil, Facil facil, Medio medio)
					throws IOException {
//-------
		char[] copiaTracejada = new char[100];
		char[] erradas = new char[100];

		char[][] forca = new char[10][20];

		int qAcertos = 0, h = 0, tema = 0, nivel = 0;
		char letra;

		String palavra;
		String resultado = null;
		int tentativasRestantes = 0;
		
		int escolha1 = 0;
//-------
		while(true){
			nivel = menuNiveis();
			if(nivel == 1 || nivel == 2 || nivel == 3){
				System.out.println();
				escolha1 = menuTemaOuAleatoria();		
				System.out.println();

				limparConsole();

				if(escolha1 == 1){//vai pegar palavra do tema definido
					tema = menuTema();
					if(tema == 0 || tema == 1 || tema == 2 || tema == 3){
						limparConsole();
						break;
					}
					else{
						limparConsole();
						System.out.println("Opção inválida! Tente de novo.");
					}

				}
				else if(escolha1 == 0){
					limparConsole();
					break;

				}
				else{
					limparConsole();
					System.out.println("Opção inválida! Tente de novo.");
				}
			}
			else{
				limparConsole();
				System.out.println("Opção inválida! Tente de novo.");
			}
		}
//------
		tentativasRestantes = definirTentativas(dificil, facil, medio, nivel, tentativasRestantes);
		palavra = definirPalavra(animais, filmes, profissoes, tema);

		tracejarPalavra(palavra, copiaTracejada);
		adicionaObservers(tela, fimJogo, bancoLetras, forcaI, palavraAnonima);
//------
		while(true){
			int qA = 0, escolha2;

			limparConsole();
			tela.setEnviarDadosAlterados(copiaTracejada, erradas, forca, tentativasRestantes, resultado);

			if(qAcertos == tamanho(palavra)){
				resultado = "VOCÊ ACERTOU! PARABÉNS!";
				tela.setEnviarDadosAlterados(null, null, null, 0, resultado);

				while(true){
					escolha2 = menuFimDeJogo();
					if(escolha2 == 1 || escolha2 == 2 || escolha2 == 3 || escolha2 == 0){

						if(escolha2 == 1){ //troca de palavra
							tentativasRestantes = definirTentativas(dificil, facil, medio, nivel, tentativasRestantes);
							palavra = definirPalavra(animais, filmes, profissoes, tema);

							for(int i = 0; i < copiaTracejada.length; i++)
								copiaTracejada[i] = '\0';

							tracejarPalavra(palavra, copiaTracejada);


							for(int i = 0; i < erradas.length; i++)
								erradas[i] = '\0';
							letra = '\0';
							resultado = null;
							qAcertos = 0;
							h = 0;

							tela.setEnviarDadosAlterados(copiaTracejada, erradas, forca, tentativasRestantes, resultado);
						}
						else if(escolha2 == 2){ //troca de nível
							limparConsole();
							nivel = menuNiveis();
							tentativasRestantes = definirTentativas(dificil, facil, medio, nivel, tentativasRestantes);
							palavra = definirPalavra(animais, filmes, profissoes, tema);

							for(int i = 0; i < copiaTracejada.length; i++)
								copiaTracejada[i] = '\0';

							tracejarPalavra(palavra, copiaTracejada);

							for(int i = 0; i < erradas.length; i++)
								erradas[i] = '\0';
							letra = '\0';
							resultado = null;
							qAcertos = 0;
							h = 0;

							tela.setEnviarDadosAlterados(copiaTracejada, erradas, forca, tentativasRestantes, resultado);
						}
						else if(escolha2 == 3){ //troca de tema
							limparConsole();
							tema = menuTema();
							tentativasRestantes = definirTentativas(dificil, facil, medio, nivel, tentativasRestantes);
							palavra = definirPalavra(animais, filmes, profissoes, tema);

							for(int i = 0; i < copiaTracejada.length; i++)
								copiaTracejada[i] = '\0';

							tracejarPalavra(palavra, copiaTracejada);

							for(int i = 0; i < erradas.length; i++)
								erradas[i] = '\0';
							letra = '\0';
							resultado = null;
							qAcertos = 0;
							h = 0;

							tela.setEnviarDadosAlterados(copiaTracejada, erradas, forca, tentativasRestantes, resultado);
						}
						else if(escolha2 == 0){ //remove todos os observer e sai do jogo
							tela.remove();
						}
						break; //para o loop mais interno
					}
					else{
						limparConsole();
						System.out.println("Opção inválida! Tente novamente.");
					}
				}
			}
			else if(tentativasRestantes == 0){
				resultado = "VOCÊ PERDEU. TENTE NOVAMENTE!";
				tela.setEnviarDadosAlterados(null, null, null, 0, resultado);

				while(true){
					escolha2 = menuFimDeJogo();
					if(escolha2 == 1 || escolha2 == 2 || escolha2 == 3 || escolha2 == 0){

						if(escolha2 == 1){ //troca de palavra
							tentativasRestantes = definirTentativas(dificil, facil, medio, nivel, tentativasRestantes);
							palavra = definirPalavra(animais, filmes, profissoes, tema);

							for(int i = 0; i < copiaTracejada.length; i++)
								copiaTracejada[i] = '\0';

							tracejarPalavra(palavra, copiaTracejada);


							for(int i = 0; i < erradas.length; i++)
								erradas[i] = '\0';
							letra = '\0';
							resultado = null;
							qAcertos = 0;
							h = 0;

							tela.setEnviarDadosAlterados(copiaTracejada, erradas, forca, tentativasRestantes, resultado);
						}
						else if(escolha2 == 2){ //troca de nível
							limparConsole();
							nivel = menuNiveis();
							tentativasRestantes = definirTentativas(dificil, facil, medio, nivel, tentativasRestantes);
							palavra = definirPalavra(animais, filmes, profissoes, tema);

							for(int i = 0; i < copiaTracejada.length; i++)
								copiaTracejada[i] = '\0';

							tracejarPalavra(palavra, copiaTracejada);

							for(int i = 0; i < erradas.length; i++)
								erradas[i] = '\0';
							letra = '\0';
							resultado = null;
							qAcertos = 0;
							h = 0;

							tela.setEnviarDadosAlterados(copiaTracejada, erradas, forca, tentativasRestantes, resultado);
						}
						else if(escolha2 == 3){
							limparConsole();
							tema = menuTema();
							tentativasRestantes = definirTentativas(dificil, facil, medio, nivel, tentativasRestantes);
							palavra = definirPalavra(animais, filmes, profissoes, tema);

							for(int i = 0; i < copiaTracejada.length; i++)
								copiaTracejada[i] = '\0';

							tracejarPalavra(palavra, copiaTracejada);

							for(int i = 0; i < erradas.length; i++)
								erradas[i] = '\0';
							letra = '\0';
							resultado = null;
							qAcertos = 0;
							h = 0;

							tela.setEnviarDadosAlterados(copiaTracejada, erradas, forca, tentativasRestantes, resultado);
						}
						else if(escolha2 == 0){
							tela.remove();
						}
						break; //para o loop mais interno
					}
					else{
						limparConsole();
						System.out.println("Opção inválida! Tente novamente.");
					}
				}
			}

			System.out.println();
			System.out.print("Digite uma letra (MAIÚSCULA): ");
			letra = scan.next().charAt(0);

			for(int i = 0; i < palavra.length(); i++){
				if(palavra.charAt(i) == letra && copiaTracejada[i] != letra){
					qAcertos++;
					qA++;
					copiaTracejada[i] = letra;
				}
				else if(copiaTracejada[i] == letra){
					System.out.println("VOCÊ JÁ DIGITOU ESSA LETRA!");
					qA++;
					break;
				}
			}

			if(qA == 0){
				erradas[h++] = letra;
				tentativasRestantes--;
			}
		}
	}
	public void limparConsole() {
		for(int i = 0; i < 100; i++){
			System.out.println("\b");
		}
	}
//--
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

	public void adicionaObservers(Tela tela, FimJogo fimJogo,
			BancoLetrasErradas bancoLetras, Forca forcaI,
			PalavraAnonima palavraAnonima) {
		tela.adicionaObservers(fimJogo.cria_se());
		tela.adicionaObservers(forcaI.cria_se());
		tela.adicionaObservers(palavraAnonima.cria_se());
		tela.adicionaObservers(bancoLetras.cria_se());
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

	public int menuFimDeJogo(){
		int escolha2 = 0;
		System.out.println("| 1 - Continuar o jogo com o mesmo tema e mesmo nível |");
		System.out.println("| 2 - Trocar de nível e continuar com mesmo tema      |");
		System.out.println("| 3 - Trocar de tema e continuar com mesmo nível      |");
		System.out.println("| 0 - Sair do jogo");
		System.out.print("Aqui: ");
		escolha2 = scan.nextInt();
		return escolha2;
	}

	public int menuTema() {
		int tema = 0;
		System.out.println("|------Tema------|");
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
		System.out.println("| 1 - Escolher o tema da palavra              |");
		System.out.println("| 0 - Adivinhar uma palavra de tema aleatório |");
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
