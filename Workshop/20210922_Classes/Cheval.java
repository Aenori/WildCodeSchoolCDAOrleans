package worshopClasses;

public class Cheval extends Animal{
	public Cheval(String nom,int NbPattes ) {
		super(nom,NbPattes);
	
	}
	@Override
	public String crier() {
		return "ouhuuhou";
		
	}

	@Override
	public String bouger() {
		return "je cours";
		
	}
	@Override
	public void pondre() {
		
		
	}
	
	

}
