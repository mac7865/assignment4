package assignment4;
// Moves in square formation 
//reproduces 
public class MyCritter4 extends Critter.TestCritter {
	@Override
	public String toString() { return "4"; }
	
	private static final int GENE_TOTAL = 16;
	private int[] genes4 = new int[8];
	private int dir;
	private int pos;
	
	public MyCritter4() {
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
		
		if(pos==5) dir+=2;
		if( dir==8) dir=0;
		pos++;
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
