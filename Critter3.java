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
//Moves Diagonally 

//ageing Critter

public class Critter3 extends Critter {

	@Override
	public String toString() {
		return "3";
	}

	private static final int GENE_TOTAL = 8;
	private int[] genes3 = new int[8];
	private int dir;
	private boolean flag = false;
	private int age = 0;

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

	public boolean fight(String opponent) {
			if (age > 2 && age <= 12)
			return true;

			else{		
		walk(dir);
		return false;
			}
	}

	@Override
	public void doTimeStep() {

		if (age > 5 && age <= 9) {
			run(dir);
		}

		if (getEnergy() > 150 && (age > 9 && age < 13)) {
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
		} else {
			walk(dir);
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
		age++;
	}

	public static void runStats(java.util.List<Critter> MyCritter3s) {
		System.out.print("" + MyCritter3s.size() + " total MyCritter3s    ");
		System.out.println();
	}
}
