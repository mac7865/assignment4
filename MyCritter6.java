package assignment4;

import assignment4.Critter.TestCritter;

public class MyCritter6 extends TestCritter {
	
	boolean willFight;

	@Override
	public void doTimeStep() {
		// TODO Auto-generated method stub
		run(2);
	}

	@Override
	public boolean fight(String opponent) {

		if (opponent.equals("@") || opponent.equals("2") || opponent.equals("1"))
			return true;
		willFight = getRandomInt(1) == 1;
		return willFight;
	}

	@Override
	public String toString () {
		return "6";
	}
}