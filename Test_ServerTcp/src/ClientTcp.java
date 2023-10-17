import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientTcp {

	public static void main(String[] args) throws IOException {
		try {
			Socket clientSocket = new Socket("localhost", 8585);

			BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter writter = new PrintWriter(clientSocket.getOutputStream(), true);
			
			writter.println("-> Coucou je suis le client.");
			System.out.println(reader.readLine());
			
			reader.close();
			writter.close();
			clientSocket.close();
		} catch (Exception e) {
			System.err.println("[Error] " + e);
		}

	}

}
