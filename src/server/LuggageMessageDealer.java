package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class LuggageMessageDealer extends MessageDealer {

	public LuggageMessageDealer() {
		super();
	}

	@Override
	public void run() {
		if(connection == null) return;
		System.out.println("connected");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			writer.write("weight:50,price:100;weight:70,price:200");
			writer.flush();
		} catch(SocketTimeoutException e){
			System.out.println("connection timeout");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("disconnected");
			try {
				connection.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
