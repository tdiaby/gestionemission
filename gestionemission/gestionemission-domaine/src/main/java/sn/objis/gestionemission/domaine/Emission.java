package sn.objis.gestionemission.domaine;
/**
 * Cette classe permet de decrire une emission televisee
 * @author Gassama
 *@version 1
 */
public  class Emission{
	private int id;
	private String nom;
	private String animateur; 
	private int duree;
	/**Constructeur sans parametre de la classe
	 */
	public Emission()
	{
	}
	/**Constructeur avec parametre de la classe
	 * il permet d'instancier une classe, de creer un objet 
	 * @param id identifiant d'une emission
	 * @param nom  d'une emission
	 * @param animateur de la persionne qui presente l'emission
	 * @param duree duree de passage d'une emission
	 */
	public Emission(int id,String nom, String animateur, int duree) {
		super();
		this.id=id;
		this.nom = nom;
		this.animateur = animateur;
		this.duree = duree;
	}
	// les getters de la classe
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getAnimateur() {
		return animateur;
	}

	public int getDuree() {
		return duree;
	}
	// les setters de la classe
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setAnimateur(String animateur) {
		this.animateur = animateur;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	
	}







