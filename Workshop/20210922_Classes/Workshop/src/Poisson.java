
public class Poisson extends Animal implements Ovipare{

	public Poisson() {};
	public Poisson (String name) {
		super(name);
	}

	@Override
	public void bouger() {
		System.out.print("je nage");
	}

	@Override
	public Oeuf pondre() {
		return new Oeuf();
	}

	@Override
	public void crier() {
		System.out.print("bloups");
	}
}
