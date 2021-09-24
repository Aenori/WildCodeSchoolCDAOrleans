
public class Cheval extends Arthropode{

	public Cheval() {};
	public Cheval (String name,int pattes) {
		super(name,pattes);
	}

	@Override
	public void crier() {
		System.out.print("hennissement");
	}
	@Override
	public void bouger() {
		System.out.print("je cours");
	}

}
