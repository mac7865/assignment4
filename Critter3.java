package assignment4;
/* CRITTERS Critter3.java
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
* Moves Diagonally 
* value 3 
*/

public class Critter3 extends Critter {

	@Override
	public String toString() {
		return "3";
	}

	private static final int GENE_TOTAL = 8;
	private int[] genes3 = new int[8];
	private int dir;
	private boolean flag = false;

	public Critter3() {
		for (int k = 0; k < 8; k += 1) {
			genes3[k] = GENE_TOTAL / 8;
		}
		dir = Critter.getRandomInt(8);
		if (dir % 2 == 0 || dir == 0) {
			flag = true;
		} else {
			flag = false;
		}

		while (flag == false) {
			dir = Critter.getRandomInt(8);
			if (dir % 2 != 0) {
				flag = true;
			}
		}

	}

	public int getValue(String opponent) {
		return 3;
	}

	public boolean fight(String opponent) {
		if (getEnergy() > 25 && getValue(this.toString()) > getValue(opponent))
			return true;

		return false;

	}

	@Override
	/**
	 * This Critter will reproduce if it has a lot of energy( > 150)
     */
	public void doTimeStep() {
		/* take one step forward */
		walk(dir);

		if (getEnergy() > 150) {
			Critter3 child = new Critter3();
			for (int k = 0; k < 8; k += 1) {
				child.genes3[k] = this.genes3[k];
			}
			int g = Critter.getRandomInt(8);
			while (child.genes3[g] == 0) {
				g = Critter.getRandomInt(8);
			}
			child.genes3[g] -= 1;
			g = Critter.getRandomInt(8);
			child.genes3[g] += 1;
			reproduce(child, Critter.getRandomInt(8));
		}

		/* pick a new direction based on our genes3 */
		flag = false;
		while (flag == false) {
			int roll = Critter.getRandomInt(GENE_TOTAL);
			int turn = 0;
			while (genes3[turn] <= roll) {
				roll = roll - genes3[turn];
				turn = turn + 1;
			}
			assert(turn < 8);
			dir = (dir + turn) % 8;
			if (dir % 2 != 0) {
				flag = true;
			}
		}

	}

	public static void runStats(java.util.List<Critter> MyCritter3s) {
		System.out.print("" + MyCritter3s.size() + " total MyCritter3s    ");
		System.out.println();
	}
}
