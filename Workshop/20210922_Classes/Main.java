package worshopClasses;

public class Main {

	public static void main(String[] args) {
		Chien dog= new Chien("max",4);
		
		Chat cat = new Chat ("gafield",4);
		
		Serpent snake= new Serpent ("sleeper");
		Cheval horse= new Cheval ("tonner",4);
		Oiseaux bird= new Oiseaux ("angry");
		
		Poisson fish= new Poisson ("dory");
		
		Animal[] table = {dog,cat, snake,horse,bird,fish};
		
		for(int i=0;i<table.length ; i++) {
			System.out.println("je suis: "+table[i].getNom()+" je possede: "+table[i].getNbPattes()+" je fait "+table[i].crier()+" et  "+table[i].bouger());
			if(table[i] instanceof Serpent || table[i] instanceof Oiseaux || table[i] instanceof Poisson) {
				table[i].pondre();
			}
			
		}
		

	}

}
