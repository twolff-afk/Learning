package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket serverSocket;

    public void start(int port) {
        try {
			serverSocket = new ServerSocket(port);
			
			while (true) {
				System.out.println("Wait for new Client");
				new EchoClientHandler(serverSocket.accept()).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
    
    private static class EchoClientHandler extends Thread {
    	
        private Socket clientSocket;
        private PrintWriter outputStream;
        private BufferedReader bufferedReader;

        public EchoClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void start() {
            try {
            	
            	System.out.println("New Client connected");
            	
    	        outputStream = new PrintWriter(clientSocket.getOutputStream(), true);
    	        bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    	        
    	        String inputLine = bufferedReader.readLine();
    	        boolean readLines = true;
    	        while (readLines) {
    	        	
    	        	if(inputLine != null) {
    	        		outputStream.println(inputLine);
    	        	}
    	        	
    	        	
    		        if (".".equals(inputLine)) {
    		        	outputStream.println("good bye");
    		            readLines = false;
    		        }
    	        }
                
    	        bufferedReader.close();
    			outputStream.close();
    	        clientSocket.close();
                
            } catch (IOException e) {
    			e.printStackTrace();
    		}
        }
    
    }

    public void stop() {
    	
        try {
        	
        	System.out.println("Stop Streams");
        	
	        serverSocket.close();
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }	
	
}
