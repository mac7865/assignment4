/* CRITTERS Main.java
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

package assignment4;
/* Critter5 represents a Rabbit
 * Reproduces as long as it has the energy too
 * Does not fight
 * Moves in a square formation
 */

/*Class name Critter5 */
public class Critter5 extends Critter {
	
	
	/*Critter5 is represented as a 
	 * 5 on the print screen */
	@Override
	public String toString() {
		return "5";
	}

	/*Declaration of in class variables*/
	private static final int GENE_TOTAL = 16;
	private int[] genes5 = new int[8];
	private int dir;

	/* Generate random direction*/
	public Critter5() {

		for (int k = 0; k < 8; k += 1) {
			genes5[k] = GENE_TOTAL / 8;
		}
		dir = Critter.getRandomInt(8);
	}

	/*Critter runs from a fight*/
	public boolean fight(String opponent) {
		run(dir);
		return false;

	}

	/* Critter reproduces during a time - step
	 * Moves in a circular motion */
	@Override
	public void doTimeStep() {
		Critter5 child = new Critter5();
		reproduce(child, Critter.getRandomInt(8));

		dir += 1;
		if (dir == 8)
			dir = 0;
	}

	/* shows the stats of Critter6 */
	public static void runStats(java.util.List<Critter> MyCritter5s) {
		System.out.print("" + MyCritter5s.size() + " total MyCritter5s    ");
		System.out.println();
	}
}
