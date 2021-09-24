
public class Dauphin extends Animal{

	public Dauphin() {};
	public Dauphin (String name) {
		super(name);
	}
	@Override
	public void bouger() {
		System.out.print("je nage");
	}
	@Override
	public void crier() {
		System.out.print("bloubloup");
	}

}
