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

<<<<<<< HEAD
package assignment4;
/* Critter5 represents a Rabbit
 * Reproduces as long as it has the energy too
 * Does not fight
 * Moves in a square formation
 */

/*Class name Critter5 */
public class Critter5 extends Critter {
=======
/**
 * Bunny rabbit
 */

public class Critter5 extends Critter {
	@Override
	public String toString() { return "5"; }
>>>>>>> f7fe3fc5e17f57cbc18a821950f06b5bd815f87b
	
	
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
		int total_straight = 0;
		int total_left = 0;
		int total_right = 0;
		int total_back = 0;
		for (Object obj : MyCritter5s) {
			Critter5 c = (Critter5) obj;
			total_straight += c.genes5[0];
			total_right += c.genes5[1] + c.genes5[2] + c.genes5[3];
			total_back += c.genes5[4];
			total_left += c.genes5[5] + c.genes5[6] + c.genes5[7];
		}
		System.out.print("" + MyCritter5s.size() + " total MyCritter5s    ");
		System.out.print("" + total_straight / (GENE_TOTAL * 0.01 * MyCritter5s.size()) + "% straight   ");
		System.out.print("" + total_back / (GENE_TOTAL * 0.01 * MyCritter5s.size()) + "% back   ");
		System.out.print("" + total_right / (GENE_TOTAL * 0.01 * MyCritter5s.size()) + "% right   ");
		System.out.print("" + total_left / (GENE_TOTAL * 0.01 * MyCritter5s.size()) + "% left   ");
		System.out.println();
	}
}
