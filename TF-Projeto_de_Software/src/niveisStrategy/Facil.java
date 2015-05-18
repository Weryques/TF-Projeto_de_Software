package niveisStrategy;

import interfaces.TipoNiveisStrategy;

public class Facil implements TipoNiveisStrategy {
	int tentativasRestantes = 13;

	@Override
	public void desenhaCorpo(int quantErro, char[][] forca) {
		// TODO Auto-generated method stub
		
	}

	public int getTentativasRestantes() {
		return tentativasRestantes;
	}

}
