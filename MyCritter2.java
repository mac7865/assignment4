package assignment4;
/* CRITTERS MyCritter2.java
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

/*
 * This Critter is good for testing running away while fighting, and for testing 
 * movement in different directions.
 */
public class MyCritter2 extends Critter {
	
	private int myDir = 0;
	
	@Override
	public void doTimeStep () {
		walk(myDir);
		myDir = (myDir+1)%8; // change direction each walk call, CCW.
	}
	
	@Override
	/**
	 * Never fights, but always tries to run away.
	 */
	public boolean fight(String opp) {
		run(myDir);
		return false;
	}
	
	public String toString() {
		return "2";
	}

}
	
	

	