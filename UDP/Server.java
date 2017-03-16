import java.util.*;
import java.io.*;
import java.net.*;

public class Server {

	public static void main (String [] args) throws Exception {

		DatagramSocket dSocket = new DatagramSocket(2000);
		byte [] receiver = new byte [1024];

		DatagramPacket receiverPacket = new DatagramPacket(receiver, receiver.length);
		dSocket.receive(receiverPacket);
		//receiving packet

		String rollnum = new String(receiverPacket.getData()).trim();
		rollnum = rollnum.substring(0,11);
		//parsing the rollnumber from string
		
		InetAddress ip = receiverPacket.getAddress();
		int port = receiverPacket.getPort();

		BufferedReader br = new BufferedReader(new FileReader("class.txt"));
		String str = "";

		while((str = br.readLine()) != null) {
			if (str.equals(rollnum)) {
				Date date = new Date();
				byte [] sendArray = (rollnum + " ---> " + date).getBytes();
				DatagramPacket senderPacket = new DatagramPacket(sendArray,sendArray.length,ip,port);
				System.out.println(new String(senderPacket.getData()));
				dSocket.send(senderPacket); //sending back packet
			}
		}

	}
}