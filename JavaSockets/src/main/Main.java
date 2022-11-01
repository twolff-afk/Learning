package main;

import server.Server;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Start application");
		
		Server server = new Server();
        server.start(6666);
        server.stop();
        
        System.out.println("Stop application");
	}

}
