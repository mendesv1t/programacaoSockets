package socketTCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HostTCP {

    public static void main(String[] args) throws IOException {
        {
            String clientSentence;
            String capitalizedSentence;
            Map<String, String> dicionario = new HashMap<>(0);


            // definindo dicionário com o tema de redes:
            dicionario.put("porta", "gateway");
            dicionario.put("redes", "network");
            dicionario.put("requisição", "request");
            dicionario.put("resposta", "response");
            dicionario.put("cabeçalho", "header");


            // adicionando chave e valor para casos de erro:
            dicionario.put("erro", "Nao conheco esta palavra.");

            ServerSocket welcomeSocket = new ServerSocket(8080);

            while (true) {
                Socket connectionSocket = welcomeSocket.accept();

                System.out.println("Nova conexão de: " + connectionSocket.getInetAddress().getHostName() + ":" + connectionSocket.getPort());

                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                clientSentence = inFromClient.readLine();

                if (dicionario.get(clientSentence) != null) {
                    capitalizedSentence = dicionario.get(clientSentence) + "\n";
                }
                else {
                    capitalizedSentence = dicionario.get("erro") + "\n";
                }
                outToClient.writeBytes(capitalizedSentence);
            }
        }
    }
}
