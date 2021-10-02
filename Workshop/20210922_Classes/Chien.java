package worshopClasses;

public class Chien extends Animal{

	public Chien(String nom,int NbPattes ) {
		super(nom,NbPattes);
		
	
	}
	
	@Override
	public String toString() {
		return "Chien []";
	}

	@Override
	public String crier() {
		return "ouaf ouaf";
		
	}

	@Override
	public String bouger() {
		return "je cours";
		
	}
	public void pondre() {
		
			
		}
	

}
