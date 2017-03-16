import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	public static void main(String [] args) throws Exception {
		Client client = new Client();
		client.run();
	}

	public void run () throws Exception {
		Socket socket = new Socket("localhost",444);
		PrintStream ps = new PrintStream(socket.getOutputStream());

		InputStreamReader ip = new InputStreamReader(socket.getInputStream());
		BufferedReader br = new BufferedReader(ip);
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("enter message");
			String message = sc.nextLine();
			ps.println(message);

			message = br.readLine();
			System.out.println(message);
		} while(true);
	}
}