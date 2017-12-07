package server;

import java.net.Socket;

public abstract class MessageDealer implements Runnable {
	protected Socket connection;

	public MessageDealer() {
		
	}

	public void setConnection(Socket socket){
		connection = socket;
	}
}
