
public abstract class Arthropode extends Animal{

	private int pattes;

	public Arthropode() {};
	public Arthropode(String name, String cri, String move, int pattes) {
		super(name, cri, move);
		this.pattes = pattes;
	}

	public int getNbPattes() {
		return pattes;
	}

}
