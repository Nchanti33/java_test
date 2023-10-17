import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.security.DrbgParameters.NextBytes;

public class ServerUdp {

	public static void main(String[] args) throws SocketException, Exception {
		try {
			//Initialization of server
			DatagramSocket serverSocket = new DatagramSocket(8585);
			System.out.println("-> Server en attente...");
			
			//Reception
			byte[] receivedBytes = new byte[256];
			DatagramPacket receivedPacket = new DatagramPacket(receivedBytes, receivedBytes.length);
			serverSocket.receive(receivedPacket);
			
			String message = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
			System.out.println(message);
			
			//Send (client response)
			String response = "-> Message bien reçu !";
			byte[] sendBytes = response.getBytes();
			
			InetAddress clientAddress = receivedPacket.getAddress();
			int clientPort = receivedPacket.getPort();
			
			DatagramPacket sendPacket = new DatagramPacket(sendBytes, sendBytes.length, clientAddress, clientPort);
			serverSocket.send(sendPacket);
			
			//End of resources
			if (!serverSocket.isClosed()) {
				serverSocket.close();
			}
		} catch (SocketException e) {
			System.err.println("[SocketError] " + e);
		} catch (Exception e) {
			System.err.println("[Error] " + e);
		}

	}

}
