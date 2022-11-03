package threadPool;

import java.util.HashMap;

import logger.Logger;

public class ThreadManagingList implements Runnable {
	
	private HashMap<String, ServiceExecutor> mapOfThreads = new HashMap<>();
	private boolean stopThread;
	private Logger logger;
	
	private ThreadManagingList() {
		
		this.stopThread = false;
		this.logger = Logger.getInstance();
	
	}
	
	public void run() {
		
		while (!stopThread) {
			
			try {
	            for (int i = 0; i < 3; i++) {
	                Thread.sleep(1000);
	            }
	        } catch (InterruptedException interruptedException) {
	        	logger.error(ServiceExecutor.class.getName(), interruptedException, "Thread interrupted.");
	        }
			
		}
		
	}
	
	public synchronized boolean addThreadToList(ServiceExecutor thread) {
		
		boolean result = false;
		
		mapOfThreads.put(thread.getNameOfThread(), thread);		
		
		return result;
		
	}
}
