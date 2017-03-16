import java.util.*;
import java.io.*;
import java.net.*;

public class Client {

	public void run()throws Exception {
		DatagramSocket dSocket = new DatagramSocket();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the rollnum");
		Date date = new Date();
		
		byte [] array = (sc.nextLine()+"@"+date).getBytes(); //STUDENT@DATE
		InetAddress ip = InetAddress.getByName("localhost");
		int port = 2000;

		DatagramPacket dPacket = new DatagramPacket(array,array.length,ip,port);
		dSocket.send(dPacket); // sending packet

		byte [] receiver = new byte[1024];
		DatagramPacket receiverPacket = new DatagramPacket(receiver,receiver.length);
		dSocket.receive(receiverPacket);
		System.out.println(new String(receiverPacket.getData()).trim());
		dSocket.close();
	}
	
	public static void main(String [] args) throws Exception {
		
		Client object = new Client();
		object.run();
	}
}