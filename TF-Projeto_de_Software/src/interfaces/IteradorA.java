package interfaces;

/**Interface Iterator
 * @author weryquessantos
 *
 */
public interface IteradorA {
	
	/**Metodo que verifica se ha proximo objeto a ser iterador
	 * @return boolean
	 */
	boolean hasNext();
	
	/**Metodo que retorna o objeto
	 * @return Object
	 */
	Object next();
}
