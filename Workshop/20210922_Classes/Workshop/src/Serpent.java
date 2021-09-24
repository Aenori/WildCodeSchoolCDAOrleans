
public class Serpent extends Animal implements Ovipare{

	public Serpent() {};
	public Serpent (String name) {
		super(name);
	}

	@Override
	public void bouger() {
		System.out.print("je rampe");
	}

	@Override
	public Oeuf pondre() {
		return new Oeuf();
	}

	@Override
	public void crier() {
		System.out.print("ssss");
	}
}
