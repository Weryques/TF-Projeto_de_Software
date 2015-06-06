package principal;

import java.io.IOException;

import interfaces.AdivinhacaoStrategy;

public class PalavraContext {
	AdivinhacaoStrategy todasLetras;
	AdivinhacaoStrategy letraPorLetra;

	public void setTodasLetras(AdivinhacaoStrategy todasLetras) {
		this.todasLetras = todasLetras;
	}

	public void setLetraPorLetra(AdivinhacaoStrategy letraPorLetra) {
		this.letraPorLetra = letraPorLetra;
	}

	public void todasLetras() throws IOException{
		todasLetras.adivinhar();
	}
	
	public void letraPorLetra() throws IOException{
		letraPorLetra.adivinhar();
	}
}
