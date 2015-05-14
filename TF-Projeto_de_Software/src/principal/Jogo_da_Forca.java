package principal;

import java.io.*;
import java.util.*;

import niveis.*;
import temas.*;

public class Jogo_da_Forca {
	static Scanner scan = new Scanner(System.in);
		
	public static void main(String[] args) throws Exception, IOException{
		Animais animais = new Animais();
		Tela tela = new Tela();
		Jogador jogador = new Jogador();
		Dificil dificil = new Dificil();
		
		String palavra = null, resultado = null;
		
		char[] copiaTracejada = new char[100];
		char[] erradas = new char[100];
		
		char letra;
		char[][] forca = new char[10][20];
//		
//		for(int i = 0; i < 10; i++){
//			for(int j = 0; j < 20; j++){
//				if(j == 0 && i != 9)
//					forca[i][j] = '|';
//				if((i == 9  && j == 1) || (i == 9 && j == 2))
//					forca[i][j] = '-';
//				if((j == 1 || j == 2 || j == 3 || j == 4 || j == 5 || j == 6 || j == 7 || j == 8 || j == 9 || j == 10) && i == 0)
//					forca[i][j] = '-';
//					
//			}
//		}
//		
//		for(int i = 0; i < 10; i++){
//			for(int j = 0; j < 20; j++)
//				System.out.print(forca[i][j]);
//			System.out.println();
//		}
		
		
		int qAcertos = 0, h = 0, tentativasRestantes = 0;
		int nivel = 0, tema = 0, escolha1 = 0;
		
		nivel = menuNiveis();
		System.out.println();
		escolha1 = menuTemaOuAleatoria();
		System.out.println();
		
		if(escolha1 == 1){
			tema = menuTema();
			
			if(nivel == 3 && tema == 1){
					tentativasRestantes = dificil.getTentativasRestantes();
					
					palavra = animais.getPalavraArquivo();
					tracejarPalavra(palavra, copiaTracejada);
					tela.adicionaJogador(jogador.cria_se());
					
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
			
		}
		else if(escolha1 == 0){
			//vai adivinhar uma palavra aleatória do arquivo Animais
		}
		else{
			System.out.println("Opção inválida!");
		}
	}
	
	public static int tamanho(String palavra){//criei para palavras compostas
		int tamanhoReal = 0;
		
		for(int i = 0; i < palavra.length(); i++){
			if(palavra.charAt(i) != ' '){
				tamanhoReal++;
			}
		}
		
		return tamanhoReal;
	}

	public static int menuTema() {
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

	public static int menuTemaOuAleatoria() {
		int escolha1 = 0;
		System.out.println("Digite 1 (um) para escolher o tema da palavra.");
		System.out.println("Digite 0 (zero) para adivinhar uma palavra de tema aleatório.");
		System.out.print("Aqui: ");
		escolha1 = scan.nextInt();
		return escolha1;
	}

	public static int menuNiveis() {
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
	
	public static void tracejarPalavra(String palavra, char[] copiaTracejada){
		for (int i = 0; i < palavra.length(); i++) {
			if(palavra.charAt(i) != ' ')
				copiaTracejada[i] = '_';
			
		}
	}
}