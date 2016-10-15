/* CRITTERS Critter.java
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Fall 2016
 */
package assignment4;

import java.util.List;

/* see the PDF for descriptions of the methods and fields in this class
 * you may add fields, methods or inner classes to Critter ONLY if you make your additions private
 * no new public, protected or default-package code or data can be added to Critter
 */


public abstract class Critter {
	private static String myPackage;
	private	static List<Critter> population = new java.util.ArrayList<Critter>();
	private static List<Critter> babies = new java.util.ArrayList<Critter>();

	// Gets the package name.  This assumes that Critter and its subclasses are all in the same package.
	static {
		myPackage = Critter.class.getPackage().toString().split(" ")[1];
	}
	
	private static java.util.Random rand = new java.util.Random();
	public static int getRandomInt(int max) {
		return rand.nextInt(max);
	}
	
	public static void setSeed(long new_seed) {
		rand = new java.util.Random(new_seed);
	}
	
	
	/* a one-character long string that visually depicts your critter in the ASCII interface */
	public String toString() { return ""; }
	
	private int energy = 0;
	protected int getEnergy() { return energy; }
	
	private int x_coord;
	private int y_coord;
	private boolean moved = false;
	
	protected final void walk(int direction) {
		this.energy -= Params.walk_energy_cost;
		if(moved){			
			//already moved, take penalty and return	
			return;
		}
		//take out energy
		//set flag to true so it cant move twice
		moved = true;
		this.energy -= Params.walk_energy_cost;
		//walk 1 tile in the specified direction
		if(direction == 0) {
			//right
			this.x_coord += 1;
			if(this.x_coord > Params.world_width) {
				this.x_coord -= Params.world_width;
			}
		}
		if(direction == 1) {
			//up-right
			this.x_coord += 1;
			this.y_coord -= 1;
			if(this.x_coord > Params.world_width) {
				this.x_coord -= Params.world_width;
			}
			if(this.y_coord < 0) {
				this.y_coord += Params.world_height;
			}
		}
		if(direction == 2) {
			//up
			this.y_coord -= 1; 
			if(this.y_coord < Params.world_height) {
				this.y_coord += Params.world_height;
			}
		}
		if(direction == 3) {
			//up-left
			this.x_coord -= 1;
			this.y_coord -= 1;
			if(this.x_coord < 0) {
				this.x_coord += Params.world_width;
			}
			if(this.y_coord < 0) {
				this.y_coord += Params.world_height;
			}
		}
		if(direction == 4) {
			//left
			this.x_coord -= 1; 
			if(this.x_coord < 0) {
				this.x_coord += Params.world_width;
			}
		}
		if(direction == 5) {
			//down-left
			this.x_coord -= 1; 
			this.y_coord += 1;
			if(this.x_coord < 0) {
				this.x_coord += Params.world_width;
			}
			if(this.y_coord > Params.world_height) {
				this.y_coord -= Params.world_height;
			}
		}
		if(direction == 6) {
			//down
			this.y_coord += 1;
			if(this.y_coord > Params.world_height) {
				this.y_coord -= Params.world_height;
			}
		}
		if(direction == 7) {
			//donw-right
			this.x_coord += 1;
			this.y_coord += 1;
			if(this.x_coord > Params.world_width) {
				this.x_coord -= Params.world_width;
			}
			if(this.y_coord > Params.world_height) {
				this.y_coord -= Params.world_height;
			}
		}
	}
	
	protected final void run(int direction) {
		//run 2 tiles, straight lines only
		//if they go past the board limits, set them to other side of board
		this.energy -= Params.run_energy_cost;
		if(moved) {
			return;
		}
		moved = true;
		this.energy -= Params.run_energy_cost;
		if(direction == 0) {
			//right
			this.x_coord += 1;
			if(this.x_coord > Params.world_width) {
				this.x_coord -= Params.world_width;
			}
		}
		if(direction == 2) {
			//up
			this.y_coord -= 2; 
			if(this.y_coord < Params.world_height) {
				this.y_coord += Params.world_height;
			}
		}
		if(direction == 4) {
			//left
			this.x_coord -= 2; 
			if(this.x_coord < Params.world_width) {
				this.x_coord += Params.world_width;
			}
		}
		if(direction == 6) {
			//down
			this.y_coord += 2;
			if(this.y_coord > Params.world_height) {
				this.y_coord -= Params.world_height;
			}
		}
	}
	
	protected final void reproduce(Critter offspring, int direction) {
		//make sure it has enough energy
		if(this.energy < Params.min_reproduce_energy)
			return;
		int childEnergy = this.energy / 2;
		if(this.energy % 2 == 0) {
			this.energy = childEnergy;
			offspring.energy = childEnergy;
		}
		else{
			//if energy is odd need to round up parents new energy
			this.energy = childEnergy+1;
			offspring.energy = childEnergy;
		}
		offspring.x_coord = this.x_coord;
		offspring.y_coord = this.y_coord;
		//moving to right square, adding energy back because not actually walking
		offspring.walk(direction);
		offspring.energy += Params.walk_energy_cost;
		babies.add(offspring);
	}

	public abstract void doTimeStep();
	public abstract boolean fight(String oponent);
	
