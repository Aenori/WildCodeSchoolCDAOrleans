package worshopClasses;

public class Oiseaux extends Animal{
	public Oiseaux(String nom) {
		super(nom);
	}

public String pondre(String egg) {
	return egg;
}
	
	@Override
	public String crier() {
		return "tweeet tweet";
		
	}

	@Override
	public String bouger() {
		return "je vole";
		
	}
	@Override
	public void pondre() {
		Egg oeuf = new Egg();
		
		System.out.println("je pond un: "+oeuf.toString());
	
	}
	

}
