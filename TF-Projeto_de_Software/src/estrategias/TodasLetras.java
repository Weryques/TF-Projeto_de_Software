package estrategias;

import interfaces.AdivinhacaoStrategy;

import java.io.*;
import java.util.*;

import niveis.*;
import observadores.*;
import principal.*;
import temas.*;

/** Classe reponsavel pela estrategia de Todas as letras
 * @author weryquessantos
 * 
 * */

public class TodasLetras extends Estrategia implements AdivinhacaoStrategy {
	private static Scanner scan = new Scanner(System.in);

	/** Parametros recebidos ao ser instanciada
	 * @param palavraCont
	 * @param visao
	 * @param animais
	 * @param filmes
	 * @param profissoes
	 * @param tela
	 * @param fimJogo
	 * @param bancoLetras
	 * @param forcaI
	 * @param palavraAnonima
	 * @param dificil
	 * @param facil
	 * @param medio
	 * @param controle
	 */

	public TodasLetras(PalavraContext palavraCont, Visao visao,
			Animais animais, Filmes filmes, Profissoes profissoes,
			TelaObservavel tela, FimJogo fimJogo,
			BancoLetrasErradas bancoLetras, Forca forcaI,
			PalavraAnonima palavraAnonima, Dificil dificil, Facil facil,
			Medio medio, Controle controle) {
		super(palavraCont, visao, animais, filmes, profissoes, tela, fimJogo,
				bancoLetras, forcaI, palavraAnonima, dificil, facil, medio, controle);
	}

		
	/* (non-Javadoc)
	 * @see interfaces.AdivinhacaoStrategy#adivinhar()
	 */
	@Override
	public void adivinhar() throws IOException{
		
		while(true){ 
			System.out.println();
			/**
			 * define nivel
			 */
			setNivel(getVisao().menuNiveis()); 
			
			/**
				 * ver se não foi digitada opção invalida no menu niveis
				 */
			if(getControle().opMenuValidar(getNivel())){ 
				
				System.out.println();
				/**
				 * pega a escolha		
				 */
				setEscolha1(getVisao().menuTemaOuAleatoria()); 
				
				
				System.out.println();

				getVisao().limparConsole();
				/**
					 * vai pegar palavra do tema definido
					 */
				if(getEscolha1() == 1){
					
					setTema(getVisao().menuTema());
					if(getControle().opMenuValidar(getEscolha1())){
						getVisao().limparConsole();
						break;
					}
					else{
						getVisao().limparConsole();
						getVisao().opInvalida();
					}

				}
				/**
					 * continua com a palavra do tema animais...
					 */
				else if(getEscolha1() == 0){
					
					getVisao().limparConsole();
					/**
					 *  ...e sai do loop
					 */
					break; 
					

				}
				else{
					getVisao().limparConsole();
					getVisao().opInvalida();
				}
			}
			else{
				getVisao().limparConsole();
				getVisao().opInvalida();
			}
		}
		/** Define as chances de errar a partir da opção escolhida no menu. Metodo herdade da @class Estrategia
		 * Intancias das classes:
		 * @param Controle
		 * @param Dificil
		 * @param Facil
		 * @param Medio
		 * 
		 * @param nivel escolhido no menu
		 */
		setTentativasRestantes(getControle().definirTentativas(getDificil(), getFacil(), getMedio(), getNivel(), getTentativasRestantes())); 
		
		
		/** Define a palavra a partir da opção escolhida no menu. Metodo herdado da @class Estrategia
		 * @param Animais
		 * @param Filmes
		 * @param Profissoes
		 * @param tema
		 */
		setPalavra(getControle().definirPalavra(getAnimais(), getFilmes(), getProfissoes(), getTema()));
		
		
		
		/**Metodo que traceja a palavra, chamado na @class Controle, define os traços da palvra anonima
		 * @param palavra
		 * @param copiaTracejada
		 */
		getControle().tracejarPalavra(getPalavra(), getCopiaTracejada());
		
		
		/**Metodo que adiciona o observadores, chamado na @class Controle
		 * @param Tela
		 * @param FimJogo
		 * @param BaconLetrasErradas
		 * @param Forca
		 * @param PalavraAnonima
		 */
		getControle().adicionaObservers(getTela(), getFimJogo(), getBancoLetras(), getForcaI(), getPalavraAnonima());
		
		

		while(true){
			int qA = 0;
			int escolha2;

			getVisao().limparConsole();
			getTela().setEnviarDadosAlterados(getCopiaTracejada(), getErradas(), getTentativasRestantes(), getResultado());
			/**Condição que verifica se a quantidade de acertos é do tamanho da palavra, se sim, o jogador acertou
			 * @param qAcertos
			 */
			if(getqAcertos() == getControle().tamanho(getPalavra())){
				setResultado("VOCÊ ACERTOU! PARABÉNS!");
				getTela().setEnviarDadosAlterados(null, null, 0, getResultado());

				while(true){				
					escolha2 = getVisao().menuFimDeJogo();
					
					if(getControle().opMenuValidar(escolha2)){
						reiniciarJogo(escolha2);
						break; //para o loop mais interno
					}
					else{
						getVisao().limparConsole();
						getVisao().opInvalida();
					}
				}
			}
			/**Condição que verifica se a quantidade de tentativas de errar chegou a zero, se sim, o jogador perdeu
			 * @param tentativasRestantes
			 */
			else if(getTentativasRestantes() == 0){
				setResultado("VOCÊ PERDEU. TENTE NOVAMENTE!");
				getTela().setEnviarDadosAlterados(null, null, 0, getResultado());

				while(true){
					escolha2 = getVisao().menuFimDeJogo();
					
					if(getControle().opMenuValidar(escolha2)){
						reiniciarJogo(escolha2);
						break; //para o loop mais interno
					}
					else{
						getVisao().limparConsole();
						getVisao().opInvalida();
					}
				}
			}
			

			getVisao().digiteLetra();
			setLetra(scan.next().charAt(0));

			/**estratégia letra por letra
			 * Verifica se a letra digitada existe na palavra e se ainda não foi revelada
			 * caso sim @param qAcertos é incrementada, @param qA é incrementada e a @param copiaTracejada recebe a letra
			 */
			for(int i = 0; i < getPalavra().length(); i++){
				if(getPalavra().charAt(i) == getLetra() && getCopiaTracejada()[i] != getLetra()){
					setqAcertos(getqAcertos() + 1);
					qA++;
					getCopiaTracejada()[i] = getLetra();
				}
			}
			
			/**Verifica se @param qA (contador de quantidade de acertos que é sempre zerado) é igual a zero, ou seja, a letra digita não existe na palavra ou todas as suas ocorrencias já foram mostradas
			 * se sim
			 * o banco @erradas rece a letra e @param tentativasRestantes é decrementada
			 * 
			 */
			if(qA == 0){
				getErradas()[h++] = getLetra();
				setTentativasRestantes(getTentativasRestantes() - 1);
			}
			
		}
	}

}