package assignment4;
//Bunny rabbit
public class MyCritter5 extends Critter {
	@Override
	public String toString() { return "5"; }
	
	private static final int GENE_TOTAL = 16;
	private int[] genes5 = new int[8];
	private int dir;
	
	public MyCritter5() {
		for (int k = 0; k < 8; k += 1) {
			genes5[k] =GENE_TOTAL / 8;
		}
		dir = Critter.getRandomInt(8);
	}
	
	
	public boolean fight(String opponent) {
		return true;
	 		
}

	@Override
	public void doTimeStep() {
			MyCritter5 child = new MyCritter5();
			reproduce(child, Critter.getRandomInt(8));
		
		
		dir+=1;
		if( dir==8) dir=0;
	}

	public static void runStats(java.util.List<Critter> MyCritter5s) {
		int total_straight = 0;
		int total_left = 0;
		int total_right = 0;
		int total_back = 0;
		for (Object obj : MyCritter5s) {
			MyCritter5 c = (MyCritter5) obj;
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