	/**
	 * create and initialize a Critter subclass.
	 * critter_class_name must be the unqualified name of a concrete subclass of Critter, if not,
	 * an InvalidCritterException must be thrown.
	 * (Java weirdness: Exception throwing does not work properly if the parameter has lower-case instead of
	 * upper. For example, if craig is supplied instead of Craig, an error is thrown instead of
	 * an Exception.)
	 * @param critter_class_name
	 * @throws InvalidCritterException
	 */
	public static void makeCritter(String critter_class_name) throws InvalidCritterException {
		try {
			Class<?> cl = Class.forName("assignment4."+critter_class_name);
			Object crt = cl.newInstance();
			Critter crit = (Critter) crt;
			crit.energy = Params.start_energy;
			crit.x_coord = getRandomInt(Params.world_width-1);
			crit.y_coord = getRandomInt(Params.world_height-1);
			population.add(crit);
		}
		catch(Exception e) {
			throw new InvalidCritterException(critter_class_name);
		}
		
	}
	
	/**
	 * Gets a list of critters of a specific type.
	 * @param critter_class_name What kind of Critter is to be listed.  Unqualified class name.
	 * @return List of Critters.
	 * @throws InvalidCritterException
	 */
	public static List<Critter> getInstances(String critter_class_name) throws InvalidCritterException {
		List<Critter> result = new java.util.ArrayList<Critter>();
	
		return result;
	}
	
	/**
	 * Prints out how many Critters of each type there are on the board.
	 * @param critters List of Critters.
	 */
	public static void runStats(List<Critter> critters) {
		System.out.print("" + critters.size() + " critters as follows -- ");
		java.util.Map<String, Integer> critter_count = new java.util.HashMap<String, Integer>();
		for (Critter crit : critters) {
			String crit_string = crit.toString();
			Integer old_count = critter_count.get(crit_string);
			if (old_count == null) {
				critter_count.put(crit_string,  1);
			} else {
				critter_count.put(crit_string, old_count.intValue() + 1);
			}
		}
		String prefix = "";
		for (String s : critter_count.keySet()) {
			System.out.print(prefix + s + ":" + critter_count.get(s));
			prefix = ", ";
		}
		System.out.println();		
	}
	
	/* the TestCritter class allows some critters to "cheat". If you want to 
	 * create tests of your Critter model, you can create subclasses of this class
	 * and then use the setter functions contained here. 
	 * 
	 * NOTE: you must make sure that the setter functions work with your implementation
	 * of Critter. That means, if you're recording the positions of your critters
	 * using some sort of external grid or some other data structure in addition
	 * to the x_coord and y_coord functions, then you MUST update these setter functions
	 * so that they correctly update your grid/data structure.
	 */
	static abstract class TestCritter extends Critter {
		protected void setEnergy(int new_energy_value) {
			super.energy = new_energy_value;
		}
		
		protected void setX_coord(int new_x_coord) {
			super.x_coord = new_x_coord;
		}
		
		protected void setY_coord(int new_y_coord) {
			super.y_coord = new_y_coord;
		}
		
		protected int getX_coord() {
			return super.x_coord;
		}
		
		protected int getY_coord() {
			return super.y_coord;
		}
		

		/*
		 * This method getPopulation has to be modified by you if you are not using the population
		 * ArrayList that has been provided in the starter code.  In any case, it has to be
		 * implemented for grading tests to work.
		 */
		protected static List<Critter> getPopulation() {
			return population;
		}
		
		/*
		 * This method getBabies has to be modified by you if you are not using the babies
		 * ArrayList that has been provided in the starter code.  In any case, it has to be
		 * implemented for grading tests to work.  Babies should be added to the general population 
		 * at either the beginning OR the end of every timestep.
		 */
		protected static List<Critter> getBabies() {
			return babies;
		}
	}

	/**
	 * Clear the world of all critters, dead and alive
	 */
	public static void clearWorld() {
		//clear board
		for(Critter crit: population) {
			population.remove(crit);
		}
		for(Critter crit: babies) {
			babies.remove(crit);
		}
	}
	
	public static void worldTimeStep() {
	}
	
	public static void displayWorld() {
		String board[][] = new String[Params.world_width][Params.world_height];
		//corners should be +'s
		board[0][0] = "+";
		board[0][Params.world_height-1] = "+";
		board[Params.world_width-1][0] = "+";
		board[Params.world_width-1][Params.world_height-1] = "+";
		//making border of board
		for(int i = 1; i < Params.world_width-1; i++) {
			board[i][0] = "-";
		}
		for(int i = 1; i < Params.world_width-1; i++) {
			board[i][Params.world_height-1] = "-";
		}
		for(int i = 1; i < Params.world_height-1; i++) {
			board[0][i] = "|";
		}
		for(int i = 1; i < Params.world_height-1; i++) {
			board[Params.world_width-1][i] = "|";
		}
		for(Critter crit: population) {
			board[crit.x_coord][crit.y_coord] = crit.toString();
			//reset moved flags for next turn
			crit.moved = false;
		}
		for(int i = 0; i < Params.world_height; i++) {
			for(int j = 0; j < Params.world_width; j++) {
				//traverse horizontal across rows printing out board
				if(board[j][i] == null) {
					System.out.print(" ");
				}
				else{
					System.out.print(board[j][i]);
				}
			}
			//go to next row
			System.out.println();			
		}
			
	}
}