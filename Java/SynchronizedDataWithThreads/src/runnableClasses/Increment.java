package runnableClasses;

import sharedData.Counter;

public class Increment extends Thread {
	
	private Counter counter;
	
	public Increment(Counter counter) {
		this.counter = counter;
	}
	
	public void run() {

        for (int i = 0; i < 5; i++) {
        	counter.incrementCounter();
        }
	    
	}
	
}
