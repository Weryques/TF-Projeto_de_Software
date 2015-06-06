package niveis;

import interfaces.Nivel;


public class Dificil implements Nivel{
	int tentativasRestantes = 6;
	
	public int getTentativasRestantes() {
		return tentativasRestantes;
	}
}
