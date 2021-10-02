package worshopClasses;

public class Poisson extends Animal{

public Poisson(String nom) {
	super(nom);
}
	@Override
	public String crier() {
		return "voice of fish !";
		
	}

	@Override
	public String bouger() {
		return "je nage ";
		
	}
	
	public void pondre() {
		Egg oeuf = new Egg();
		
		System.out.println("je pond un: "+oeuf.toString());
			
		}

}
