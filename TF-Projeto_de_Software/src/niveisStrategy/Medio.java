package niveisStrategy;

import interfaces.TipoNiveisStrategy;

public class Medio implements TipoNiveisStrategy {
	int tentativasRestantes = 10;

	@Override
	public void desenhaCorpo(int quantErro, char[][] forca) {
		// TODO Auto-generated method stub
		
	}

	public int getTentativasRestantes() {
		return tentativasRestantes;
	}

}
