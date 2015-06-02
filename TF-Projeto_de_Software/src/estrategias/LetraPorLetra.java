package estrategias;

import java.io.IOException;
import java.util.Scanner;

import niveis.*;
import observadores.*;
import principal.*;
import temas.*;
import interfaces.AdivinhacaoStrategy;

public class LetraPorLetra implements AdivinhacaoStrategy {
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
	
	PalavraContext palavraCont;
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
	Controle controle;
	
	public LetraPorLetra(Controle controle, PalavraContext palavraCont, Visao visao, Animais animais, Filmes filmes,
			Profissoes profissoes, TelaObservavel tela, FimJogo fimJogo,
			BancoLetrasErradas bancoLetras, Forca forcaI,
			PalavraAnonima palavraAnonima, Dificil dificil, Facil facil,
			Medio medio) {
		
		super();
		this.palavraCont = palavraCont;
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
		this.controle = controle;
	}
	
	@Override
	public void adivinhar() throws IOException{
		
		while(true){ //INICIO
			System.out.println();
			nivel = visao.menuNiveis(); //define nivel
			
			if(controle.opMenuValidar(nivel)){ //ver se não foi digitada opção invalida no menu niveis
				System.out.println();
				
				escolha1 = visao.menuTemaOuAleatoria(); //pega a escolha		
				
				System.out.println();

				visao.limparConsole();

				if(escolha1 == 1){//vai pegar palavra do tema definido
					tema = visao.menuTema();
					if(controle.opMenuValidar(escolha1)){
						visao.limparConsole();
						break;
					}
					else{
						visao.limparConsole();
						visao.opInvalida();
					}

				}
				else if(escolha1 == 0){//continua com a palavra do tema animais...
					visao.limparConsole();
					break; // ...e sai do loop

				}
				else{
					visao.limparConsole();
					visao.opInvalida();
				}
			}
			else{
				visao.limparConsole();
				visao.opInvalida();
			}
		}

		tentativasRestantes = controle.definirTentativas(dificil, facil, medio, nivel, tentativasRestantes); 
		palavra = controle.definirPalavra(animais, filmes, profissoes, tema);

		controle.tracejarPalavra(palavra, copiaTracejada);
		
		controle.adicionaObservers(tela, fimJogo, bancoLetras, forcaI, palavraAnonima);

		while(true){
			int qA = 0, escolha2;

			visao.limparConsole();
			tela.setEnviarDadosAlterados(copiaTracejada, erradas, forca, tentativasRestantes, resultado);

			if(qAcertos == controle.tamanho(palavra)){
				resultado = "VOCÊ ACERTOU! PARABÉNS!";
				tela.setEnviarDadosAlterados(null, null, null, 0, resultado);

				while(true){				
					escolha2 = visao.menuFimDeJogo();
					
					if(controle.opMenuValidar(escolha2)){
						reiniciarJogo(escolha2);
						break; //para o loop mais interno
					}
					else{
						visao.limparConsole();
						visao.opInvalida();
					}
				}
			}
			else if(tentativasRestantes == 0){
				resultado = "VOCÊ PERDEU. TENTE NOVAMENTE!";
				tela.setEnviarDadosAlterados(null, null, null, 0, resultado);

				while(true){
					escolha2 = visao.menuFimDeJogo();
					
					if(controle.opMenuValidar(escolha2)){
						reiniciarJogo(escolha2);
						break; //para o loop mais interno
					}
					else{
						visao.limparConsole();
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
			tentativasRestantes = controle.definirTentativas(dificil, facil, medio, nivel, tentativasRestantes); //chama o metodo para definir tentativas de errar
			palavra = controle.definirPalavra(animais, filmes, profissoes, tema); //chama o metodo para definir nova palavra

			zerarVariaveis(erradas);
			controle.tracejarPalavra(palavra, copiaTracejada);

			tela.setEnviarDadosAlterados(copiaTracejada, erradas, forca, tentativasRestantes, resultado);
		}
		else if(escolha2 == 2){ //troca de nível
			visao.limparConsole();
			
			nivel = visao.menuNiveis();//difere
			tentativasRestantes = controle.definirTentativas(dificil, facil, medio, nivel, tentativasRestantes);
			palavra = controle.definirPalavra(animais, filmes, profissoes, tema);

			zerarVariaveis(erradas);
			controle.tracejarPalavra(palavra, copiaTracejada);

			tela.setEnviarDadosAlterados(copiaTracejada, erradas, forca, tentativasRestantes, resultado);
		}
		else if(escolha2 == 3){ //troca de tema
			visao.limparConsole();
			
			tema = visao.menuTema();//difere
			tentativasRestantes = controle.definirTentativas(dificil, facil, medio, nivel, tentativasRestantes);
			palavra = controle.definirPalavra(animais, filmes, profissoes, tema);

			zerarVariaveis(erradas);
			controle.tracejarPalavra(palavra, copiaTracejada);

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
}
