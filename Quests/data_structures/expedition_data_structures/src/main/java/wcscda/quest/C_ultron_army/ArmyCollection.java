package wcscda.quest.C_ultron_army;

import wcscda.quest.Sentinel;

import java.util.Collection;

public class ArmyCollection implements UltronArmy {
	private final Collection<Sentinel> collection;

	public ArmyCollection(Collection<Sentinel> collection) {
		this.collection = collection;
	}

	@Override
	public boolean add(Sentinel sentinel) {
		return collection.add(sentinel);
	}

	@Override
	public int size() {
		return collection.size();
	}

	@Override
	public Sentinel[] getPatrol(int patrolSize) {
		 int i=0;
		Sentinel[] tab = new Sentinel[patrolSize];
		for (Sentinel sentinel : collection) {
			
				if(i<patrolSize) {
					tab[i] = sentinel;
					i++;
			}
		}
			for (int j = 0; j < tab.length; j++) {
				collection.remove(tab[j]);
			}
			
		
		return tab;
	}

	@Override
	public void patrolReturn(Sentinel[] sentinels) {
		for (Sentinel sentinel : sentinels) {
			collection.add(sentinel);
		}
	}

	@Override
	public boolean contains(Sentinel sentinel) {
		return collection.contains(sentinel);
	}
}
