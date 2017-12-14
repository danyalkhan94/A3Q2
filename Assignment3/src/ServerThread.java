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

public class ServerThread extends Thread {
	Socket socket;
	ServerThread(Socket socket){
	this.socket = socket;
	}
	public void run() {
		try {
			String str;
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			do
			{
				str = in.readLine();
				if ( str != null )
					out.println("Server: "+ str);
			}
			while (!str.equals("."));
			socket.close();				
		} catch (IOException err) {
			System.err.println(err);
		}
	}
}
