package assignment4;
//Bunny rabbit
public class MyCritter5 extends Critter {
	@Override
	public String toString() { return "5"; }
	
	private int lastDir = 0;
	
	@Override
	public void doTimeStep() {
		// TODO Auto-generated method stub
		int direction = (lastDir + 1) % 8;
		walk(direction);
		lastDir = direction;
		//Critter will run when possible in a swirling motion
		
		//It will also try to reproduce as much as possible
		if(getEnergy() > Params.min_reproduce_energy) {
			MyCritter5 child = new MyCritter5();
			reproduce(child, lastDir);
		}
	}
	
	
	public boolean fight(String opponent) {
		return true;
	 		
	}


	public static void runStats(java.util.List<Critter> MyCritter5s) {
		System.out.print("" + MyCritter5s.size() + " total MyCritter5s    ");
	}
}
