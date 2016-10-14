package assignment4;

public class MyCritter4 extends Critter {
	@Override
	public String toString() { return "C"; }
	
	private static final int GENE_TOTAL = 16;
	private int[] genes4 = new int[8];
	private int dir;
	
	public MyCritter4() {
		for (int k = 0; k < 8; k += 1) {
			genes4[k] = GENE_TOTAL / 8;
		}
		dir = Critter.getRandomInt(8);
	}
	
	public boolean fight(String not_used) {
		if (getEnergy() > 50) { 
		return true; }
		return false;
}

	@Override
	public void doTimeStep() {
		/* take one step forward */
		walk(dir);
		
		if (getEnergy() > 150) {
			MyCritter4 child = new MyCritter4();
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
		
		/* pick a new direction based on our genes4 */
		int roll = Critter.getRandomInt(GENE_TOTAL);
		int turn = 0;
		while (genes4[turn] <= roll) {
			roll = roll - genes4[turn];
			turn = turn + 1;
		}
		assert(turn < 8);
		
		dir = (dir + turn) % 8;
	}

	public static void runStats(java.util.List<Critter> MyCritter4s) {
		int total_straight = 0;
		int total_left = 0;
		int total_right = 0;
		int total_back = 0;
		for (Object obj : MyCritter4s) {
			MyCritter4 c = (MyCritter4) obj;
			total_straight += c.genes4[0];
			total_right += c.genes4[1] + c.genes4[2] + c.genes4[3];
			total_back += c.genes4[4];
			total_left += c.genes4[5] + c.genes4[6] + c.genes4[7];
		}
		System.out.print("" + MyCritter4s.size() + " total MyCritter4s    ");
		System.out.print("" + total_straight / (GENE_TOTAL * 0.01 * MyCritter4s.size()) + "% straight   ");
		System.out.print("" + total_back / (GENE_TOTAL * 0.01 * MyCritter4s.size()) + "% back   ");
		System.out.print("" + total_right / (GENE_TOTAL * 0.01 * MyCritter4s.size()) + "% right   ");
		System.out.print("" + total_left / (GENE_TOTAL * 0.01 * MyCritter4s.size()) + "% left   ");
		System.out.println();
	}
}


