package sn.objis.gestionemission.dao;

import java.util.List;
/**
 * Cette interface est generique. 
 * elle permet de traiter differents objets d'une base de donnees sans se soucier du type
 * @version 1
 * @author Gassama
 *
 */
public interface IDaoGenerique<E> {
	/**methode generique permettant d'inserrer un objet dans une base de donnees
	 *@param e une emission
	 */
	public void create(E e);
	/**methode generique permet de parcourrir les objets d'une base de donnees 
	 *et les stocke dans une liste qu'elle va retouner � la fin
	 *@return une liste d'objet
	 */
	public List<E> read();
	/**methode generique permettant de modifier un objet d'une base donnees 
	 * @param e une emission
	 */
	public void update(E e);
	/**methode generique permettant de supprimer un objet d'une base donnees donne en parametre
	 *@param e une emission
	 */
	public void delete(E e);

}
