package threads;
public class Consumer implements Runnable {
	
   private final CustomQueue taskQueue;
 
   public Consumer(CustomQueue sharedQueue) {
      this.taskQueue = sharedQueue;
   }
 
   @Override
   public void run() {
	   
      while (true) {
    	  
         try {
            consume();
         } catch (InterruptedException ex) {
            ex.printStackTrace();
         }
         
      }
      
   }
 
   private void consume() throws InterruptedException {
	   
      synchronized (taskQueue) {
    	  
         while (taskQueue.isEmpty()) {
        	 
            System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.getSize());
            taskQueue.wait();
         }
         
         Thread.sleep(1000);
         int i = (Integer) taskQueue.remove();
         System.out.println("Consumed: " + i);
         taskQueue.notifyAll();
         
      }
   }
}