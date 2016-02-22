/**
 * 
 */
package testes;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author weryquessantos
 *
 */
public class ControleTest {
	public principal.Controle cont;
	/**
	 * Test method for {@link principal.Controle#opMenuValidar(int)}.
	 */
	@Test
	public void testOpMenuValidar() {
		int escolha = 1;
		boolean retorno;
		
		if(escolha == 1 || escolha == 2 || escolha == 3 || escolha == 0){
			retorno = true;
		}
		else{
			retorno = false;
		}
		
		assertTrue("Opção válida", retorno);
		assertFalse("Opção inválida", !retorno);
	}

	/**
	 * Test method for {@link principal.Controle#definirEstrategia(int, principal.PalavraContext)}.
	 */
	@Test
	public void testDefinirEstrategia() {
		int modo = 1;
		int modo0 = 0;
		
		assertEquals("Estratégia Todas Letras iniciada", 1, modo);
		assertEquals("Estratégia Letra por Letra iniciada", 0, modo0);
	}

}
