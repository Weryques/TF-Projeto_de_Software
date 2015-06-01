package principal;

import java.io.*;
import java.util.*;

import niveis.*;
import temas.*;
import observadores.*;

public class Controle {
	static Scanner scan = new Scanner(System.in);
	
	char[] copiaTracejada = new char[100];
	int qAcertos = 0, h = 0;
	char letra;
	String resultado = null;
	int tema = 0, nivel = 0;
	String palavra;
	int tentativasRestantes = 0;
	char[] erradas = new char[100];
	char[][] forca = new char[10][20];
	int escolha1 = 0;
	
	Visao visao;
	Animais animais;
	Filmes filmes;
	Profissoes profissoes;
	TelaObservavel tela;
	FimJogo fimJogo;
	BancoLetrasErradas bancoLetras;
	Forca forcaI;
	PalavraAnonima palavraAnonima;
	Dificil dificil;
	Facil facil;
	Medio medio;
	
	public Controle(Visao visao, Animais animais, Filmes filmes,
			Profissoes profissoes, TelaObservavel tela, FimJogo fimJogo,
			BancoLetrasErradas bancoLetras, Forca forcaI,
			PalavraAnonima palavraAnonima, Dificil dificil, Facil facil,
			Medio medio) {
		
		super();
		this.visao = visao;
		this.animais = animais;
		this.filmes = filmes;
		this.profissoes = profissoes;
		this.tela = tela;
		this.fimJogo = fimJogo;
		this.bancoLetras = bancoLetras;
		this.forcaI = forcaI;
		this.palavraAnonima = palavraAnonima;
		this.dificil = dificil;
		this.facil = facil;
		this.medio = medio;
	}


	public void controle() throws IOException{
		
		while(true){ //INICIO
			nivel = menuNiveis(); //define nivel
			
			if(opMenuValidar(nivel)){ //ver se não foi digitada opção invalida no menu niveis
				System.out.println();
				
				escolha1 = menuTemaOuAleatoria(); //pega a escolha		
				
				System.out.println();

				limparConsole();

				if(escolha1 == 1){//vai pegar palavra do tema definido
					tema = menuTema();
					if(opMenuValidar(escolha1)){
						limparConsole();
						break;
					}
					else{
						limparConsole();
						visao.opInvalida();
					}

				}
				else if(escolha1 == 0){//continua com a palavra do tema animais...
					limparConsole();
					break; // ...e sai do loop

				}
				else{
					limparConsole();
					visao.opInvalida();
				}
			}
			else{
				limparConsole();
				visao.opInvalida();
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
					
					if(opMenuValidar(escolha2)){
						reiniciarJogo(escolha2);
						break; //para o loop mais interno
					}
					else{
						limparConsole();
						visao.opInvalida();
					}
				}
			}
			else if(tentativasRestantes == 0){
				resultado = "VOCÊ PERDEU. TENTE NOVAMENTE!";
				tela.setEnviarDadosAlterados(null, null, null, 0, resultado);

				while(true){
					escolha2 = menuFimDeJogo();
					
					if(opMenuValidar(escolha2)){
						reiniciarJogo(escolha2);
						break; //para o loop mais interno
					}
					else{
						limparConsole();
						visao.opInvalida();
					}
				}
			}

			visao.digiteLetra();
			letra = scan.next().charAt(0);

			for(int i = 0; i < palavra.length(); i++){
				if(palavra.charAt(i) == letra && copiaTracejada[i] != letra){
					qAcertos++;
					qA++;
					copiaTracejada[i] = letra; 
				}
				else if(copiaTracejada[i] == letra){
					visao.letraRepetida();
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

	
	//--------------------/METODOS/----------------//
	public void reiniciarJogo(int escolha2) throws IOException {
		if(escolha2 == 1){ //troca de palavra
			tentativasRestantes = definirTentativas(dificil, facil, medio, nivel, tentativasRestantes); //chama o metodo para definir tentativas de errar
			palavra = definirPalavra(animais, filmes, profissoes, tema); //chama o metodo para definir nova palavra

			zerarVariaveis(erradas);
			tracejarPalavra(palavra, copiaTracejada);

			tela.setEnviarDadosAlterados(copiaTracejada, erradas, forca, tentativasRestantes, resultado);
		}
		else if(escolha2 == 2){ //troca de nível
			limparConsole();
			
			nivel = menuNiveis();//difere
			tentativasRestantes = definirTentativas(dificil, facil, medio, nivel, tentativasRestantes);
			palavra = definirPalavra(animais, filmes, profissoes, tema);

			zerarVariaveis(erradas);
			tracejarPalavra(palavra, copiaTracejada);

			tela.setEnviarDadosAlterados(copiaTracejada, erradas, forca, tentativasRestantes, resultado);
		}
		else if(escolha2 == 3){ //troca de tema
			limparConsole();
			
			tema = menuTema();//difere
			tentativasRestantes = definirTentativas(dificil, facil, medio, nivel, tentativasRestantes);
			palavra = definirPalavra(animais, filmes, profissoes, tema);

			zerarVariaveis(erradas);
			tracejarPalavra(palavra, copiaTracejada);

			tela.setEnviarDadosAlterados(copiaTracejada, erradas, forca, tentativasRestantes, resultado);
		}
		else if(escolha2 == 0){ //remove todos os observers e sai do jogo
			visao.fimJogo();
			tela.remove();
		}
	}

	public void zerarVariaveis(char[] erradas) {
		for(int i = 0; i < copiaTracejada.length; i++)
			copiaTracejada[i] = '\0';

		for(int i = 0; i < erradas.length; i++)
			erradas[i] = '\0';
		letra = '\0';
		resultado = null;
		qAcertos = 0;
		h = 0;
	}
	
	public boolean opMenuValidar(int escolha){
		if(escolha == 1 || escolha == 2 || escolha == 3 || escolha == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void limparConsole() {
		for(int i = 0; i < 100; i++){
			System.out.println("\b");
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
		System.out.println("| 0 - Jogar |");
		System.out.print("Aqui: ");
		escolha1 = scan.nextInt();
		return escolha1;
	}

	public int menuNiveis() {
		int nivel = 0;
		System.out.println("|-----Níveis-----|");
		System.out.println("|----------------|");
		System.out.println("| 1 - Fácil      |");
		System.out.println("| 2 - Médio      |");
		System.out.println("| 3 - Dificil    |");
		System.out.println("|----------------|");
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
