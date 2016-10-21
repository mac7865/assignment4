package assignment4;
/* CRITTERS Critter4.java
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
 
 * Moves in square formation 
 * reproduces as much as possible
*/
public class Critter4 extends Critter {
	@Override
	public String toString() { return "4"; }
	
	private static final int GENE_TOTAL = 16;
	private int[] genes4 = new int[8];
	private int dir;
	private int pos;
	
	public Critter4() {
		for (int k = 0; k < 8; k += 1) {
			genes4[k] = GENE_TOTAL / 8;
		}
		dir = Critter.getRandomInt(4)*2;
		pos=0;
	}
	public int getValue(String opponent) {
		return 3;
	}
	
	
	public boolean fight(String opponent) {
		if (getEnergy() > 10 && getValue("THIS CRITTER IDENTITY") > getValue(opponent) ) 
			return true;
		
		return false;
	 		
}

	@Override
	public void doTimeStep() {
		/* take one step forward */
		walk(dir);
		if (getEnergy() > 150) {
			Critter4 child = new Critter4();
			for (int k = 0; k < 8; k += 1) {
				child.genes4[k] = this.genes4[k];
			}
			int g = Critter.getRandomInt(8);
			while (child.genes4[g] == 0) {
				g = Critter.getRandomInt(8);
			}
			child.genes4[g] -= 1;
			g = Critter.getRandomInt(8);
			child.genes4[g] += 1;
			reproduce(child, Critter.getRandomInt(8));
		}
		
		if(pos==5) dir+=2;
		if( dir==8) dir=0;
		pos++;
	}

	public static void runStats(java.util.List<Critter> MyCritter4s) {
		System.out.print("" + MyCritter4s.size() + " total MyCritter4s    ");
		System.out.println();
	}
}
