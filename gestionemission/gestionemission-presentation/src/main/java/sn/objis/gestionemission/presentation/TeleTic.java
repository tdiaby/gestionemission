package sn.objis.gestionemission.presentation;
import sn.objis.gestionemission.dao.*;
import sn.objis.gestionemission.domaine.Emission;
import sn.objis.gestionemission.service.*;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/**
 * Cette classe represente la classe principale du programme.
 * elle permet d'executer le programme
 * @version 1
 * @author Gassama
 *
 */
public class TeleTic {
	private static int reponse;

	public static void main(String[] args) {
		IServiceImplEmission serviceEmission = new IServiceImplEmission();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("GESTION D'EMISSION TELEVISEE");
		do{
		System.out.println("Veuillez choisir une option");
		System.out.println("1:creer une emission");
		System.out.println("2:Modifier une �mission");
		System.out.println("3:Supprimer une �mission");
		System.out.println("4:Rechercher une �mission en utilisant son identifiant");
		System.out.println("5:lister toutes les �mission de la T�l�vision");
		int choix = sc.nextInt();
		sc.nextLine();
		switch (choix) {
		case 1:
			System.out.println("entrer l'identifiant");
			int i=sc.nextInt();
			sc.nextLine();
			System.out.println("entrer le nom");
			String nom = sc.nextLine();
			System.out.println("entrer le nom de l'animateur");
			String nomAnim = sc.nextLine();
			System.out.println("entrer la duree");
			int d = sc.nextInt();
			Emission em = new Emission(i,nom, nomAnim,d);
			serviceEmission.ajouter(em);
			break;
		case 2:
			System.out.println("saisir le num�ro de l'emission � mettre � jour");
			int n = sc.nextInt();
			sc.nextLine();
			Emission Enregmodif =serviceEmission.rechercherUneEmission(n);
			if(Enregmodif == null) {
				System.out.println("une emission avec cet identifiant n'existe pas  dans la base");
				
			}else {
				System.out.println("entrer le nom du nouveau animateur");
				String nouveauNom = sc.nextLine();
				Enregmodif.setAnimateur(nouveauNom);
				serviceEmission.maj(Enregmodif);
				
			}
			break;
		case 3:
			System.out.println("saisir le num�ro de l'emission � supprimer");
			int num = sc.nextInt();
			Emission Enregsupp =serviceEmission.rechercherUneEmission(num);
			if(Enregsupp == null) {
			System.out.println("ce numero de carte ne se trouve pas  dans la base");
			}
			else {
			serviceEmission.supprimer(Enregsupp);
		}
		break;
		case 4:
			System.out.println("saisir le num�ro de l'emission � rechercher");
			int numRec = sc.nextInt();
			Emission emissionRec =serviceEmission.rechercherUneEmission(numRec);
		if(emissionRec == null) {
			System.out.println("ce numero de carte ne se trouve pas  dans la base");
		}else {
			System.out.println(emissionRec.getId()+" "+emissionRec.getNom()+" "+emissionRec.getAnimateur()+" "+emissionRec.getDuree() );
		}
			break;
		case 5:
			List<Emission> listEmission = serviceEmission.lister();
			
			if (listEmission != null && listEmission.size() > 0) {
				Iterator<Emission> iter = listEmission.iterator();
				while (iter.hasNext()) {
					Emission emiss = iter.next();
					System.out.println("IdEmission :"+emiss.getId()+" NomEmission :"+emiss.getNom()+" AnimateurEmissio: "+emiss.getAnimateur()+" DureeEmission: "+emiss.getDuree());
					System.out.println("---------------------------------------");
				} 
			}
			break;
	}
		System.out.println("Voulez vous continuer ? si oui tapez 0 sinon tapez 1");
		reponse=sc.nextInt();
	}while(reponse==0);

}
}
