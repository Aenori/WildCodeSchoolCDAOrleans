
public class Chat extends Arthropode{

	public Chat() {};
	public Chat (String name,int pattes) {
		super(name,pattes);
	}

	@Override
	public void bouger() {
		System.out.print("je cours");
	}

	@Override
	public void crier() {
		System.out.print("miaule");
	}
}
