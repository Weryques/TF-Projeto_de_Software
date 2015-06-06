package principal;

import java.io.IOException;
import niveis.*;
import observadores.*;
import temas.*;

public class Estrategia {
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
	
	public void reiniciarJogo(int escolha2) throws IOException {
		if(escolha2 == 1){ //troca de palavra
			tentativasRestantes = controle.definirTentativas(dificil, facil, medio, nivel, tentativasRestantes); //chama o metodo para definir tentativas de errar
			palavra = controle.definirPalavra(animais, filmes, profissoes, tema); //chama o metodo para definir nova palavra

			zerarVariaveis();
			controle.tracejarPalavra(palavra, copiaTracejada);

			tela.setEnviarDadosAlterados(copiaTracejada, erradas, tentativasRestantes, resultado);
		}
		else if(escolha2 == 2){ //troca de nível
			visao.limparConsole();
			
			nivel = visao.menuNiveis();//difere
			tentativasRestantes = controle.definirTentativas(dificil, facil, medio, nivel, tentativasRestantes);
			palavra = controle.definirPalavra(animais, filmes, profissoes, tema);

			zerarVariaveis();
			controle.tracejarPalavra(palavra, copiaTracejada);

			tela.setEnviarDadosAlterados(copiaTracejada, erradas, tentativasRestantes, resultado);
		}
		else if(escolha2 == 3){ //troca de tema
			visao.limparConsole();
			
			tema = visao.menuTema();//difere
			tentativasRestantes = controle.definirTentativas(dificil, facil, medio, nivel, tentativasRestantes);
			palavra = controle.definirPalavra(animais, filmes, profissoes, tema);

			zerarVariaveis();
			controle.tracejarPalavra(palavra, copiaTracejada);

			tela.setEnviarDadosAlterados(copiaTracejada, erradas, tentativasRestantes, resultado);
		}
		else if(escolha2 == 0){ //remove todos os observers e sai do jogo
			visao.fimJogo();
			tela.remove();
		}
	}
	
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
	
	public int getEscolha1() {
		return escolha1;
	}

	public PalavraContext getPalavraCont() {
		return palavraCont;
	}

	public Visao getVisao() {
		return visao;
	}

	public Animais getAnimais() {
		return animais;
	}

	public Filmes getFilmes() {
		return filmes;
	}

	public Profissoes getProfissoes() {
		return profissoes;
	}

	public TelaObservavel getTela() {
		return tela;
	}

	public FimJogo getFimJogo() {
		return fimJogo;
	}

	public BancoLetrasErradas getBancoLetras() {
		return bancoLetras;
	}

	public Forca getForcaI() {
		return forcaI;
	}

	public PalavraAnonima getPalavraAnonima() {
		return palavraAnonima;
	}

	public Dificil getDificil() {
		return dificil;
	}

	public Facil getFacil() {
		return facil;
	}

	public Medio getMedio() {
		return medio;
	}

	public Controle getControle() {
		return controle;
	}
	
	
	
	public char[] getCopiaTracejada() {
		return copiaTracejada;
	}

	public int getqAcertos() {
		return qAcertos;
	}

	public int getH() {
		return h;
	}

	public char getLetra() {
		return letra;
	}

	public String getResultado() {
		return resultado;
	}

	public int getTema() {
		return tema;
	}

	public int getNivel() {
		return nivel;
	}

	public String getPalavra() {
		return palavra;
	}

	public int getTentativasRestantes() {
		return tentativasRestantes;
	}

	public char[] getErradas() {
		return erradas;
	}

	public void setCopiaTracejada(char[] copiaTracejada) {
		this.copiaTracejada = copiaTracejada;
	}

	public void setqAcertos(int qAcertos) {
		this.qAcertos = qAcertos;
	}

	public void setH(int h) {
		this.h = h;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public void setTema(int tema) {
		this.tema = tema;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public void setTentativasRestantes(int tentativasRestantes) {
		this.tentativasRestantes = tentativasRestantes;
	}

	public void setErradas(char[] erradas) {
		this.erradas = erradas;
	}

	public void setEscolha1(int escolha1) {
		this.escolha1 = escolha1;
	}
}

