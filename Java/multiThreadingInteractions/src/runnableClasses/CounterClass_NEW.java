package runnableClasses;

import sharedData.CounterList_NEW;

// implements is used to implement a runnable
public class CounterClass_NEW implements Runnable {
	
	private final String threadName;
	private final int stopAt;
	private final int sleepTime;
	private CounterList_NEW list;
	
	/**
	 * @param threadName
	 * @param stopAt
	 * @param sleepTime
	 * @param list
	 */
	public CounterClass_NEW(String threadName, int stopAt, int sleepTime, CounterList_NEW list) {
		this.threadName = threadName;
		this.stopAt = stopAt;
		this.sleepTime = sleepTime;
		this.list = list;
	}
	
	public void run() {
		
		int i = 0;
		while (true) {
			
			checkEntry(i);
			
			i++;
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException interruptedException) {
				interruptedException.printStackTrace();
			}
			
		}
		
	}
	
	public void checkEntry(int i) {
		
		synchronized (list) {
		
			System.out.println(threadName + ": " + Integer.toString(i));
			
			if (i == stopAt) {
				
				if (list.checkItem(stopAt)) {
					
					System.out.println("notifyAll");
					
					list.updateItem(stopAt);
					list.notifyAll();
					
				} else {
					
					list.addItemToList(stopAt);
					try {
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			}
		
		}
		
	}
	
}
