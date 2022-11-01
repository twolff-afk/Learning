package runnableClasses;

import sharedData.ThreadIntercommunication;

public class CounterClass implements Runnable {
	
	private final String threadName;
	private final int stopAt;
	private ThreadIntercommunication threadCommunication;
	private final int sleepTime;
	
	public CounterClass(String threadName, ThreadIntercommunication threadCommunication, int stopAt, int sleepTime) {
		this.threadName = threadName;
		this.stopAt = stopAt;
		this.threadCommunication = threadCommunication;
		this.sleepTime = sleepTime;
	}
	
	public void run() {
		
		
		int i = 0;
		while (true) {
			
			System.out.println(threadName + " " + Integer.toString(i));
			
			if (i == stopAt) {
				
				threadCommunication.addItemToList(threadName);
				
			}
			
			
			i++;
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException interruptedException) {
				interruptedException.printStackTrace();
			}
			
		}
		
	}
	
	
	
}
