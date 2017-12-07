package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MacAddressDealer extends MessageDealer {

	public MacAddressDealer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		if(connection == null) return;
		System.out.println("connected");
		try{
			DataInputStream reader = new DataInputStream(connection.getInputStream());
			
			while(true){
				int b = reader.readUnsignedByte();
				System.out.print(Integer.toHexString(b)+":");
			}
		} catch(SocketTimeoutException e){
			System.out.println("connection timeout");
		} catch(EOFException e){
			System.out.println("EOF");
		}catch (IOException e) {
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
