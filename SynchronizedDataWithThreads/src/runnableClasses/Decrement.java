package runnableClasses;

import sharedData.Counter;

public class Decrement extends Thread {
	
	private Counter counter;
	
	public Decrement(Counter counter) {
		this.counter = counter;
	}
	
	public void run() {
	
        for (int i = 0; i < 5; i++) {
        	counter.decrementCounter();
        }

	}
	
}
