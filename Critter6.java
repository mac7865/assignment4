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
/*Critter6 represents a
 * Monster which only fights
 * It does not reproduce,  all male species 
 * Moves in a circular pattern 
*/

/*Class name Critter6 */
public class Critter6 extends Critter {
	
	/*Critter6 is represented as a 
	 * 6 on the print screen */
=======
/**
 * MONSTER THAT JUST FIGHTS 
 * Moves in cirles 
 */
public class Critter6 extends Critter {
>>>>>>> f7fe3fc5e17f57cbc18a821950f06b5bd815f87b
	@Override
	public String toString() { return "6"; }
	
	/*Declaration of in class variables*/
	
	private static final int GENE_TOTAL = 16;
	private int[] genes6 = new int[8];
	private int dir;
	private int pos;
	
	
	/* Generate random direction*/
	
	public Critter6() {
		for (int k = 0; k < 8; k += 1) {
			genes6[k] =GENE_TOTAL / 8;
		}
		dir = Critter.getRandomInt(8);
		pos=0;
	}
	
	/*Critter fights aslong as it is not dead or not*/
	
	public boolean fight(String opponent) {
		if (getEnergy() > 0 ) 
			return true;
		
		return false;
	 		
}

	
	/* Critter runs during a time - step
	 * Moves in a circular motion */
	
	@Override
	public void doTimeStep() {
		/* take two step forward */
		run(dir);
		
		if(pos==5) dir+=1;
		if( dir==8) dir=0;
		pos++;
	}

	/* shows the stats of Critter6 */
	
	public static void runStats(java.util.List<Critter> MyCritter6s) {
		int total_straight = 0;
		int total_left = 0;
		int total_right = 0;
		int total_back = 0;
		for (Object obj : MyCritter6s) {
			Critter6 c = (Critter6) obj;
			total_straight += c.genes6[0];
			total_right += c.genes6[1] + c.genes6[2] + c.genes6[3];
			total_back += c.genes6[4];
			total_left += c.genes6[5] + c.genes6[6] + c.genes6[7];
		}
		System.out.print("" + MyCritter6s.size() + " total MyCritter6s    ");
		System.out.print("" + total_straight / (GENE_TOTAL * 0.01 * MyCritter6s.size()) + "% straight   ");
		System.out.print("" + total_back / (GENE_TOTAL * 0.01 * MyCritter6s.size()) + "% back   ");
		System.out.print("" + total_right / (GENE_TOTAL * 0.01 * MyCritter6s.size()) + "% right   ");
		System.out.print("" + total_left / (GENE_TOTAL * 0.01 * MyCritter6s.size()) + "% left   ");
		System.out.println();
	}
}
