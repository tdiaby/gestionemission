package sn.objis.gestionemission.service;
import java.util.List;
/**
 * Cette interface est generique. 
 * elle permet de travailler avec des objets sans se soucier du type
 * @version 1
 * @author Gassama
 *
 */ 
public interface IServiceGenerique<E> {
	/**methode generique permettant d'ajouter un objet
	 * @param e un objet
	 */
	public void ajouter(E e);
	/**methode generique permettant de mettre un objet
	 * @param e un objet
	 */
	public void maj(E e);
	/**methode generique permettant de retourner un ensemble d'objets 
	 * @return un objet
	 */
	public List<E> lister();
	/**methode generique permettant de supprimer un objets donnee en parametre 
	 *@param e un objet
	 */
	public void supprimer(E e);
}
