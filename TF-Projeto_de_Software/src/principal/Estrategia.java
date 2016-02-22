package principal;

import java.io.IOException;
import niveis.*;
import observadores.*;
import temas.*;

/**Classe que contem os atributos e metodos comuns das estrategias
 * @author weryquessantos
 *
 */
public class Estrategia {
	/**
	 * Atributos
	 */
	private char[] copiaTracejada = new char[100];
	private int qAcertos = 0;
	protected int h = 0;
	private char letra;
	private String resultado = null;
	private int tema = 0, nivel = 0;
	private String palavra;
	private int tentativasRestantes = 0;
	private char[] erradas = new char[100];
	private int escolha1 = 0;
	
	private PalavraContext palavraCont;
	private Visao visao;
	private Animais animais;
	private Filmes filmes;
	private Profissoes profissoes;
	private TelaObservavel tela;
	private FimJogo fimJogo;
	private BancoLetrasErradas bancoLetras;
	private Forca forcaI;
	private PalavraAnonima palavraAnonima;
	private Dificil dificil;
	private Facil facil;
	private Medio medio;
	private Controle controle;
	
	/**
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
	public Estrategia(PalavraContext palavraCont, Visao visao, Animais animais,
			Filmes filmes, Profissoes profissoes, TelaObservavel tela,
			FimJogo fimJogo, BancoLetrasErradas bancoLetras, Forca forcaI,
			PalavraAnonima palavraAnonima, Dificil dificil, Facil facil,
			Medio medio, Controle controle) {
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
	
	/**Metodo de reinicio do jogo
	 * @param escolha2
	 * @throws IOException
	 */
	public void reiniciarJogo(int escolha2) throws IOException {
		/**troca de palavra*/
		if(escolha2 == 1){ 
			tentativasRestantes = controle.definirTentativas(dificil, facil, medio, nivel, tentativasRestantes); //chama o metodo para definir tentativas de errar
			palavra = controle.definirPalavra(animais, filmes, profissoes, tema); //chama o metodo para definir nova palavra

			zerarVariaveis();
			controle.tracejarPalavra(palavra, copiaTracejada);

			tela.setEnviarDadosAlterados(copiaTracejada, erradas, tentativasRestantes, resultado);
		}
		/**troca de nível*/
		else if(escolha2 == 2){ 
			visao.limparConsole();
			
			nivel = visao.menuNiveis();//difere
			tentativasRestantes = controle.definirTentativas(dificil, facil, medio, nivel, tentativasRestantes);
			palavra = controle.definirPalavra(animais, filmes, profissoes, tema);

			zerarVariaveis();
			controle.tracejarPalavra(palavra, copiaTracejada);

			tela.setEnviarDadosAlterados(copiaTracejada, erradas, tentativasRestantes, resultado);
		}
		/**troca de tema*/
		else if(escolha2 == 3){ 
			visao.limparConsole();
			
			tema = visao.menuTema();//difere
			tentativasRestantes = controle.definirTentativas(dificil, facil, medio, nivel, tentativasRestantes);
			palavra = controle.definirPalavra(animais, filmes, profissoes, tema);

			zerarVariaveis();
			controle.tracejarPalavra(palavra, copiaTracejada);

			tela.setEnviarDadosAlterados(copiaTracejada, erradas, tentativasRestantes, resultado);
		}
		/**remove todos os observers e sai do jogo*/
		else if(escolha2 == 0){ 
			visao.fimJogo();
			tela.remove();
		}
	}
	
	/**
	 * Metodo para zerar as variáveis e impedir lixo ao reiniciar o jogo
	 */
	public void zerarVariaveis() {
		for(int i = 0; i < copiaTracejada.length; i++)
			copiaTracejada[i] = '\0';

		for(int i = 0; i < erradas.length; i++)
			erradas[i] = '\0';
		letra = '\0';
		resultado = null;
		qAcertos = 0;
		h = 0;
	}
	
