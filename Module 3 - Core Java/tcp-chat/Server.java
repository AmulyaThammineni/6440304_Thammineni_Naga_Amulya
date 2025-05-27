import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started, waiting for client...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromClient, fromServer;

        while ((fromClient = in.readLine()) != null) {
            System.out.println("Client: " + fromClient);
            if ("bye".equalsIgnoreCase(fromClient)) {
                break;
            }
            System.out.print("Server: ");
            fromServer = stdIn.readLine();
            out.println(fromServer);
            if ("bye".equalsIgnoreCase(fromServer)) {
                break;
            }
        }
        clientSocket.close();
        serverSocket.close();
    }
}
