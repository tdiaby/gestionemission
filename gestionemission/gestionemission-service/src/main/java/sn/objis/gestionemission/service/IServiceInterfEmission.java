package sn.objis.gestionemission.service;
import sn.objis.gestionemission.domaine.*;
public interface IServiceInterfEmission extends IServiceGenerique<Emission>{
	public Emission rechercherUneEmission(int id);
}
