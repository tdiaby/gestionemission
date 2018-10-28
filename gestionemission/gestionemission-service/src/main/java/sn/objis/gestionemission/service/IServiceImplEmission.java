/**
 * 
 */
package sn.objis.gestionemission.service;
import java.util.List;

import sn.objis.gestionemission.dao.IDaoImplEmission;
import sn.objis.gestionemission.domaine.*;

/**
 * cette Classe permet de traiter des objet
 * @author GASSAMA
 *
 */
public class IServiceImplEmission implements IServiceInterfEmission{
	IDaoImplEmission daoEmission = new IDaoImplEmission();
		public void ajouter(Emission e) {
		daoEmission.create(e);
		
	}

	public void maj(Emission e) {
		daoEmission.update(e);
		
	}
	public List<Emission> lister() {
		
		return daoEmission.read();
	}

	public void supprimer(Emission e) {
		daoEmission.delete(e);
		
	}

	public Emission rechercherUneEmission(int id) {
		return daoEmission.trouverEmission(id);
	}
}
