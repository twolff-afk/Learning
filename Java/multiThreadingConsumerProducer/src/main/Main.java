package main;

import threads.Producer;
import threads.Consumer;
import threads.CustomQueue;

public class Main {
	
	public static void main(String[] args) {
		
		CustomQueue queue = new CustomQueue();
		int MAX_CAPACITY = 5;
		
		Thread tProducer = new Thread(new Producer(queue, MAX_CAPACITY), "Producer");
		Thread tConsumer = new Thread(new Consumer(queue), "Consumer");
		
		tProducer.start();
		tConsumer.start();
		
	}

}
