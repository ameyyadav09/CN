import java.io.*;
import java.net.*;
import java.util.*;

public class ClientTCP {

	public static void main(String [] args) {
		try {
			Socket socket = new Socket("localhost",8001);
			PrintStream ps = new PrintStream(socket.getOutputStream());
			InputStreamReader ip = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(ip);
			Scanner sc = new Scanner(System.in);
			if (args[0] != null) {
				ps.println(args[0]);
				int count = 1;
				while(count <= 5) {
					System.out.println(br.readLine());
					System.out.println(br.readLine());
					String str = sc.nextLine();
					if(str != null)	{
						ps.println(str);
						System.out.println();
					}
					System.out.println(br.readLine());
					count++;
				}
				System.out.println();
				System.out.println(br.readLine()+" your total score is ");
				System.out.println(br.readLine());
			}
			else {
				System.out.println("enter roll num as command line argument");
			}
			ps.close();
			br.close();
			sc.close();
			socket.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}