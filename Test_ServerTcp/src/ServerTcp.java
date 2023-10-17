import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTcp {

	public static void main(String[] args) throws IOException {
		try {
			ServerSocket serverSocket = new ServerSocket(8585);
			System.out.println("-> Server en attente...");
			
			Socket clientSocket = serverSocket.accept();
			System.out.println("-> Connexion étalie avec le client.");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter writter = new PrintWriter(clientSocket.getOutputStream(), true);
			
			System.out.println(reader.readLine());
			writter.println("-> Message bien reçu !");
			
			reader.close();
			writter.close();
			clientSocket.close();
			serverSocket.close();
		} catch (Exception e) {
			System.err.println("[Error] " + e);
		}

	}

}
