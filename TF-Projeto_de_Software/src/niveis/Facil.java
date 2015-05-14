package niveis;

import interfaces.TipoNiveis;

public class Facil implements TipoNiveis {
	int tentativasRestantes = 13;

	@Override
	public void desenhaCorpo(int quantErro, char[][] forca) {
		// TODO Auto-generated method stub
		
	}

	public int getTentativasRestantes() {
		return tentativasRestantes;
	}

}
