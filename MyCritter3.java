package assignment4;

public class MyCritter3 extends Critter {
	
	@Override
	public String toString() { return "C"; }
	
	private static final int GENE_TOTAL = 8;
	private int[] genes3 = new int[8];
	private int dir;
	
	public MyCritter3() {
		for (int k = 0; k < 8; k += 1) {
			genes3[k] = GENE_TOTAL / 8;
		}
		dir = Critter.getRandomInt(8);
	}
	
	public boolean fight(String not_used) { return true; }

	@Override
	public void doTimeStep() {
		/* take one step forward */
		walk(dir);
		
		if (getEnergy() > 150) {
			MyCritter3 child = new MyCritter3();
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
		int roll = Critter.getRandomInt(GENE_TOTAL);
		int turn = 0;
		while (genes3[turn] <= roll) {
			roll = roll - genes3[turn];
			turn = turn + 1;
		}
		assert(turn < 8);
		
		dir = (dir + turn) % 8;
	}

	public static void runStats(java.util.List<Critter> MyCritter3s) {
		int total_straight = 0;
		int total_left = 0;
		int total_right = 0;
		int total_back = 0;
		for (Object obj : MyCritter3s) {
			MyCritter3 c = (MyCritter3) obj;
			total_straight += c.genes3[0];
			total_right += c.genes3[1] + c.genes3[2] + c.genes3[3];
			total_back += c.genes3[4];
			total_left += c.genes3[5] + c.genes3[6] + c.genes3[7];
		}
		System.out.print("" + MyCritter3s.size() + " total MyCritter3s    ");
		System.out.print("" + total_straight / (GENE_TOTAL * 0.01 * MyCritter3s.size()) + "% straight   ");
		System.out.print("" + total_back / (GENE_TOTAL * 0.01 * MyCritter3s.size()) + "% back   ");
		System.out.print("" + total_right / (GENE_TOTAL * 0.01 * MyCritter3s.size()) + "% right   ");
		System.out.print("" + total_left / (GENE_TOTAL * 0.01 * MyCritter3s.size()) + "% left   ");
		System.out.println();
	}
}


