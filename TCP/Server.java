import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
	
	public static void main (String [] args ) throws Exception {
		new Server ().run();
	}


	private void run () throws Exception {
		ServerSocket sersok = new ServerSocket(8001);
		Socket socket = sersok.accept();

		InputStreamReader ip = new InputStreamReader(socket.getInputStream());
		BufferedReader br = new BufferedReader(ip);

		String rollnum = br.readLine();
		Date date = new Date();

		BufferedReader br2 = new BufferedReader(new FileReader("class.txt"));
		String str = "";

		while ((str = br2.readLine()) != null) {
			if (str.equals(rollnum)) {
				PrintStream pr = new PrintStream(socket.getOutputStream());
				pr.println(rollnum + " ---> " +date);
			}
		}

	}
}