package assignment4;
/* CRITTERS Critter1.java
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
import java.util.*;

public class Critter1 extends Critter {

	@Override
	public void doTimeStep() {
		walk(0);
	}
	public int getValue(String opponent) {
		return 3;
	}
	
	@Override
	public boolean fight(String opponent) {
		if (getEnergy() > 10) return true;
		return false;
	}
	
	public String toString() {
		return "1";
	}
	
	//public void test (List<Critter> l) {
		
	//}
}