
public abstract class Arthropode extends Animal{

	private int pattes;

	public Arthropode() {};
	public Arthropode(String name, int pattes) {
		super(name);
		this.pattes = pattes;
	}

	public int getNbPattes() {
		return pattes;
	}

}
