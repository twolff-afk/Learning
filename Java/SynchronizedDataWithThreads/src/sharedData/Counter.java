package sharedData;

/**
 * Simple counter class with one variable and two methods for increment and decrement
 * @author Tobias
 *
 */
public class Counter {
	
	private int counter;
	
	public Counter(int counter) {
		this.counter = counter;
	}
	
	public int getCounter() {
		return this.counter;
	}
	
	public synchronized void incrementCounter() {
		this.counter = this.counter + 1;
		
		try {
			
			System.out.println("Increment");
			
			Thread.sleep(1000);
			
		} catch (InterruptedException interruptedException) {
	    	
	    }
		
		
		
	}
	
	public synchronized void decrementCounter() {
		this.counter = this.counter - 1;
		
		try {
			
			System.out.println("Decrement");
			
			Thread.sleep(1000);
			
		} catch (InterruptedException interruptedException) {
	    	
	    }
	}
	
}
