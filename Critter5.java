package assignment4;
/* CRITTERS Critter5.java
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * Mark Carter
 * mac7865
 * 16495
 * <Sean Conlon>
 * <spc927>
 * <16455>
 * Slip days used: <0>
 * Fall 2016
 */

/**
 * Bunny rabbit
 */

public class Critter5 extends Critter {
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
			Critter5 child = new Critter5();
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
