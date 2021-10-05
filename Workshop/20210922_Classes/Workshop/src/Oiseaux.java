
public class Oiseaux extends Arthropode implements Ovipare{

	public Oiseaux() {};
	public Oiseaux (String name, String cri, String move, int pattes) {
		super(name, cri, move, pattes);
	}


	@Override
	public Oeuf pondre() {
		return new Oeuf();
	}

}
