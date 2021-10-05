package worshopClasses;

public class Serpent extends Animal{

	public Serpent(String nom) {
		super(nom);
	
	}
	@Override
	public String crier() {
		return "je siiiiiiiifle";
		
	}

	@Override
	public String bouger() {
		return "je rampe";
		
	}
	@Override
	public void pondre() {
		Egg oeuf = new Egg();
		
		System.out.println("je pond un: "+oeuf.toString());
	
	}

}
