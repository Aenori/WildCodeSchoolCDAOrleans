package worshopClasses;

public class Chat extends Animal{
	
	public Chat(String nom,int NbPattes ) {
		super(nom,NbPattes );
	
	}

	@Override
	public String crier() {
		return "miaoww miaw";
		
	}

	@Override
	public String bouger() {
		return "je cours";
		
	}
	public void pondre() {
		
		}

}
