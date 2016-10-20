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
package assignment4; // cannot be in default package
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Method;


/*
 * Usage: java <pkgname>.Main <input file> test
 * input file is optional.  If input file is specified, the word 'test' is optional.
 * May not use 'test' argument without specifying input file.
 */
public class Main {

    static Scanner kb;	// scanner connected to keyboard input, or input file
    private static String inputFile;	// input file, used instead of keyboard input if specified
    static ByteArrayOutputStream testOutputString;	// if test specified, holds all console output
    private static String myPackage;	// package of Critter file.  Critter cannot be in default pkg.
    private static boolean DEBUG = false; // Use it or not, as you wish!
    static PrintStream old = System.out;	// if you want to restore output to console


    // Gets the package name.  The usage assumes that Critter and its subclasses are all in the same package.
    static {
        myPackage = Critter.class.getPackage().toString().split(" ")[1];
    }

    /**
     * Main method.
     * @param args args can be empty.  If not empty, provide two parameters -- the first is a file name, 
     * and the second is test (for test output, where all output to be directed to a String), or nothing.
     */
    public static void main(String[] args) { 
        if (args.length != 0) {
            try {
                inputFile = args[0];
                kb = new Scanner(new File(inputFile));			
            } catch (FileNotFoundException e) {
                System.out.println("USAGE: java Main OR java Main <input file> <test output>");
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("USAGE: java Main OR java Main <input file>  <test output>");
            }
            if (args.length >= 2) {
                if (args[1].equals("test")) { // if the word "test" is the second argument to java
                    // Create a stream to hold the output
                    testOutputString = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(testOutputString);
                    // Save the old System.out.
                    old = System.out;
                    // Tell Java to use the special stream; all console output will be redirected here from now
                    System.setOut(ps);
                }
            }
        } else { // if no arguments to main
            kb = new Scanner(System.in); // use keyboard and console
        }
        
        /* Do not alter the code above for your submission. */
        /* Write your code below. */
        
        System.out.println("GLHF");
        //setup world of arraylists to keep track of critters
        Critter.setUpWorld();
        while(true) {
        	System.out.print("critters>");
        	String fullCommand = kb.nextLine();
        	String[] command = fullCommand.split("\\s+");
        	boolean invalid = false;
        	if(command[0].equals(""))
        		invalid = true;
        	else {
	        	if (command[0].equals("quit")) {
	        		if(command.length == 1)
	        			break;
	        		else
	        			invalid = true;
	        	}
	        	else if (command[0].equals("show")) {
	        		if(command.length == 1)
	        			Critter.displayWorld();
	        		else
	        			invalid = true;
	        	}
	        	else if (command[0].equals("step")) {
	        		if(command.length > 2) //invalid step command
	        			invalid = true;
	        		else{
	        			try{
	        				if(command.length > 1) {
			        			int steps = Integer.parseInt(command[1]);
				        		for(int i = 0; i < steps; i++){
				        			Critter.worldTimeStep();
				        		}
			        		}
	        				else
			        			Critter.worldTimeStep();
		        		}
	        			catch(Exception e) {
	        				System.out.println("error processing: " + fullCommand);
	        			}
	        		}
	        	}
	        	else if(command[0].equals("seed")) {
	        		if(command.length != 2) {
	        			invalid = true;
	        		}
	        		else {
	        			try{
	        				long seed = Long.parseLong(command[1]);
	        				Critter.setSeed(seed);
	        			}
	        			catch(Exception e) {
	        				System.out.println("error processing: " + fullCommand);
	        			}
	        		}
	        	}        	
	        	else if(command[0].equals("make")) {
	        		int count = 1;
	        		if(command.length > 3 || command.length == 1)
	        			invalid = true;
	        		else{
		        		if(command.length > 2) {
		        			count = Integer.parseInt(command[2]);
		        		}
		        		for(int x = 0; x < count; x++) {
		        			try {
		        				Critter.makeCritter(command[1]);;
		        			}
		        			catch(Exception e) {
		        				System.out.println("error processing: " + fullCommand);
		        				break;
		        			}
		        		}
	        		}
	        	}
	        	else if(command[0].equals("stats")) {
	        		if(command.length != 2)
	        			invalid = true;
	        		else {
	        			try{
	        				Class<?> cl = Class.forName("assignment4."+command[1]);
	        				Class<?>[] types = {List.class};
	        				Method m = cl.getMethod("runStats", types);
	        				m.invoke(null, Critter.getInstances(command[1]));
	        			}
	        			catch(Exception e) {
	        				System.out.println("error processing: " + fullCommand);
	        			}
	        		}
	        	}
	        	else{
	        		System.out.println("invalid command: " + fullCommand);
	        	}
        	}
        	if(invalid) {
        		System.out.println("invalid command: " + fullCommand);
        	}
        }
        
        /* Write your code above */
        System.out.flush();

    }
}
