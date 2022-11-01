package threads;

import java.util.ArrayList;
import java.util.List;

public class CustomQueue {
	
	private List<Integer> sharedQueue;
	
	public CustomQueue() {
		this.sharedQueue = new ArrayList<Integer>();
	}
	
	public synchronized boolean isEmpty() {
		return sharedQueue.isEmpty();
	}
	
	public synchronized void add(int number) {
		sharedQueue.add(number);
	}
	
	public synchronized int getSize() {
		return sharedQueue.size();
	}
	
	public synchronized int remove() {
		return sharedQueue.remove(0);
	}
	
}
