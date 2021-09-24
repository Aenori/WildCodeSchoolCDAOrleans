
public class Serpent extends Animal implements Ovipare{

	public Serpent() {};
	public Serpent (String name, String cri, String move) {
		super(name,cri,move);
	}
	@Override
	public Oeuf pondre() {
		return new Oeuf();
	}
}
