package sn.objis.gestionemission.dao;
import sn.objis.gestionemission.domaine.*;
/**
 * Cette interface doit etres implement par une classe qui va permettre de chercher une emission bien donnee
 * @author Gassama
 *@version 1
 */
public interface IDaoInterfEmission extends IDaoGenerique<Emission> {
	public Emission trouverEmission(int id);
}
