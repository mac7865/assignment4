package assignment4;

import assignment4.Critter.TestCritter;

public class MyCritter5 extends TestCritter {
	
	boolean willFight;
	int lastDir = 0;
	
	@Override
	public void doTimeStep() {
		// TODO Auto-generated method stub
		int direction = (lastDir + 1) % 8;
		//Critter will run when possible in a swirling motion
		if(getEnergy() > Params.min_reproduce_energy) {
			//reproduce();
		}
		if(direction%2 == 0)
			run(direction);
		else
			walk(direction);
		
		
	}

	@Override
	public boolean fight(String opponent) {

		if (opponent.equals("@"))
			return true;
		willFight = getRandomInt(1) == 1;
		return willFight;
	}

	@Override
	public String toString () {
		return "5";
	}
}
