import java.io.*;
import java.net.*;
import java.util.*;

public class ServerTCP {

	public static void main(String [] args) {
		try {
			ServerSocket sersok = new ServerSocket(8001);
			Socket socket = sersok.accept();
			PrintStream ps = new PrintStream(socket.getOutputStream());
			InputStreamReader ip = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(ip);
			int count = 1, totalScore = 0;
			String [] questions = {"what is java", "What is C?", "where python?","what is haskell?","sun rises in the?"};

			String [] options = {"A)lang B)soft C)none D)eatable",
									"A)lang B)soft C)none D)eatable",
									"A)lang B)soft C)none D)eatable",
									"A)lang B)soft C)none D)eatable",
									"A)east B)west C)north D)south"};

			char [] answers = {'A','B','C','D','A'};

			String roll_num = br.readLine();
			int i = 0;
			while (count <= 5) {
				System.out.println(count);
				ps.println(questions[i]+"\n"+options[i]);
				char ans = br.readLine().charAt(0);
				if (ans == answers[i]) {
					totalScore += 4;
					ps.println("correct");
				}
				else {
					ps.println("wrong");	
				}
				count++;i++;
			}
			ps.println(roll_num);
			ps.println(totalScore);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}