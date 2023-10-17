import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientUdp {

	public static void main(String[] args) throws SocketException, UnknownHostException, Exception {
		try {
			//Initialization of client
			DatagramSocket clientSocket = new DatagramSocket();
			
			//Send
			String text = "-> Bonjour je suis le client.";
			byte[] sendBytes = text.getBytes();
			
			InetAddress serverAddress = InetAddress.getByName("localhost");
			
			DatagramPacket sendPacket = new DatagramPacket(sendBytes, sendBytes.length, serverAddress, 8585);
			clientSocket.send(sendPacket);
			
			//Reception
			byte[] receivedBytes = new byte[256];
			DatagramPacket receivedPacket = new DatagramPacket(receivedBytes, receivedBytes.length);
			clientSocket.receive(receivedPacket);
			
			String message = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
			System.out.println(message);
			
			//End of resources
			if (!clientSocket.isClosed()) {
				clientSocket.close();
			}
		} catch (SocketException e) {
			System.err.println("[AdressError] " + e.getMessage());
		} catch (UnknownHostException e) {
			System.err.println("[SocketError] " + e);
		} catch (Exception e) {
			System.err.println("[Error] " + e);
		}

	}

}
