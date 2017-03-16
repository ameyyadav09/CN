import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	
	public static void main(String [] args) throws Exception {
		new Client().run();
	}

	private void run() throws Exception {
		Socket socket = new Socket("localhost",8001);
		PrintStream ps = new PrintStream(socket.getOutputStream());
		InputStreamReader ip = new InputStreamReader(socket.getInputStream());
		BufferedReader br = new BufferedReader(ip);


		System.out.println("Enter rollnum");
		Scanner sc = new Scanner(System.in);
		String rollnum = sc.nextLine();

		if (rollnum != null) {
			ps.println(rollnum);
			String str = br.readLine();
			if (str != null) {
				System.out.println(str);
			}
			br.close();
			ps.close();
			sc.close();
		}
	}	
}