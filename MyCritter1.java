package assignment4;

import java.util.*;

public class MyCritter1 extends Critter.TestCritter {

	@Override
	public void doTimeStep() {
		walk(0);
	}
	public int getValue(String opponent) {
		return 3;
	}
	
	@Override
	public boolean fight(String opponent) {
		if (getEnergy() > 10 && getValue("THIS CRITTER IDENTITY") > getValue(opponent) ) return true;
		return false;
	}
	
	public String toString() {
		return "1";
	}
	
	public void test (List<Critter> l) {
		
	}
}