
public class Chien extends Arthropode{

	public Chien() {};
	public Chien (String name,int pattes) {
		super(name,pattes);
	}

	@Override
	public void bouger() {
		System.out.print("je cours");
	}
	@Override
	public void crier() {
		System.out.print("aboiement");
	}

}
