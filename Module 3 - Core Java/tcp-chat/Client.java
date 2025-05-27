import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer, fromUser;

        while ((fromServer = in.readLine()) != null) {
            System.out.println("Server: " + fromServer);
            if ("bye".equalsIgnoreCase(fromServer)) {
                break;
            }
            System.out.print("Client: ");
            fromUser = stdIn.readLine();
            out.println(fromUser);
            if ("bye".equalsIgnoreCase(fromUser)) {
                break;
            }
        }
        socket.close();
    }
}
