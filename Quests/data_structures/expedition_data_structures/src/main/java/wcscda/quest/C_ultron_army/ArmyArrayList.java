package wcscda.quest.C_ultron_army;

import wcscda.quest.Sentinel;

import java.util.ArrayList;
import java.util.Arrays;

public class ArmyArrayList implements UltronArmy {
	private ArrayList<Sentinel> sentinelArrayList = new ArrayList<>();
	
	@Override
	public boolean add(Sentinel sentinel) {
		return sentinelArrayList.add(sentinel);

	}

	@Override
	public int size() {
		return sentinelArrayList.size();

	}

	@Override
	public Sentinel[] getPatrol(int patrolSize) {
		for (int i = 0; i < patrolSize;i++) {
			 sentinelArrayList.remove(i);
		}
		
		return new Sentinel[patrolSize];
	}                        

	@Override
	public void patrolReturn(Sentinel[] sentinels) {
		for (Sentinel sentinel : sentinels) {
			sentinelArrayList.add(sentinel);
		}
	}

	@Override
	public boolean contains(Sentinel sentinel) {
		return sentinelArrayList.contains(sentinel);
	}
}
