/*
* Course: SYST44288 Operating Systems Designs & Systems Programming
* Assignment: 3
* Name: Dalton Lu & Danyal Khan
* Scope: Write a server which can take multiple incoming clients using threads
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
	public static void main(String[] args) {
		try {
			Socket server = new Socket("127.0.0.1", 1234);
			BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
			PrintWriter writer = new PrintWriter(server.getOutputStream(), true);
			BufferedReader con = new BufferedReader(new InputStreamReader(System.in));
			String str;
			str = con.readLine();
			writer.println(str);
			do {
				str = reader.readLine();
				System.out.println(str);
				str = con.readLine();
				writer.println(str);
			} while (!str.equals("."));
		} catch (IOException err) {
			System.err.println(err);
		}
	}
}
