package worshopClasses;

public abstract class Animal {
	
	private String nom;
	// NRO 2021-09-27 : non surtout pas, les noms des attributs commencent par
	//  des miniscules
	private int NbPattes;
	
	
	public Animal(String nom, int NbPattes) {
		
		this.nom = nom;
		this.NbPattes= NbPattes;
	}
	public Animal(String nom) {
		this.nom = nom;
		
	}
	public int getNbPattes() {
		return NbPattes;
	}

	public void setNbPattes(int nbPattes) {
		NbPattes = nbPattes;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return "Animal [nom=" + nom + "]";
	}

	// Attention à l'indentation
	 public abstract String crier();
	public abstract String bouger();

	// Lever une NotImplementedException dans ce cas
	 abstract void pondre();
	

}
