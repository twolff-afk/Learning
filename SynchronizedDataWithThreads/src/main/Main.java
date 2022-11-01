package main;

import runnableClasses.Decrement;
import runnableClasses.Increment;
import sharedData.Counter;

/**
 * This application is my first attempt to use synchronized an shared data.
 * Here we have a class named counter with one counter variable
 * and two runnable classes increment and decrement which share the counter instance (shared data).
 * The two threads are still competing, but the shared data is not corrupted anymore.
 * 
 * Remove the keyword synchronized in counter class at the methods increment and decrement and the you won't get the zero as a final result
 * 
 * @author Tobias
 *
 */

public class Main {

	public static void main(String[] args) {
		
		Counter counter = new Counter(0);
		
		Increment increment = new Increment(counter);
		Decrement decrement = new Decrement(counter);
		
		increment.start();
		decrement.start();
		
		
		try {
	      
			Thread.sleep(10000);

	    } catch (InterruptedException interruptedException) {
	    	
	    }
		
		System.out.println("Counter is " + Integer.toString(counter.getCounter()));
		
	}

}
