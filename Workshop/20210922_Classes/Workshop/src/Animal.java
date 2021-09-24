
public abstract class Animal {

	private String name;
	private String cri;
	private String move;


	public Animal() {};
	public Animal(String name, String cri, String move) {
		this.name = name;
		this.cri = cri;
		this.move = move;
	};

	public String getName() {
		return name;
	}
	public void crier() {
		System.out.println(this.cri);
	}
	public void bouger() {
		System.out.println(this.move);
	}
}
