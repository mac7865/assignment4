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
/*Critter6 represents a
 * Monster which only fights
 * It does not reproduce,  all male species 
 * Moves in a circular pattern 
*/

/*Class name Critter6 */
public class Critter6 extends Critter {
	
	/*Critter6 is represented as a 
	 * 6 on the print screen */
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
		if( dir >= 8) dir=0;
		pos++;
	}

	/* shows the stats of Critter6 */
	
	public static void runStats(java.util.List<Critter> MyCritter6s) {
		System.out.print("" + MyCritter6s.size() + " total MyCritter6s    ");
		System.out.println();
	}
}