	/**
	 * @return escolha1
	 */
	public int getEscolha1() {
		return escolha1;
	}

	/**
	 * @return palavraCont
	 */
	public PalavraContext getPalavraCont() {
		return palavraCont;
	}

	/**
	 * @return visao
	 */
	public Visao getVisao() {
		return visao;
	}

	/**
	 * @return animais
	 */
	public Animais getAnimais() {
		return animais;
	}

	/**
	 * @return filmes
	 */
	public Filmes getFilmes() {
		return filmes;
	}

	/**
	 * @return profissoes
	 */
	public Profissoes getProfissoes() {
		return profissoes;
	}

	/**
	 * @return tela
	 */
	public TelaObservavel getTela() {
		return tela;
	}

	/**
	 * @return fimJogo
	 */
	public FimJogo getFimJogo() {
		return fimJogo;
	}

	/**
	 * @return bancoLetras
	 */
	public BancoLetrasErradas getBancoLetras() {
		return bancoLetras;
	}

	/**
	 * @return forcaI
	 */
	public Forca getForcaI() {
		return forcaI;
	}

	/**
	 * @return palavraAnonima
	 */
	public PalavraAnonima getPalavraAnonima() {
		return palavraAnonima;
	}

	/**
	 * @return dificil
	 */
	public Dificil getDificil() {
		return dificil;
	}

	/**
	 * @return facil
	 */
	public Facil getFacil() {
		return facil;
	}

	/**
	 * @return medio
	 */
	public Medio getMedio() {
		return medio;
	}

	/**
	 * @return controle
	 */
	public Controle getControle() {
		return controle;
	}
	
	/**
	 * @return copiaTracejada
	 */
	public char[] getCopiaTracejada() {
		return copiaTracejada;
	}

	/**
	 * @return aAcertos
	 */
	public int getqAcertos() {
		return qAcertos;
	}

	/**
	 * @return h
	 */
	public int getH() {
		return h;
	}

	/**
	 * @return letra
	 */
	public char getLetra() {
		return letra;
	}

	/**
	 * @return resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @return tema
	 */
	public int getTema() {
		return tema;
	}

	/**
	 * @return nivel
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * @return palavra
	 */
	public String getPalavra() {
		return palavra;
	}

	/**
	 * @return tentativasRestantes
	 */
	public int getTentativasRestantes() {
		return tentativasRestantes;
	}

	/**
	 * @return erradas
	 */
	public char[] getErradas() {
		return erradas;
	}

	/**Seta copiaTracejada
	 * @param copiaTracejada
	 */
	public void setCopiaTracejada(char[] copiaTracejada) {
		this.copiaTracejada = copiaTracejada;
	}

	/**Seta acertos
	 * @param qAcertos
	 */
	public void setqAcertos(int qAcertos) {
		this.qAcertos = qAcertos;
	}

	/**Seta h
	 * @param h
	 */
	public void setH(int h) {
		this.h = h;
	}

	/**Seta letra
	 * @param letra
	 */
	public void setLetra(char letra) {
		this.letra = letra;
	}

	/**Seta resultado
	 * @param resultado
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	/**Seta tema
	 * @param tema
	 */
	public void setTema(int tema) {
		this.tema = tema;
	}

	/**Seta nivel
	 * @param nivel
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**Seta palavra
	 * @param palavra
	 */
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	/**Seta tentativasRestantes
	 * @param tentativasRestantes
	 */
	public void setTentativasRestantes(int tentativasRestantes) {
		this.tentativasRestantes = tentativasRestantes;
	}

	/**Seta erradas
	 * @param erradas
	 */
	public void setErradas(char[] erradas) {
		this.erradas = erradas;
	}

	/**Seta escolha1
	 * @param escolha1
	 */
	public void setEscolha1(int escolha1) {
		this.escolha1 = escolha1;
	}
}

