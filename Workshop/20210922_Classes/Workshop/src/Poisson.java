
public class Poisson extends Animal implements Ovipare{

	public Poisson() {};
	public Poisson (String name, String cri, String move) {
		super(name,cri,move);
	}

	@Override
	public Oeuf pondre() {
		return new Oeuf();
	}
}
