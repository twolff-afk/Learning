package threadPool;

import logger.Logger;

public class ServiceExecutor implements Runnable {
	
	private String nameOfThread;
	private Logger logger;
	private int waitAtJoin;
	private boolean isDone;
	
	public ServiceExecutor(String nameOfThread, int waitAtJoin) {
		
		this.logger = Logger.getInstance();
		this.nameOfThread = nameOfThread;
		this.waitAtJoin = waitAtJoin;
		isDone = false;
		
	}
	
	public boolean isDone() {
		return isDone;
	}
	
	public String getNameOfThread() {
		return this.nameOfThread;
	}
	
	public void run() {
        
		synchronized (this) {
			
			try {
	            for (int i = 0; i < 3; i++) {
	                System.out.println(nameOfThread + ": " + i);
	                Thread.sleep(1000);
	                
	                if (waitAtJoin == 2) {
	                	
	                	logger.info(ServiceExecutor.class.getName(), new Exception(), "Thread: " + nameOfThread + " has to wait");
	                	
	                	wait();
					}
	                
	            }
	        } catch (InterruptedException interruptedException) {
	        	logger.error(ServiceExecutor.class.getName(), interruptedException, nameOfThread + " interrupted.");
	        }
			logger.info(ServiceExecutor.class.getName(), new Exception(), nameOfThread + " exiting.");
        	
        }
    }	
	
}
