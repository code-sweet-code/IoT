package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Networker{
	ServerSocket socket;
	MessageDealer dealer;
	
	public Networker(int port) throws IOException {
		this.socket = new ServerSocket();
		SocketAddress addr = new InetSocketAddress(port);
		socket.setReuseAddress(true);
		socket.bind(addr);
	}

	public void go() throws IOException{
		while(true){
			Socket newConn = socket.accept();
			newConn.setSoTimeout(50000);
			dealer.setConnection(newConn);
			new Thread(dealer).start();
		}
	}
	
	public void setDealer(MessageDealer dealer){
		this.dealer = dealer;
	}
}
