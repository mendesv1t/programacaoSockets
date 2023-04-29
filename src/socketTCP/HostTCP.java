package socketTCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class HostTCP {

    public static void main(String[] args) throws IOException {
        {
            String clientSentence;
            String capitalizedSentence;
            ServerSocket welcomeSocket = new ServerSocket(8080);

            while (true) {
                Socket connectionSocket = welcomeSocket.accept();

                System.out.println("Nova conexão de: " + connectionSocket.getInetAddress().getHostName() + ":" + connectionSocket.getPort());

                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                clientSentence = inFromClient.readLine();

                capitalizedSentence = clientSentence.toUpperCase() + "\n";

                outToClient.writeBytes(capitalizedSentence);
            }
        }
    }
}
