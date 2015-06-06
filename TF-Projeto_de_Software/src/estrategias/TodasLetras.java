package estrategias;

import interfaces.AdivinhacaoStrategy;

import java.io.*;
import java.util.*;

import niveis.*;
import observadores.*;
import principal.*;
import temas.*;

public class TodasLetras extends Estrategia implements AdivinhacaoStrategy {	

	public TodasLetras(PalavraContext palavraCont, Visao visao,
			Animais animais, Filmes filmes, Profissoes profissoes,
			TelaObservavel tela, FimJogo fimJogo,
			BancoLetrasErradas bancoLetras, Forca forcaI,
			PalavraAnonima palavraAnonima, Dificil dificil, Facil facil,
			Medio medio, Controle controle) {
		super(palavraCont, visao, animais, filmes, profissoes, tela, fimJogo,
				bancoLetras, forcaI, palavraAnonima, dificil, facil, medio, controle);
	}

	static Scanner scan = new Scanner(System.in);
		
	@Override
	public void adivinhar() throws IOException{
		
		while(true){ //INICIO
			System.out.println();
			setNivel(getVisao().menuNiveis()); //define nivel
			
			if(getControle().opMenuValidar(getNivel())){ //ver se não foi digitada opção invalida no menu niveis
				System.out.println();
				
				setEscolha1(getVisao().menuTemaOuAleatoria()); //pega a escolha		
				
				System.out.println();

				getVisao().limparConsole();

				if(getEscolha1() == 1){//vai pegar palavra do tema definido
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
				else if(getEscolha1() == 0){//continua com a palavra do tema animais...
					getVisao().limparConsole();
					break; // ...e sai do loop

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

		setTentativasRestantes(getControle().definirTentativas(getDificil(), getFacil(), getMedio(), getNivel(), getTentativasRestantes())); 
		setPalavra(getControle().definirPalavra(getAnimais(), getFilmes(), getProfissoes(), getTema()));

		getControle().tracejarPalavra(getPalavra(), getCopiaTracejada());
		
		getControle().adicionaObservers(getTela(), getFimJogo(), getBancoLetras(), getForcaI(), getPalavraAnonima());

		while(true){
			int qA = 0, escolha2;

			getVisao().limparConsole();
			getTela().setEnviarDadosAlterados(getCopiaTracejada(), getErradas(), getTentativasRestantes(), getResultado());

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

			//estratégia
			for(int i = 0; i < getPalavra().length(); i++){
				if(getPalavra().charAt(i) == getLetra() && getCopiaTracejada()[i] != getLetra()){
					setqAcertos(getqAcertos() + 1);
					qA++;
					getCopiaTracejada()[i] = getLetra(); 
				}
			}

			if(qA == 0){
				getErradas()[h++] = getLetra();
				setTentativasRestantes(getTentativasRestantes() - 1);
			}
		}
	}
}
