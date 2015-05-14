package niveis;

import interfaces.TipoNiveis;

public class Medio implements TipoNiveis {
	int tentativasRestantes = 10;

	@Override
	public void desenhaCorpo(int quantErro, char[][] forca) {
		// TODO Auto-generated method stub
		
	}

	public int getTentativasRestantes() {
		return tentativasRestantes;
	}

}
