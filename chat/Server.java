import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	
	public static void main(String [] args ) throws Exception {
		Server server = new Server();
		server.run();
	}

	public void run () throws Exception {
		ServerSocket sersek = new ServerSocket(444);
		Socket socket = sersek.accept();
		InputStreamReader ir = new InputStreamReader(socket.getInputStream());
		BufferedReader br = new BufferedReader(ir);
		Scanner sc = new Scanner(System.in);
		do {
			String message = br.readLine();
			System.out.println(message);

			if(message != null) {
				PrintStream ps = new PrintStream(socket.getOutputStream());
				System.out.println("enter message");
				ps.println(sc.nextLine());
			}
		}while (true);
	}
}