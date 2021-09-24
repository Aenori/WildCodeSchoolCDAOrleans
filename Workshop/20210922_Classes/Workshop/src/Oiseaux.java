
public class Oiseaux extends Arthropode implements Ovipare{

	public Oiseaux() {};
	public Oiseaux (String name,int pattes) {
		super(name,pattes);
	}

	@Override
	public void bouger() {
		System.out.print("je vole");
	}

	@Override
	public Oeuf pondre() {
		return new Oeuf();
	}

	@Override
	public void crier() {
		System.out.print("siffle");
	}
}
