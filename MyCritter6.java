package assignment4;
// MONSTER THAT JUST FIGHTS 
//Moves in cirles 
public class MyCritter6 extends Critter {
	@Override
	public String toString() { return "6"; }

	private int dir;
	private int pos;
	
	public MyCritter6() {
		dir = Critter.getRandomInt(8);
		pos=0;
	}
	
	public boolean fight(String opponent) {
		if (getEnergy() > 0 ) 
			return true;
		
		return false;
	 		
}

	@Override
	public void doTimeStep() {
		/* take one step forward */
		walk(dir);
		
		if(pos==5) dir+=1;
		if( dir==8) dir=0;
		pos++;
	}

	public static void runStats(java.util.List<Critter> MyCritter6s) {
		System.out.print("" + MyCritter6s.size() + " total MyCritter6s    ");
	}
}
