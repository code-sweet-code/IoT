package server;

import java.io.*;

public class Test {

	public static void main(String[] args) throws IOException {
		Networker worker = new Networker(8888);
		worker.setDealer(new LuggageMessageDealer());
		worker.go();
	}

}
