package threads;

public class Producer implements Runnable {
	
   private final CustomQueue taskQueue;
   private final int MAX_CAPACITY;
 
   public Producer(CustomQueue sharedQueue, int size) {
	   
      this.taskQueue = sharedQueue;
      this.MAX_CAPACITY = size;
      
   }
 
   @Override
   public void run() {
	   
      int counter = 0;
      while (true) {
    	  
         try {
            produce(counter++);
         } 
         catch (InterruptedException ex) {
            ex.printStackTrace();
         }
         
      }
      
   }
   
   private void produce(int i) throws InterruptedException {
	   
      synchronized (taskQueue) {
    	  
         while (taskQueue.getSize() == MAX_CAPACITY) {
        	 
            System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.getSize());
            taskQueue.wait();
         }
           
         Thread.sleep(1000);
         taskQueue.add(i);
         System.out.println("Produced: " + i);
         taskQueue.notifyAll();
         
      }
   }
}
