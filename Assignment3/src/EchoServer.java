
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) {
		new EchoServer().runServer();
	}
	public void runServer() {
		try {
			ServerSocket server = new ServerSocket(1234);
			while (true) {
				Socket client = server.accept();
				new ServerThread(client).start();
			}
		} catch (Exception err) {
			System.err.println(err);
		}

	}

}
