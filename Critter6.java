package assignment4;
/* CRITTERS Critter6.java
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

// MONSTER THAT JUST FIGHTS 
//Moves in cirles 
public class Critter6 extends Critter {
	@Override
	public String toString() { return "6"; }

	private int dir;
	private int pos;
	
	public Critter6() {
		dir = Critter.getRandomInt(8);
		pos=0;
	}
	
	public boolean fight(String opponent) {
		if (getEnergy() > 0 ) 
			return true;
		
		return false;
	 		
}

	@Override
	public void doTimeStep() {
		/* take one step forward */
		walk(dir);
		
		if(pos==5) dir+=1;
		if( dir==8) dir=0;
		pos++;
	}

	public static void runStats(java.util.List<Critter> MyCritter6s) {
		System.out.print("" + MyCritter6s.size() + " total MyCritter6s    ");
	}
}
