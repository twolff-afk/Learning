package sharedData;

import java.util.LinkedList;

public class ThreadIntercommunication {
	
	private LinkedList<String> communication;
	private boolean waiting = true;
	
	public ThreadIntercommunication() {
		this.communication = new LinkedList<String>();
	}
	
	public synchronized void addItemToList(String item) {
		
		System.out.println("Add item to list: " + item);
		
		if (!communication.isEmpty()) {
			waiting = false;
		}
		
		this.communication.add(item);
		
		while (waiting) {
            try { 
                wait();
            } catch (InterruptedException interruptedException)  {
                Thread.currentThread().interrupt();
                interruptedException.printStackTrace();
            }
        }
        
        System.out.println("Notify all");
        notifyAll();
        
	}
	
}
