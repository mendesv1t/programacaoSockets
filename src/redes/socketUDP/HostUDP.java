package redes.socketUDP;

import redes.Dicionario;
import redes.util.BytesUtil;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class HostUDP {
    public static void main(String args[]) throws Exception {

        String capitalizedSentence;

        DatagramSocket serverSocket = new DatagramSocket(8080);

        byte[] receiveData = new byte[1024];
        byte[] sendData;

        while(true) {
            Dicionario dicionario = new Dicionario();

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            System.out.println("Nova conexão de: " + receivePacket.getAddress().getHostName() + ":" + receivePacket.getPort());

            String sentence = new String(BytesUtil.trim(receivePacket.getData()));
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            String traducao = dicionario.traduzir(sentence);

            if (traducao != null) {
                capitalizedSentence = traducao + "\n";
            }
            else {
                capitalizedSentence = "Não conheço a tradução para esta palavra." + "\n";
            }

            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}
